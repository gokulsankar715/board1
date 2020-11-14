package com.ideas2it.health.patient.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.health.patient.Model.Patient;

public interface PatientRepositary extends JpaRepository<Patient, Long> {

	Patient findByPatientid(long patient_id);

}
