package com.ideas2it.health.user.Dto;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalSignDto implements Serializable {

	private long checkupid;

	private long patientid;

	private Date checkupdate;

	private float bodytemperature;

	private int pulserate;

	private int respirationrate;

	private int bloodpressure;

	private String createdBy;

	private LocalDateTime createdAt;

	private String updatedBy;

	private LocalDateTime updateAt;

}
