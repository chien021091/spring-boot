package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;


	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> list = categoryRepository.findAll();
		for(CategoryEntity item : list) {
			CategoryDTO dto = categoryConverter.toDTO(item);
			results.add(dto);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int)categoryRepository.count();
	}
}
