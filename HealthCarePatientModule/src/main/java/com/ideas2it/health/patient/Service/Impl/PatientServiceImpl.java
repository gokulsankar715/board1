package com.ideas2it.health.patient.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.patient.Dto.PatientDto;
import com.ideas2it.health.patient.Manager.PatientManager;
import com.ideas2it.health.patient.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Lazy
	@Autowired
	public PatientServiceImpl(PatientManager patientManager) {
		super();
		this.patientManager = patientManager;
	}

	private final PatientManager patientManager;

	public PatientDto addPatient(PatientDto patientDto) {
		return patientManager.addPatient(patientDto);
	}

	public String getAllPatient() {
		return patientManager.getAllPatient();
	}

	public String getPatient(long patient_id) {
		return patientManager.getPatient(patient_id);
	}

	public String updatePatient(long patient_id, PatientDto patientDto) {
		return patientManager.updatePatient(patient_id, patientDto);
	}

	public String deletePatient(long patient_id) {
		return patientManager.deletePatient(patient_id);
	}

}
