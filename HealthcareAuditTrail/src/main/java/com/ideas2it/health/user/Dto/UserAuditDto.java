package com.ideas2it.health.user.Dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "UserAudit")
public class UserAuditDto {

	private String userName;

	private String eventType;

	private String eventSubType;

	private String eventRequest;

	private String eventResult;

	private String execDate;

	private String execTime;

	private String eventMethoadName;

	private String hostIp;

	public static Audit convertoUserAuditDto(UserAuditDto userAudit) throws ParseException {
		Audit userAuditDto = new Audit();
		userAuditDto.setUserName(userAudit.getUserName());
		userAuditDto.setHostIp(userAudit.getHostIp());
		userAuditDto.setExecTime(userAudit.getExecTime());
		String dt2 = userAudit.getExecDate();
		dt2 = dt2.replace("-", "/");
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dt2);
		userAuditDto.setExecDate(date1);
		userAuditDto.setEventType(userAudit.getEventType());
		userAuditDto.setEventSubType(userAudit.getEventSubType());
		userAuditDto.setEventResult(userAudit.getEventResult());
		userAuditDto.setEventRequest(userAudit.getEventRequest());
		userAuditDto.setEventMethoadName(userAudit.getEventMethoadName());
		return userAuditDto;
	}
}
