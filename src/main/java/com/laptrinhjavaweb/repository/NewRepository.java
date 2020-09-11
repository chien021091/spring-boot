package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.NewsEntity;

public interface NewRepository extends JpaRepository<NewsEntity, Long> {
	
}
