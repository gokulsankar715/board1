package com.ideas2it.health.patient.Controller;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.health.patient.Advice.AuditTrailLogging;
import com.ideas2it.health.patient.Dto.PatientDto;
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

	@AuditTrailLogging
	@PostMapping("/")
	public PatientDto addPatient(@RequestBody PatientDto patientDto) throws UnknownHostException {
		return patientService.addPatient(patientDto);
	}

	@AuditTrailLogging
	@GetMapping("/")
	public String getAllPatient() {
		return patientService.getAllPatient();
	}

	@AuditTrailLogging
	@GetMapping("/{patient_id}")
	public String getPatient(@PathVariable long patient_id) {
		return patientService.getPatient(patient_id);
	}

	@AuditTrailLogging
	@PutMapping("/{patient_id}")
	public String updatePatient(@PathVariable long patient_id, @RequestBody PatientDto patientDto) {
		return patientService.updatePatient(patient_id, patientDto);
	}

	@AuditTrailLogging
	@DeleteMapping("/{patient_id}")
	public String deletePatient(@PathVariable long patient_id) {
		return patientService.deletePatient(patient_id);
	}

}
