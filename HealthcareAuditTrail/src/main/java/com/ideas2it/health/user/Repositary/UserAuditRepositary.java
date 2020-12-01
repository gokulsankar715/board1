package com.ideas2it.health.user.Repositary;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ideas2it.health.user.Dto.UserAuditDto;

public interface UserAuditRepositary extends MongoRepository<UserAuditDto, String> {

	// void save(PatientAuditDto patientAuditDto);

}
