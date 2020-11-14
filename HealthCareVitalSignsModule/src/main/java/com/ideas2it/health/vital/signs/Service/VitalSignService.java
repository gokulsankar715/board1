package com.ideas2it.health.vital.signs.Service;

import java.net.UnknownHostException;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ideas2it.health.vital.signs.Dto.VitalSignDto;
import com.ideas2it.health.vital.signs.Manager.VitalSignManager;
import com.ideas2it.health.vital.signs.Model.VitalSign;

@Service
public class VitalSignService {

	@Lazy
	@Autowired
	public VitalSignService(VitalSignManager vitalSignManager) {
		super();
		this.vitalSignManager = vitalSignManager;
	}

	private final VitalSignManager vitalSignManager;

//	public List<String> basicInfo() throws UnknownHostException {
//		java.util.Date date = new java.util.Date();
//		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//		java.sql.Time sqlTime = new java.sql.Time(date.getTime());
//		InetAddress addr;
//		addr = InetAddress.getLocalHost();
//		List<String> createInfo = new ArrayList<>();
//		createInfo.add(addr.getHostName());
//		createInfo.add(addr.getHostAddress());
//		createInfo.add(String.format("%1$s %2$s", sqlDate.toString(), sqlTime.toString()));
//		return createInfo;
//	}

	public VitalSign AddCheckUpInfo(VitalSignDto vitalSignDto) throws UnknownHostException {
		return vitalSignManager.AddCheckUpInfo(vitalSignDto);
	}

	public List<VitalSign> PatientInfo(long patient_id, Date patient_checkup_date) {
		return vitalSignManager.PatientInfo(patient_id, patient_checkup_date);
	}

	public List<VitalSign> PatientDetails(long patient_id) {
		return vitalSignManager.PatientDetails(patient_id);
	}

	public VitalSign UpdatePatient(long patient_id, Date patient_checkup_date, VitalSign vitalSignDto)
			throws UnknownHostException {
		VitalSign vitalSign = vitalSignManager.PatientInfo(patient_id, patient_checkup_date).get(0);
		vitalSign.setBloodpressure(vitalSignDto.getBloodpressure());
		return vitalSignManager.UpdatePatient(vitalSign);
	}

}
