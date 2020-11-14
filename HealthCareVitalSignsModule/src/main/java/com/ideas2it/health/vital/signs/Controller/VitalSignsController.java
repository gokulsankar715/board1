package com.ideas2it.health.vital.signs.Controller;

import java.net.UnknownHostException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.health.vital.signs.Dto.VitalSignDto;
import com.ideas2it.health.vital.signs.Model.VitalSign;
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
	@PostMapping("/add-checkup")
	public VitalSign AddCheckUpInfo(@RequestBody VitalSignDto vitalSignDto) throws UnknownHostException {
		return vitalSignService.AddCheckUpInfo(vitalSignDto);
	}

	/* VitalSigns Details Based On Patient-ID */
	@GetMapping("/{patient_id}")
	public List<VitalSign> PatientDetails(@PathVariable long patient_id) {
		return vitalSignService.PatientDetails(patient_id);
	}

	/* VitalSigns Details Based On Patient-ID and Date */
	@GetMapping("/{patient_id}/info/{patient_checkup_date}")
	public List<VitalSign> PatientInfo(@PathVariable long patient_id, @PathVariable Date patient_checkup_date) {
		return vitalSignService.PatientInfo(patient_id, patient_checkup_date);
	}

	/* Update Vital Sign Details */
	@PostMapping("/{patient_id}/update/{patient_checkup_date}")
	public VitalSign UpdatePatient(@PathVariable long patient_id, @PathVariable Date patient_checkup_date,
			@RequestBody VitalSign vitalSignDto) throws UnknownHostException {
		return vitalSignService.UpdatePatient(patient_id, patient_checkup_date, vitalSignDto);
	}
}
