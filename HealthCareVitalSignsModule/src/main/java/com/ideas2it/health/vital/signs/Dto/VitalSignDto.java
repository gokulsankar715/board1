package com.ideas2it.health.vital.signs.Dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VitalSignDto {
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
