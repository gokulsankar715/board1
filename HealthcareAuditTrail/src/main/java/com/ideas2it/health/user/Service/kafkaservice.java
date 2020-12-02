package com.ideas2it.health.user.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Dto.Audit;
import com.ideas2it.health.user.Repositary.AuditRepositary;
import com.ideas2it.health.user.Repositary.UserAuditRepositary;

@Service
public class kafkaservice {

	@Autowired
	private UserAuditRepositary userAuditRepositary;

	@Autowired
	private AuditRepositary auditRepositary;

	public String findMethoadType(String methodOperation) {
		String result = "";
		if (methodOperation.startsWith("getAll")) {
			result = "RETRIVE-ALL";
		} else if (methodOperation.startsWith("get")) {
			result = "RETRIVE";
		} else if (methodOperation.startsWith("update")) {
			result = "UPDATE";
		} else if (methodOperation.startsWith("delete")) {
			result = "DELETE";
		} else if (methodOperation.startsWith("add")) {
			result = "CREATE";
		} else {
			result = "AUTHENTICATION";
		}
		return result;
	}

	public String findRequestType(String eventRequest) {
		String result = "";
		if (eventRequest.equals("") | eventRequest.equals(null)) {
			result = "-";
		} else {
			result = eventRequest;
		}
		return result;
	}

	public List<Audit> findDatefilter(String execDate1, String execDate2, String eventType) throws ParseException {
		List<Audit> result_all = auditRepositary.findByEventType(eventType);
		String dt1 = execDate1;
		String dt2 = execDate2;
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
}
