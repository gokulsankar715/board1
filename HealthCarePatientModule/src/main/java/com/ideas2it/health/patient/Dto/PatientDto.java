package com.ideas2it.health.patient.Dto;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import com.ideas2it.health.patient.Model.Patient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto implements Serializable {

	private static final long serialVersionUID = -2322707639818597448L;

	private long patientid;

	private String patientusername;

	private String patientfirstname;

	private String patientlastname;

	private Date Dob;

	private int Age;

	private String Gender;

	private long mobilenumber;

	private String email;

	private String address1;

	private String address2;

	private long postalcode;

	private String city;

	private String country;

	private String maritalstatus;

	private String occupation;

	private Date initialregdate;

	private Date lastregdate;

	private String createdBy;

	private LocalDateTime createdAt;

	private String updatedBy;

	private LocalDateTime updateAt;

	public static Patient ConvertPatientDomain(PatientDto patientDto) {
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
		patient.setCreatedAt(patientDto.getCreatedAt());
		patient.setUpdateAt(patientDto.getUpdateAt());
		return patient;
	}

	public static PatientDto ConvertPatientDto(Patient patient) {
		PatientDto patientDto = new PatientDto();
		patientDto.setAddress1(patient.getAddress1());
		patientDto.setAddress2(patient.getAddress2());
		patientDto.setAge(patient.getAge());
		patientDto.setCity(patient.getCity());
		patientDto.setCountry(patient.getCountry());
		patientDto.setDob(patient.getDob());
		patientDto.setEmail(patient.getEmail());
		patientDto.setGender(patient.getGender());
		patientDto.setInitialregdate(patient.getInitialregdate());
		patientDto.setLastregdate(patient.getLastregdate());
		patientDto.setMaritalstatus(patient.getMaritalstatus());
		patientDto.setMobilenumber(patient.getMobilenumber());
		patientDto.setOccupation(patient.getOccupation());
		patientDto.setPatientfirstname(patient.getPatientfirstname());
		patientDto.setPatientid(patient.getPatientid());
		patientDto.setPatientlastname(patient.getPatientlastname());
		patientDto.setPatientusername(patient.getPatientusername());
		patientDto.setPostalcode(patient.getPostalcode());
		patientDto.setCreatedBy(patient.getCreatedBy());
		patientDto.setUpdatedBy(patient.getUpdatedBy());
		patientDto.setCreatedAt(patient.getCreatedAt());
		patientDto.setUpdateAt(patient.getUpdateAt());
		return patientDto;
	}

}
