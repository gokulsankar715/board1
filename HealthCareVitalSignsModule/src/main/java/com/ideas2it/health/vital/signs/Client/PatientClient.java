package com.ideas2it.health.vital.signs.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ideas2it.health.vital.signs.Dto.PatientDto;

@FeignClient(url = "${healthcare.patient.uri}", name = "${healthcare.patient.name}")
public interface PatientClient {

	@GetMapping("/{patient_id}")
	public PatientDto getPatient(@PathVariable long patient_id);

	@PutMapping("/{patient_id}")
	public PatientDto updatePatient(@PathVariable long patient_id, @RequestBody PatientDto patientDto);
}
