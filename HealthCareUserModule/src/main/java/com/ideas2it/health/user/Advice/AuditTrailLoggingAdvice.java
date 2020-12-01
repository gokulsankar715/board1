package com.ideas2it.health.user.Advice;

import java.net.InetAddress;
import java.util.regex.Pattern;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideas2it.health.user.Dto.UserAuditDto;

@Aspect
@Component
public class AuditTrailLoggingAdvice {

	@Autowired
	public AuditTrailLoggingAdvice(KafkaTemplate<String, UserAuditDto> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	KafkaTemplate<String, UserAuditDto> kafkaTemplate;

	private static final String TOPIC_USER = "Healthcare_User";

	Logger logger = LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);

	@Around("@annotation(com.ideas2it.health.user.Advice.AuditTrailLogging)")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		UserAuditDto userAuditDto = new UserAuditDto();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		java.sql.Time time = new java.sql.Time(millis);
		InetAddress myHost = InetAddress.getLocalHost();
		String charToDel = "{[]}";
		String pat = "[" + Pattern.quote(charToDel) + "]";
		Object object = pjp.proceed();
		userAuditDto.setEventRequest(mapper.writeValueAsString(array).replaceAll(pat, ""));
		userAuditDto.setUserName(myHost.getHostName());
		userAuditDto.setHostIp(myHost.getHostAddress());
		userAuditDto.setExecDate(date.toString());
		userAuditDto.setExecTime(time.toString());
		userAuditDto.setEventMethoadName(methodName);
		userAuditDto.setEventType("USER-API");
		userAuditDto.setEventSubType(methodName);
		userAuditDto.setEventResult(mapper.writeValueAsString(object).replaceAll(pat, ""));
		kafkaTemplate.send(TOPIC_USER, userAuditDto);
		return object;
	}
}
