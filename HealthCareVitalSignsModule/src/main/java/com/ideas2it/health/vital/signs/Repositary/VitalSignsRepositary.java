package com.ideas2it.health.vital.signs.Repositary;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ideas2it.health.vital.signs.Model.VitalSign;

public interface VitalSignsRepositary extends JpaRepository<VitalSign, Long> {

	List<VitalSign> findByPatientid(long patient_id);

	List<VitalSign> findByPatientidAndCheckupdate(long patient_id, Date patient_checkup_date);

}
