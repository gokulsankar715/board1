package com.ideas2it.health.patient.Model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pat_gen")
	@SequenceGenerator(initialValue = 200, allocationSize = 1000, name = "pat_gen")
	@Column(name = "patient_id")
	private long patientid;

	@Column(name = "patient_username")
	private String patientusername;

	@Column(name = "patient_firstname")
	private String patientfirstname;

	@Column(name = "patient_lastname")
	private String patientlastname;

	@Column(name = "patient_dob")
	private Date Dob;

	@Column(name = "patient_age")
	private int Age;

	@Column(name = "patient_gender")
	private String Gender;

	@Column(name = "patient_mobilenumber")
	private long mobilenumber;

	@Column(name = "patient_email")
	private String email;

	@Column(name = "patient_address1")
	private String address1;

	@Column(name = "patient_address2")
	private String address2;

	@Column(name = "patient_postalcode")
	private long postalcode;

	@Column(name = "patient_city")
	private String city;

	@Column(name = "patient_country")
	private String country;

	@Column(name = "patient_maritalstatus")
	private String maritalstatus;

	@Column(name = "patient_occupation")
	private String occupation;

	@Column(name = "patient_initial_reg_date")
	private Date initialregdate;

	@Column(name = "patient_last_reg_date")
	private Date lastregdate;

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updateAt;

}
