package com.ideas2it.health.vital.signs.Manager;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.vital.signs.Dto.VitalSignDto;
import com.ideas2it.health.vital.signs.Model.VitalSign;
import com.ideas2it.health.vital.signs.Repositary.VitalSignsRepositary;

@Service
public class VitalSignManager {

	@Lazy
	@Autowired
	public VitalSignManager(VitalSignsRepositary vitalSignsRepositary) {
		super();
		this.vitalSignsRepositary = vitalSignsRepositary;
	}

	private final VitalSignsRepositary vitalSignsRepositary;

	public List<VitalSign> PatientInfo(long patient_id, Date patient_checkup_date) {
		return vitalSignsRepositary.findByPatientidAndCheckupdate(patient_id, patient_checkup_date);
	}

	public List<VitalSign> PatientDetails(long patient_id) {
		return vitalSignsRepositary.findByPatientid(patient_id);
	}

	public VitalSign AddCheckUpInfo(VitalSignDto vitalSignDto) {
		VitalSign vitalSign = new VitalSign();
		vitalSign.setBloodpressure(vitalSignDto.getBloodpressure());
		vitalSign.setBodytemperature(vitalSignDto.getBodytemperature());
		vitalSign.setCheckupdate(vitalSignDto.getCheckupdate());
		vitalSign.setCheckupid(vitalSignDto.getCheckupid());
		vitalSign.setPatientid(vitalSignDto.getPatientid());
		vitalSign.setPulserate(vitalSignDto.getPulserate());
		vitalSign.setRespirationrate(vitalSignDto.getRespirationrate());
		return vitalSignsRepositary.save(vitalSign);
	}

	public VitalSign UpdatePatient(VitalSign vitalSign) {

		return vitalSignsRepositary.save(vitalSign);
	}

}
