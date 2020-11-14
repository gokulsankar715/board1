package com.ideas2it.health.user.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Client.PatientClient;
import com.ideas2it.health.user.Client.VitalClient;
import com.ideas2it.health.user.Dto.PatientDto;
import com.ideas2it.health.user.Dto.VitalSignDto;

@Service
public class VitalSignsService {

	@Lazy
	@Autowired
	public VitalSignsService(VitalClient vitalClient, PatientClient patientClient) {
		super();
		this.vitalClient = vitalClient;
		this.patientClient = patientClient;
	}

	private final VitalClient vitalClient;
	private final PatientClient patientClient;

	public VitalSignDto AddCheckup(VitalSignDto vitalSignDto) {
		VitalSignDto vitalSignResponse = vitalClient.AddCheckUpInfo(vitalSignDto);
		PatientDto patientDto = patientClient.getPatient(vitalSignResponse.getPatientid());
		patientDto.setLastregdate(vitalSignResponse.getCheckupdate());
		patientClient.AddPatient(patientDto);
		return vitalSignResponse;
	}

	public List<VitalSignDto> getPatientInfo(long patient_id) {
		return vitalClient.PatientDetails(patient_id);
	}
}
