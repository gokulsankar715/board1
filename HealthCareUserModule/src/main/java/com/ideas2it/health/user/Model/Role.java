package com.ideas2it.health.user.Model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Role implements Serializable {

	@Id
	@Column(name = "role_id")
	private int role_id;

	@Column(name = "role_name")
	private String rolename;

	@OneToMany(targetEntity = User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id", referencedColumnName = "role_id")
	private List<User> roles;

	@CreatedBy
	@Column(name = "created_by")
	private String createdBy;

	@CreatedDate
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@LastModifiedBy
	@Column(name = "updated_by")
	private String updatedBy;

	@LastModifiedDate
	@Column(name = "updated_at")
	private LocalDateTime updateAt;
}
