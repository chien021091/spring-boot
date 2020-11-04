package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.converter.PhotoConverter;
import com.laptrinhjavaweb.dto.PhotoDTO;
import com.laptrinhjavaweb.dto.PhotoDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.PhotoEntity;
import com.laptrinhjavaweb.entity.PhotoEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.repository.PhotoRepository;
import com.laptrinhjavaweb.service.INewService;
import com.laptrinhjavaweb.service.IPhotoService;

@Service
public class PhotoService implements IPhotoService {

	@Autowired
	private PhotoRepository photoRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private PhotoConverter photoConverter;

	@Override
	public PhotoDTO save(PhotoDTO photoDto) {
		PhotoEntity newEntity = new PhotoEntity();
		if(photoDto.getId() != null) {
			PhotoEntity oldNew =  photoRepository.findOne(photoDto.getId());
			if(oldNew == null)	return null;
			
			newEntity = photoConverter.toEntity(photoDto, oldNew);
		} else {
			newEntity = photoConverter.toEntity(photoDto);
		}
		
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(photoDto.getCategoryCode());
		newEntity.setCategory(categoryEntity);
		newEntity = photoRepository.save(newEntity);
		return photoConverter.toDTO(newEntity);
		
	}

	@Override
	public void delete(long[] ids) {
		for(long item : ids) {
			photoRepository.delete(item);
		}
	}

	@Override
	public List<PhotoDTO> findAll(Pageable pageable) {
		List<PhotoDTO> results = new ArrayList<>();
		List<PhotoEntity> list = photoRepository.findAll(pageable).getContent();
		for(PhotoEntity item : list) {
			PhotoDTO dto = photoConverter.toDTO(item);
			results.add(dto);
		}
		return results;
	}
	
	@Override
	public List<PhotoDTO> findAll() {
		List<PhotoDTO> results = new ArrayList<>();
		List<PhotoEntity> list = photoRepository.findAll();
		for(PhotoEntity item : list) {
			PhotoDTO dto = photoConverter.toDTO(item);
			results.add(dto);
		}
		return results;
	}

	@Override
	public int totalItem() {
		return (int)photoRepository.count();
	}
}
