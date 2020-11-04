package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
			newRepository.delete(item);
		}
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> results = new ArrayList<>();
		List<NewsEntity> list = newRepository.findAll(pageable).getContent();
		for(NewsEntity item : list) {
			NewDTO dto = newConverter.toDTO(item);
			results.add(dto);
		}
		return results;
	}
	
	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> results = new ArrayList<>();
		List<NewsEntity> list = newRepository.findAll();
		for(NewsEntity item : list) {
			NewDTO dto = newConverter.toDTO(item);
			results.add(dto);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int)newRepository.count();
	}
}
