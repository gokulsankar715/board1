package com.ideas2it.health.patient.Advice;

import java.net.InetAddress;
import java.util.regex.Pattern;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ideas2it.health.patient.Dto.PatientAuditDto;

@Aspect
@Component
public class LoggingAdvice {

	@Autowired
	public LoggingAdvice(KafkaTemplate<String, PatientAuditDto> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}

	KafkaTemplate<String, PatientAuditDto> kafkaTemplate;
	private static final String TOPIC_PATIENT = "Healthcare_Patient";

	@Around("@annotation(com.ideas2it.health.patient.Advice.AuditTrailLogging)")
	public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		PatientAuditDto patientAuditDto = new PatientAuditDto();
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
		patientAuditDto.setEventRequest(mapper.writeValueAsString(array).replaceAll(pat, ""));
		patientAuditDto.setUserName(myHost.getHostName());
		patientAuditDto.setHostIp(myHost.getHostAddress());
		patientAuditDto.setExecDate(date.toString());
		patientAuditDto.setExecTime(time.toString());
		patientAuditDto.setEventMethoadName(methodName);
		patientAuditDto.setEventType("PATIENT-API");
		patientAuditDto.setEventSubType(methodName);
		patientAuditDto.setEventResult(mapper.writeValueAsString(object).replaceAll(pat, ""));
		kafkaTemplate.send(TOPIC_PATIENT, patientAuditDto);
		return object;
	}
}
