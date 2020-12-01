package com.ideas2it.health.user.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

	@GetMapping
	public List<Audit> getvalueAll(@RequestParam("startdate") String startdate, @RequestParam("enddate") String enddate)
			throws ParseException {
		List<Audit> result_all = auditRepositary.findAll();
//		String dt1 = "2020-10-12";
//		String dt2 = "2020-11-25";
		String dt1 = startdate;
		String dt2 = enddate;
		dt1 = dt1.replace("-", "/");
		dt2 = dt2.replace("-", "/");
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(dt1);
		Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(dt2);
		List<Audit> result = new ArrayList<>();
		for (int i = 0; i < result_all.size(); i++) {
			result_all.get(i).getExecDate().setHours(00);
			result_all.get(i).getExecDate().setMinutes(00);
			if ((date1.equals(result_all.get(i).getExecDate()))
					| (date1.before(result_all.get(i).getExecDate()) && date2.after(result_all.get(i).getExecDate()))
					| (date2.equals(result_all.get(i).getExecDate()))) {
				result.add(result_all.get(i));
			}
		}
		return result;
	}
//	@GetMapping
//	public List<UserAuditDto> dateFilter(@RequestParam("myparam") List<String> execDate) throws ParseException {
//		String s1 = execDate.get(0);
//		String s2 = execDate.get(1);
//		return kafkaservice.findDatefilter(s1, s2);
//	}
}
