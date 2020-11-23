package com.example.elastic.demo.Model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
public class ElasticSwagger implements Serializable {

	@Id
	private int id;
	private String firstname;
	private String lastname;

	@CreatedDate
	private LocalDateTime createdat;

	@LastModifiedDate
	private LocalDateTime updatedat;

	@CreatedBy
	private String createBy;

	@LastModifiedBy
	private String updatedby;
}
