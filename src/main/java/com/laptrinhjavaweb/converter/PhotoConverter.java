package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.PhotoDTO;
import com.laptrinhjavaweb.entity.PhotoEntity;

@Component
public class PhotoConverter {
	public PhotoEntity toEntity(PhotoDTO photoDTO) {
		PhotoEntity ent = new PhotoEntity();
		
		ent.setTitle(photoDTO.getTitle());
		ent.setPhoto(photoDTO.getPhoto());
		ent.setCategoryId(photoDTO.getCategoryId());
		
		return ent;
	}
	
	public PhotoDTO toDTO(PhotoEntity ent) {
		PhotoDTO dto = new PhotoDTO();
		if(ent.getId() != null) {
			dto.setId(ent.getId());
		}
		dto.setPhoto			(ent.getPhoto());
		dto.setTitle			(ent.getTitle());
		dto.setCreateddate		(ent.getCreateddate());
		dto.setCreatedby		(ent.getCreatedby());
		dto.setModifieddate		(ent.getModifieddate());
		dto.setModifiedby		(ent.getModifiedby());
		dto.setCategoryId		(ent.getCategoryId());
		
		return dto;
	}
	
	public PhotoEntity toEntity(PhotoDTO photoDTO, PhotoEntity ent) {
		ent.setPhoto(photoDTO.getPhoto());
		ent.setTitle(photoDTO.getTitle());
		ent.setCategoryId(photoDTO.getCategoryId());
		
		return ent;
	}
}
