package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="photo")
@Data
public class PhotoEntity extends BaseEntity {
	@Column(name="photo")
	private String photo;
	
	@Column(name="title")
	private String title;
	
	
	@Column(name="category_id")
	private Integer categoryId;
}
