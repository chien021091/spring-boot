package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.entity.PhotoEntity;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Long> {
	
}
