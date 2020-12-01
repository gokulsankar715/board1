package com.ideas2it.health.patient.Manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.patient.Dto.PatientDto;
import com.ideas2it.health.patient.Model.Patient;
import com.ideas2it.health.patient.Repositary.PatientRepositary;

@Service
public class PatientManager {

	@Lazy
	@Autowired
	public PatientManager(PatientRepositary patientRepositary) {
		super();
		this.patientRepositary = patientRepositary;
	}

	private final PatientRepositary patientRepositary;

	public PatientDto addPatient(PatientDto patientDto) {
		return patientDto.ConvertPatientDto(patientRepositary.save(patientDto.ConvertPatientDomain(patientDto)));
	}

	public String getAllPatient() {
		if (patientRepositary.findAll() != null) {
			return patientRepositary.findAll().toString();
		} else {
			return "Patients Info Not Available in DataBase";
		}
//		PatientDto patientDto = new PatientDto();
//		return patientRepositary.findAll().stream().map(a -> patientDto.ConvertPatientDto(a))
//				.collect(Collectors.toList());
	}

	public String getPatient(long patient_id) {
		if (patientRepositary.findByPatientid(patient_id) != null) {
			return patientRepositary.findByPatientid(patient_id).toString();
		} else {
			return String.format("Patient-Id : %1$s Not Available in Database", patient_id);
		}
		// return
		// patientDto.ConvertPatientDto(patientRepositary.findByPatientid(patient_id));
	}

	public String updatePatient(long patient_id, PatientDto patientDto) {
		if (patientRepositary.findByPatientid(patient_id) != null) {
			PatientDto patients = patientDto.ConvertPatientDto(patientRepositary.findByPatientid(patient_id));
			patients.setLastregdate(patientDto.getLastregdate());
			Patient patient = patientDto.ConvertPatientDomain(patients);
			return patientRepositary.save(patient).toString();
		} else {
			return String.format("patient-Id : %1$s Not Available in Database", patient_id);
		}

	}

	public String deletePatient(long patient_id) {
		if (patientRepositary.findByPatientid(patient_id) != null) {
			patientRepositary.delete(patientRepositary.findByPatientid(patient_id));
			return String.format("Patient-Id : %1$s Deleted Succesfully", patient_id);
		} else {
			return String.format("Patient-Id : %1$s Not Available in Database", patient_id);
		}

	}

}
