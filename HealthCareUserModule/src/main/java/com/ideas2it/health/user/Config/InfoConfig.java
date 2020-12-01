package com.ideas2it.health.user.Config;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ideas2it.health.user.Repositary.UserRepositary;

@Component
public class InfoConfig implements InfoContributor {

	@Lazy
	@Autowired
	public InfoConfig(UserRepositary userRepositary) {
		super();
		this.userRepositary = userRepositary;
	}

	private final UserRepositary userRepositary;

	@Override
	public void contribute(Builder builder) {
		LinkedHashMap<String, Integer> userDetails = new LinkedHashMap<>();
		userDetails.put("Doctor-Count", userRepositary.rowcount(101));
		userDetails.put("Patient-Count", userRepositary.rowcount(104));
		userDetails.put("Surgeon-Count", userRepositary.rowcount(102));
		userDetails.put("Nurses-Count", userRepositary.rowcount(103));
		userDetails.put("Support-Staff-Count", userRepositary.rowcount(105));
		builder.withDetail("Staffs-Count", userDetails);

	}

}
