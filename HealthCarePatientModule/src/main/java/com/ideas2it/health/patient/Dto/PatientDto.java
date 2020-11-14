package com.ideas2it.health.patient.Dto;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PatientDto {

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

}
