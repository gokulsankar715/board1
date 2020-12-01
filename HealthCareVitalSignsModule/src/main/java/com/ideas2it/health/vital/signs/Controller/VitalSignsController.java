package com.ideas2it.health.vital.signs.Controller;

import java.net.UnknownHostException;
import java.sql.Date;

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

import com.ideas2it.health.vital.signs.Advice.AuditTrailLogging;
import com.ideas2it.health.vital.signs.Dto.VitalSignDto;
import com.ideas2it.health.vital.signs.Service.VitalSignService;

@RestController
@RequestMapping("/vitalsigns")
public class VitalSignsController {

	@Lazy
	@Autowired
	public VitalSignsController(VitalSignService vitalSignService) {
		super();
		this.vitalSignService = vitalSignService;
	}

	private final VitalSignService vitalSignService;

	/* ADD the CheckUp Info & VitalSigns Details */
	@AuditTrailLogging
	@PostMapping("/")
	public VitalSignDto addCheckup(@RequestBody VitalSignDto vitalSignDto) throws UnknownHostException {
		return vitalSignService.addCheckup(vitalSignDto);
	}

	/* VitalSigns Details Based On Patient-ID */
	@AuditTrailLogging
	@GetMapping("/{patient_id}")
	public String getPatientDetails(@PathVariable long patient_id) {
		return vitalSignService.getPatientDetails(patient_id);
	}

	/* VitalSigns Details Based On Patient-ID and Date */
	@AuditTrailLogging
	@GetMapping("/{patient_id}/{patient_checkup_date}")
	public String getCheckupDetails(@PathVariable long patient_id, @PathVariable Date patient_checkup_date) {
		return vitalSignService.getCheckupDetails(patient_id, patient_checkup_date);
	}

	/* Update Checkup Details */
	@AuditTrailLogging
	@PutMapping("/{patient_id}/{patient_checkup_date}")
	public String updatePatient(@PathVariable long patient_id, @PathVariable Date patient_checkup_date,
			@RequestBody VitalSignDto vitalSignDto) {
		return vitalSignService.updatePatient(patient_id, patient_checkup_date, vitalSignDto);
	}

	/* Delete Checkup-Info */
	@AuditTrailLogging
	@DeleteMapping("/{patient_id}/{patient_checkup_date}")
	public String deleteCheckup(@PathVariable long patient_id, @PathVariable Date patient_checkup_date) {
		return vitalSignService.deleteCheckup(patient_id, patient_checkup_date);
	}
}
