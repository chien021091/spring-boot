package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="news")
@Data
public class NewsEntity extends BaseEntity {
	@Column(name="title")
	private String title;
	
	@Column(name="thumbnail")
	private String thumbnail;
	
	@Column(name = "shortdescription")
	private String shortDescription;
	
	@Column(name="content")
	private String content;

	@ManyToOne
	@JoinColumn(name="category_id")
	private CategoryEntity category;
}	
