package com.ideas2it.health.user.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas2it.health.user.Dto.UserAuditDto;
import com.ideas2it.health.user.Repositary.UserAuditRepositary;

@Service
public class kafkaservice {

	@Autowired
	private UserAuditRepositary userAuditRepositary;

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

	public List<UserAuditDto> findDatefilter(String execDate1, String execDate2) throws ParseException {
		List<UserAuditDto> userDetails = userAuditRepositary.findAll();
		execDate1 = execDate1.replace("-", "/");
		execDate2 = execDate2.replace("-", "/");
		Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(execDate1);
		Date date2 = new SimpleDateFormat("yyyy/MM/dd").parse(execDate2);
		List<UserAuditDto> samsa = new ArrayList<>();
		for (int i = 0; i < userDetails.size(); i++) {
			String event_date = userDetails.get(i).getExecDate().replace("-", "/");
			Date date = new SimpleDateFormat("yyyy/MM/dd").parse(event_date);
			if ((date1.equals(date)) | (date1.before(date) && date2.after(date)) | (date2.equals(date))) {
				samsa.add(userDetails.get(i));
			}
		}
		return samsa;
	}

}
