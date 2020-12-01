package com.ideas2it.health.vital.signs.Advice;

import java.net.InetAddress;
import java.util.regex.Pattern;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideas2it.health.vital.signs.Dto.VitalSignAuditDto;

@Aspect
@Component
public class LoggingAdvice {

	@Autowired
	public LoggingAdvice(KafkaTemplate<String, VitalSignAuditDto> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	KafkaTemplate<String, VitalSignAuditDto> kafkaTemplate;

	private static final String TOPIC_VITAL_SIGNS = "Healthcare_Vital_Signs";

	// Logger logger = LoggerFactory.getLogger(ExecutionTimeTrackerAdvice.class);

	@Around("@annotation(com.ideas2it.health.vital.signs.Advice.AuditTrailLogging)")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		VitalSignAuditDto vitalSignAuditDto = new VitalSignAuditDto();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		java.sql.Time time = new java.sql.Time(millis);
		// logger.info("method invoked " + className + " : " + methodName + "()" +
		// "arguments : "
		// + mapper.writeValueAsString(array));
		InetAddress myHost = InetAddress.getLocalHost();
		String charToDel = "{[]}";
		String pat = "[" + Pattern.quote(charToDel) + "]";
		Object object = pjp.proceed();
		// logger.info(className + " : " + methodName + "()" + "Response : " +
		// mapper.writeValueAsString(object));
		vitalSignAuditDto.setEventRequest(mapper.writeValueAsString(array).replaceAll(pat, ""));
		vitalSignAuditDto.setUserName(myHost.getHostName());
		vitalSignAuditDto.setHostIp(myHost.getHostAddress());
		vitalSignAuditDto.setExecDate(date.toString());
		vitalSignAuditDto.setExecTime(time.toString());
		vitalSignAuditDto.setEventMethoadName(methodName);
		vitalSignAuditDto.setEventType("VITAL-SIGNS-API");
		vitalSignAuditDto.setEventSubType(methodName);
		vitalSignAuditDto.setEventResult(mapper.writeValueAsString(object).replaceAll(pat, ""));
		kafkaTemplate.send(TOPIC_VITAL_SIGNS, vitalSignAuditDto);
		return object;
	}
}
