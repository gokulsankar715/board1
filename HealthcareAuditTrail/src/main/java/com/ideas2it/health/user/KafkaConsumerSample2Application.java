package com.ideas2it.health.user;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.ideas2it.health.patient.Dto.PatientAuditDto;
import com.ideas2it.health.user.Dto.Audit;
import com.ideas2it.health.user.Dto.UserAuditDto;
import com.ideas2it.health.user.Repositary.AuditRepositary;
import com.ideas2it.health.user.Service.kafkaservice;
import com.ideas2it.health.vital.signs.Dto.VitalSignAuditDto;

@SpringBootApplication
public class KafkaConsumerSample2Application {

	private final kafkaservice kafkaservice;

	private final AuditRepositary auditRepositary;

	@Autowired
	public KafkaConsumerSample2Application(com.ideas2it.health.user.Service.kafkaservice kafkaservice,
			AuditRepositary auditRepositary) {
		super();
		this.kafkaservice = kafkaservice;
		this.auditRepositary = auditRepositary;
	}

	@KafkaListener(topics = "Healthcare_User", groupId = "group_healthuser", containerFactory = "healthkafkaListenerContainerFactory")
	public void consume(UserAuditDto userAuditDto) throws ParseException {
		userAuditDto.setEventSubType(kafkaservice.findMethoadType(userAuditDto.getEventMethoadName()));
		userAuditDto.setEventRequest(kafkaservice.findRequestType(userAuditDto.getEventRequest()));
		Audit audits = UserAuditDto.convertoUserAuditDto(userAuditDto);
		Date date = audits.getExecDate();
		date.setHours(05);
		date.setMinutes(30);
		audits.setExecDate(date);
		auditRepositary.save(audits);
		System.out.println(userAuditDto);
	}

	@KafkaListener(topics = "Healthcare_Patient", groupId = "group_healthpatient", containerFactory = "patientkafkaListenerContainerFactory")
	public void consume(PatientAuditDto patientAuditDto) throws ParseException {
		// UserAuditDto userAuditDto = new UserAuditDto();
		patientAuditDto.setEventSubType(kafkaservice.findMethoadType(patientAuditDto.getEventMethoadName()));
		patientAuditDto.setEventRequest(kafkaservice.findRequestType(patientAuditDto.getEventRequest()));
		Audit audits = PatientAuditDto.convertoUserAuditDto(patientAuditDto);
		Date date = audits.getExecDate();
		date.setHours(05);
		date.setMinutes(30);
		audits.setExecDate(date);
		auditRepositary.save(audits);
		System.out.println(patientAuditDto);
	}

	@KafkaListener(topics = "Healthcare_Vital_Signs", groupId = "group_healthvital", containerFactory = "vitalkafkaListenerContainerFactory")
	public void consume(VitalSignAuditDto vitalSignAuditDto) throws ParseException {
		// UserAuditDto userAuditDto = new UserAuditDto();
		vitalSignAuditDto.setEventSubType(kafkaservice.findMethoadType(vitalSignAuditDto.getEventMethoadName()));
		vitalSignAuditDto.setEventRequest(kafkaservice.findRequestType(vitalSignAuditDto.getEventRequest()));
		Audit audits = VitalSignAuditDto.convertoUserAuditDto(vitalSignAuditDto);
		Date date = audits.getExecDate();
		date.setHours(05);
		date.setMinutes(30);
		audits.setExecDate(date);
		auditRepositary.save(audits);
		System.out.println(vitalSignAuditDto);
	}

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerSample2Application.class, args);
	}

}
