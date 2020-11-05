package com.laptrinhjavaweb.dto;

import lombok.Data;

@Data
public class PhotoDTO extends AbstractDTO<PhotoDTO> {
	private String title;
	private String photo;
	private String categoryCode;
	private Integer categoryId;
}
