package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.PhotoDTO;

public interface IPhotoService {
	PhotoDTO save (PhotoDTO newDto);
	void delete(long[] ids);
	List<PhotoDTO> findAll(Pageable pageable);
	List<PhotoDTO> findAll();
	int totalItem();
	PhotoDTO get(long id);
}
