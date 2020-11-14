package com.ideas2it.health.patient.Manager;

import java.util.List;

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

	public Patient addPatient(PatientDto patientDto) {
		Patient patient = new Patient();
		patient.setAddress1(patientDto.getAddress1());
		patient.setAddress2(patientDto.getAddress2());
		patient.setAge(patientDto.getAge());
		patient.setCity(patientDto.getCity());
		patient.setCountry(patientDto.getCountry());
		patient.setDob(patientDto.getDob());
		patient.setEmail(patientDto.getEmail());
		patient.setGender(patientDto.getGender());
		patient.setInitialregdate(patientDto.getInitialregdate());
		patient.setLastregdate(patientDto.getLastregdate());
		patient.setMaritalstatus(patientDto.getMaritalstatus());
		patient.setMobilenumber(patientDto.getMobilenumber());
		patient.setOccupation(patientDto.getOccupation());
		patient.setPatientfirstname(patientDto.getPatientfirstname());
		patient.setPatientid(patientDto.getPatientid());
		patient.setPatientlastname(patientDto.getPatientlastname());
		patient.setPatientusername(patientDto.getPatientusername());
		patient.setPostalcode(patientDto.getPostalcode());
		patient.setCreatedBy(patientDto.getCreatedBy());
		patient.setUpdatedBy(patientDto.getUpdatedBy());
		return patientRepositary.save(patient);
	}

	public List<Patient> getAllPatient() {
		return patientRepositary.findAll();
	}

	public Patient getPatient(long patient_id) {
		return patientRepositary.findByPatientid(patient_id);
	}

}
