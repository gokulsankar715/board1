package com.ideas2it.health.patient.Service;

import com.ideas2it.health.patient.Dto.PatientDto;

public interface PatientService {

	public PatientDto addPatient(PatientDto patientDto);

	public String getAllPatient();

	public String getPatient(long patient_id);

	public String updatePatient(long patient_id, PatientDto patientDto);

	public String deletePatient(long patient_id);
}
