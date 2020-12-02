package com.ideas2it.health.patient.Dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ideas2it.health.user.Dto.Audit;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "AuditPatient")
public class PatientAuditDto {

	private String userName;

	private String eventType;

	private String eventSubType;

	private String eventRequest;

	private String eventResult;

	private String execDate;

	private String execTime;

	private String eventMethoadName;

	private String hostIp;

	public static Audit convertoUserAuditDto(PatientAuditDto patientAuditDto) throws ParseException {
		Audit userAuditDto = new Audit();
		userAuditDto.setUserName(patientAuditDto.getUserName());
		userAuditDto.setHostIp(patientAuditDto.getHostIp());
		userAuditDto.setExecTime(patientAuditDto.getExecTime());
		String dt2 = patientAuditDto.getExecDate();
		dt2 = dt2.replace("-", "/");
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dt2);
		userAuditDto.setExecDate(date1);
		userAuditDto.setEventType(patientAuditDto.getEventType());
		userAuditDto.setEventSubType(patientAuditDto.getEventSubType());
		userAuditDto.setEventResult(patientAuditDto.getEventResult());
		userAuditDto.setEventRequest(patientAuditDto.getEventRequest());
		userAuditDto.setEventMethoadName(patientAuditDto.getEventMethoadName());
		userAuditDto.getExecDate().setHours(0);
		userAuditDto.getExecDate().setMinutes(0);
		return userAuditDto;
	}
}
