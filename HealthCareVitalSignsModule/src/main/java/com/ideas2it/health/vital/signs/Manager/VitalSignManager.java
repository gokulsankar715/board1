package com.ideas2it.health.vital.signs.Manager;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.vital.signs.Client.PatientClient;
import com.ideas2it.health.vital.signs.Dto.PatientDto;
import com.ideas2it.health.vital.signs.Dto.VitalSignDto;
import com.ideas2it.health.vital.signs.Model.VitalSign;
import com.ideas2it.health.vital.signs.Repositary.VitalSignsRepositary;

@Service
public class VitalSignManager {

	@Lazy
	@Autowired
	public VitalSignManager(VitalSignsRepositary vitalSignsRepositary, PatientClient patientClient) {
		super();
		this.vitalSignsRepositary = vitalSignsRepositary;
		this.patientClient = patientClient;
	}

	private final VitalSignsRepositary vitalSignsRepositary;
	private final PatientClient patientClient;

	public String getCheckupDetails(long patient_id, Date patient_checkup_date) throws NullPointerException {
		// VitalSignDto vitalSignDto = new VitalSignDto();
		if (vitalSignsRepositary.findByPatientidAndCheckupdate(patient_id, patient_checkup_date) != null) {
			return vitalSignsRepositary.findByPatientidAndCheckupdate(patient_id, patient_checkup_date).toString();
		} else {
			return String.format("Checkup-Info Not Available in the patient-Id : %1$s & checkup-date : %2$s",
					patient_id, patient_checkup_date);
		}

	}

	public String getPatientDetails(long patient_id) {
		if (vitalSignsRepositary.findByPatientid(patient_id) != null) {
			return vitalSignsRepositary.findByPatientid(patient_id).toString();
		} else {
			return String.format("Checkup-Info Not Available in the patient-Id : %1$s", patient_id);
		}
	}

	public VitalSignDto addCheckup(VitalSignDto vitalSignDto) {
		PatientDto patientDto = patientClient.getPatient(vitalSignDto.getPatientid());
		patientDto.setLastregdate(vitalSignDto.getCheckupdate());
		patientClient.updatePatient(vitalSignDto.getPatientid(), patientDto);
		return vitalSignDto
				.convertVitalSignDto(vitalSignsRepositary.save(vitalSignDto.convertVitalSignDomain(vitalSignDto)));
	}

	public String updatePatient(long patient_id, Date patient_checkup_date, VitalSignDto vitalSignDto) {
		if (vitalSignsRepositary.findByPatientidAndCheckupdate(patient_id, patient_checkup_date) != null) {
			VitalSignDto vitals = vitalSignDto.convertVitalSignDto(
					vitalSignsRepositary.findByPatientidAndCheckupdate(patient_id, patient_checkup_date));
			vitals.setBloodpressure(vitalSignDto.getBloodpressure());
			vitals.setBodytemperature(vitalSignDto.getBodytemperature());
			vitals.setPulserate(vitalSignDto.getPulserate());
			vitals.setRespirationrate(vitalSignDto.getRespirationrate());
			VitalSign vitalSign = vitalSignDto.convertVitalSignDomain(vitals);
			return vitalSignsRepositary.save(vitalSign).toString();
		} else {
			return String.format("Checkup-Info Not Available in the patient-Id : %1$s & checkup-date : %2$s",
					patient_id, patient_checkup_date);
		}
	}

	public String deleteCheckup(long patient_id, Date patient_checkup_date) {
		if (vitalSignsRepositary.findByPatientidAndCheckupdate(patient_id, patient_checkup_date) != null) {

			vitalSignsRepositary
					.delete(vitalSignsRepositary.findByPatientidAndCheckupdate(patient_id, patient_checkup_date));
			return String.format("Patient-ID %1$s Checkup-Date %2$s Deleted Succesfully", patient_id,
					patient_checkup_date);
		} else {
			return String.format("Checkup-Info Not Available in the patient-Id : %1$s & checkup-date : %2$s",
					patient_id, patient_checkup_date);
		}
	}

}
