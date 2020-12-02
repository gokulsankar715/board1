package com.ideas2it.health.user.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ideas2it.health.user.Dto.Audit;
import com.ideas2it.health.user.Repositary.AuditRepositary;
import com.ideas2it.health.user.Service.kafkaservice;

@RestController
@RequestMapping("/audits")
public class UserAuditController {

	private final kafkaservice kafkaservice;

	private final AuditRepositary auditRepositary;

	@Autowired
	public UserAuditController(com.ideas2it.health.user.Service.kafkaservice kafkaservice,
			AuditRepositary auditRepositary) {
		super();
		this.kafkaservice = kafkaservice;
		this.auditRepositary = auditRepositary;
	}

	@GetMapping("/user")
	public List<Audit> getUserAudit(@RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate) throws ParseException {
		String eventType = "USER-API";
		return kafkaservice.findDatefilter(startdate, enddate, eventType);
	}

	@GetMapping("/patient")
	public List<Audit> getPatientAudit(@RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate) throws ParseException {
		String eventType = "PATIENT-API";
		return kafkaservice.findDatefilter(startdate, enddate, eventType);
	}

	@GetMapping("/vital")
	public List<Audit> getVitalAudit(@RequestParam("startdate") String startdate,
			@RequestParam("enddate") String enddate) throws ParseException {
		String eventType = "VITAL-SIGNS-API";
		return kafkaservice.findDatefilter(startdate, enddate, eventType);
	}
}
