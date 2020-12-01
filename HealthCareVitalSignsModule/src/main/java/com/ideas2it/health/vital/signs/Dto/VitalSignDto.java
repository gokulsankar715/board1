package com.ideas2it.health.vital.signs.Dto;

import java.sql.Date;
import java.time.LocalDateTime;

import com.ideas2it.health.vital.signs.Model.VitalSign;

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

	public VitalSign convertVitalSignDomain(VitalSignDto vitalSignDto) {
		VitalSign vitalSign = new VitalSign();
		vitalSign.setBloodpressure(vitalSignDto.getBloodpressure());
		vitalSign.setBodytemperature(vitalSignDto.getBodytemperature());
		vitalSign.setCheckupdate(vitalSignDto.getCheckupdate());
		vitalSign.setCheckupid(vitalSignDto.getCheckupid());
		vitalSign.setPatientid(vitalSignDto.getPatientid());
		vitalSign.setPulserate(vitalSignDto.getPulserate());
		vitalSign.setRespirationrate(vitalSignDto.getRespirationrate());
		vitalSign.setCreatedAt(vitalSignDto.getCreatedAt());
		vitalSign.setCreatedBy(vitalSignDto.getCreatedBy());
		vitalSign.setUpdateAt(vitalSignDto.getUpdateAt());
		vitalSign.setUpdatedBy(vitalSignDto.getUpdatedBy());
		return vitalSign;
	}

	public VitalSignDto convertVitalSignDto(VitalSign vitalSign) {
		VitalSignDto vitalSignDto = new VitalSignDto();
		vitalSignDto.setBloodpressure(vitalSign.getBloodpressure());
		vitalSignDto.setBodytemperature(vitalSign.getBodytemperature());
		vitalSignDto.setCheckupdate(vitalSign.getCheckupdate());
		vitalSignDto.setCheckupid(vitalSign.getCheckupid());
		vitalSignDto.setPatientid(vitalSign.getPatientid());
		vitalSignDto.setPulserate(vitalSign.getPulserate());
		vitalSignDto.setRespirationrate(vitalSign.getRespirationrate());
		vitalSignDto.setCreatedAt(vitalSign.getCreatedAt());
		vitalSignDto.setCreatedBy(vitalSign.getCreatedBy());
		vitalSignDto.setUpdateAt(vitalSign.getUpdateAt());
		vitalSignDto.setUpdatedBy(vitalSign.getUpdatedBy());
		return vitalSignDto;
	}

}
