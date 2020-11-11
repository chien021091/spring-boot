package com.laptrinhjavaweb.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.service.ICategoryService;

@RestController
public class CategoryAPI {
	
	@Autowired
	private ICategoryService categoryService; 
	
	@GetMapping(value="/categorys")
	public List<CategoryDTO> showNew() {
		return categoryService.findAll();
	}
}
