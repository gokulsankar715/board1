package com.ideas2it.health.patient.Controller;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.health.patient.Dto.PatientDto;
import com.ideas2it.health.patient.Model.Patient;
import com.ideas2it.health.patient.Service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Lazy
	@Autowired
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	private final PatientService patientService;

	@GetMapping("/")
	public String intro() {
		return "Weclome Patient";
	}

	@PostMapping("/add-patient")
	public Patient AddPatient(@RequestBody PatientDto patientDto) throws UnknownHostException {
		return patientService.addPatient(patientDto);
	}

	@GetMapping("/info")
	public List<Patient> getAllPatient() {
		return patientService.getAllPatient();
	}

	@GetMapping("/{patient_id}")
	public Patient getPatient(@PathVariable long patient_id) {
		return patientService.getPatient(patient_id);
	}

}
