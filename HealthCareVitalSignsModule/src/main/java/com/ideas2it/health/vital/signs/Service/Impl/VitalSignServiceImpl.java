package com.ideas2it.health.vital.signs.Service.Impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.vital.signs.Dto.VitalSignDto;
import com.ideas2it.health.vital.signs.Manager.VitalSignManager;
import com.ideas2it.health.vital.signs.Service.VitalSignService;

@Service
public class VitalSignServiceImpl implements VitalSignService {

	@Lazy
	@Autowired
	public VitalSignServiceImpl(VitalSignManager vitalSignManager) {
		super();
		this.vitalSignManager = vitalSignManager;
	}

	private final VitalSignManager vitalSignManager;

	public VitalSignDto addCheckup(VitalSignDto vitalSignDto) {
		return vitalSignManager.addCheckup(vitalSignDto);
	}

	public String getCheckupDetails(long patient_id, Date patient_checkup_date) throws NullPointerException {
		return vitalSignManager.getCheckupDetails(patient_id, patient_checkup_date);
	}

	public String getPatientDetails(long patient_id) {
		return vitalSignManager.getPatientDetails(patient_id);
	}

	public String updatePatient(long patient_id, Date patient_checkup_date, VitalSignDto vitalSignDto) {
		return vitalSignManager.updatePatient(patient_id, patient_checkup_date, vitalSignDto);
	}

	public String deleteCheckup(long patient_id, Date patient_checkup_date) {
		return vitalSignManager.deleteCheckup(patient_id, patient_checkup_date);
	}

}
