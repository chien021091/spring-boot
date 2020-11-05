package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="category")
@Data
public class CategoryEntity extends BaseEntity {
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	@OneToMany(mappedBy = "category")
	private List<NewsEntity> news = new ArrayList<NewsEntity>();
}
