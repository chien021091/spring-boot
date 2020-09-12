package com.laptrinhjavaweb.converter;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewsEntity;

@Component
public class NewConverter {
	public NewsEntity toEntity(NewDTO newDTO) {
		NewsEntity ent = new NewsEntity();
		ent.setContent(newDTO.getContent());
		ent.setShortDescription(newDTO.getShortDescription());
		ent.setThumbnail(newDTO.getThumbnail());
		ent.setTitle(newDTO.getTitle());
		
		return ent;
	}
	
	public NewDTO toDTO(NewsEntity ent) {
		NewDTO dto = new NewDTO();
		if(ent.getId() != null) {
			dto.setId(ent.getId());
		}
		dto.setContent			(ent.getContent());
		dto.setShortDescription	(ent.getShortDescription());
		dto.setThumbnail		(ent.getThumbnail());
		dto.setTitle			(ent.getTitle());
		dto.setCreateddate		(ent.getCreateddate());
		dto.setCreatedby		(ent.getCreatedby());
		dto.setModifieddate		(ent.getModifieddate());
		dto.setModifiedby		(ent.getModifiedby());
		
		return dto;
	}
	
	public NewsEntity toEntity(NewDTO newDTO, NewsEntity ent) {
		ent.setContent(newDTO.getContent());
		ent.setShortDescription(newDTO.getShortDescription());
		ent.setThumbnail(newDTO.getThumbnail());
		ent.setTitle(newDTO.getTitle());
		
		return ent;
	}
}
