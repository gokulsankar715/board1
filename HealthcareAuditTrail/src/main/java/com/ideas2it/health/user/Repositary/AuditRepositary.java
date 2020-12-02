package com.ideas2it.health.user.Repositary;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ideas2it.health.user.Dto.Audit;

public interface AuditRepositary extends MongoRepository<Audit, String> {
	@Query(value = "{'execdate':{ $gte: ?0, $lte: ?1}}") // , $lte: ?1
	List<Audit> findByExecDateBetween(Date date1, Date date2);

	List<Audit> findByEventType(String eventType);

}
