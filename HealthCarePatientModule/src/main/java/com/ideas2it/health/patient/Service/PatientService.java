package com.ideas2it.health.patient.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.patient.Dto.PatientDto;
import com.ideas2it.health.patient.Manager.PatientManager;
import com.ideas2it.health.patient.Model.Patient;

@Service
public class PatientService {

	@Lazy
	@Autowired
	public PatientService(PatientManager patientManager) {
		super();
		this.patientManager = patientManager;
	}

	private final PatientManager patientManager;

	public Patient addPatient(PatientDto patientDto) {
		return patientManager.addPatient(patientDto);
	}

	public List<Patient> getAllPatient() {
		return patientManager.getAllPatient();
	}

	public Patient getPatient(long patient_id) {
		return patientManager.getPatient(patient_id);
	}

}
