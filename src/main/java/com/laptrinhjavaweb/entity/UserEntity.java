package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class UserEntity extends BaseEntity {
	
	public static final int STAT_ACTIVE 	= 1;
	public static final int STAT_DEACTIVE 	= 2;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="fullname")
	private String fullName;
	
	@Column(name="status")
	private Integer status;
	
	//tao bang trung gian
	@ManyToMany
	@JoinTable(name="user_role",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="role_id")
			)
	private List<RoleEntity> roles = new ArrayList<RoleEntity>();
}
