package com.laptrinhjavaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private NewConverter newConverter;

	@Override
	public NewDTO save(NewDTO newDto) {
		NewsEntity newEntity = new NewsEntity();
		if(newDto.getId() != null) {
			NewsEntity oldNew =  newRepository.findOne(newDto.getId());
			if(oldNew == null)	return null;
			
			newEntity = newConverter.toEntity(newDto, oldNew);
		} else {
			newEntity = newConverter.toEntity(newDto);
		}
		
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDto.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toDTO(newEntity);
		
	}

//	@Override
//	public NewDTO update(NewDTO newDto) {
//		NewsEntity oldNew =  newRepository.findOne(newDto.getId());
//		
//		if(oldNew == null)	return null;
//		
//		NewsEntity newEnt = newConverter.toEntity(newDto, oldNew);
//		
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDto.getCategoryCode());
//		newEnt.setCategory(categoryEntity);
//		newEnt = newRepository.save(newEnt);
//		return newConverter.toDTO(newEnt);
//	}
}
