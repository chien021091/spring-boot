package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="role")
@Data
public class RoleEntity extends BaseEntity {
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users = new ArrayList<UserEntity>();
}
