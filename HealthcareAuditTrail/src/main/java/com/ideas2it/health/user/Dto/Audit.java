package com.ideas2it.health.user.Dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Audit")
public class Audit {

	private String userName;

	private String eventType;

	private String eventSubType;

	private String eventRequest;

	private String eventResult;

	private Date execDate;

	private String execTime;

	private String eventMethoadName;

	private String hostIp;

}
