package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

@Component
public class CategoryConverter {
	
	public CategoryDTO toDTO(CategoryEntity ent) {
		CategoryDTO dto = new CategoryDTO();
		if(ent.getId() != null) {
			dto.setId(ent.getId());
		}
		dto.setCode				(ent.getCode());
		dto.setName				(ent.getName());
		dto.setCreateddate		(ent.getCreateddate());
		dto.setCreatedby		(ent.getCreatedby());
		dto.setModifieddate		(ent.getModifieddate());
		dto.setModifiedby		(ent.getModifiedby());
		
		return dto;
	}
}
