package com.ideas2it.health.user.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ideas2it.health.user.Dto.PatientDto;

@FeignClient(url = "${healthcare.patient.uri}", name = "${healthcare.patient.name}")
public interface PatientClient {

	@GetMapping("/info")
	public List<PatientDto> getAllPatient();

	@GetMapping("/{patient_id}")
	public PatientDto getPatient(@PathVariable long patient_id);

	@PostMapping("/add-patient")
	public PatientDto AddPatient(@RequestBody PatientDto patient);
}
