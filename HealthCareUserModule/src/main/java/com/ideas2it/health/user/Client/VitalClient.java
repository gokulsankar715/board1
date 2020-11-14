package com.ideas2it.health.user.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ideas2it.health.user.Dto.VitalSignDto;

@FeignClient(url = "${healthcare.vitalsign.uri}", name = "${healthcare.vitalsign.name}")
public interface VitalClient {

	@PostMapping("/add-checkup")
	public VitalSignDto AddCheckUpInfo(@RequestBody VitalSignDto vitalSignDto);

	@GetMapping("/{patient_id}")
	public List<VitalSignDto> PatientDetails(@PathVariable long patient_id);

}
