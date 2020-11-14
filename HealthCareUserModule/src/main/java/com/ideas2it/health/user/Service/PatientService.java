package com.ideas2it.health.user.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Client.PatientClient;
import com.ideas2it.health.user.Dto.PatientDto;

@Service
public class PatientService {

	@Lazy
	@Autowired
	public PatientService(PatientClient patientClient) {
		super();
		this.patientClient = patientClient;
	}

	private final PatientClient patientClient;

	public List<PatientDto> getAllPatient() {
		return patientClient.getAllPatient();
	}

	public PatientDto getPatient(long patient_id) {
		return patientClient.getPatient(patient_id);
	}

	public PatientDto AddPatient(PatientDto patientDto) {
		return patientClient.AddPatient(patientDto);
	}

}
