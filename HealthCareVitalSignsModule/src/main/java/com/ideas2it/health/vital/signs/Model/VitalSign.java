package com.ideas2it.health.vital.signs.Model;

import java.io.Serializable;
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
@Table(name = "vital_signs_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class VitalSign implements Serializable {

	private static final long serialVersionUID = 6313577177732488030L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen")
	@SequenceGenerator(initialValue = 1, allocationSize = 100, name = "gen")
	@Column(name = "patient_checkup_id")
	private long checkupid;

	@Column(name = "patient_id")
	private long patientid;

	@Column(name = "patient_checkup_date")
	private Date checkupdate;

	@Column(name = "patient_body_temperature")
	private float bodytemperature;

	@Column(name = "patient_pulse_rate")
	private int pulserate;

	@Column(name = "patient_respiration_rate")
	private int respirationrate;

	@Column(name = "patient_blood_pressure")
	private int bloodpressure;

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