package com.ideas2it.health.user.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
