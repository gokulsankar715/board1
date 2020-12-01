package com.ideas2it.health.vital.signs.Service;

import java.sql.Date;

import com.ideas2it.health.vital.signs.Dto.VitalSignDto;

public interface VitalSignService {

	public VitalSignDto addCheckup(VitalSignDto vitalSignDto);

	public String getCheckupDetails(long patient_id, Date patient_checkup_date);

	public String getPatientDetails(long patient_id);

	public String updatePatient(long patient_id, Date patient_checkup_date, VitalSignDto vitalSignDto);

	public String deleteCheckup(long patient_id, Date patient_checkup_date);

}
