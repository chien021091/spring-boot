package com.laptrinhjavaweb.dto;

import lombok.Data;

@Data
public class CategoryDTO extends AbstractDTO<CategoryDTO> {
	private String name;
	private String code;
}
