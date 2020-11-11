package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.api.output.PhotoOutput;
import com.laptrinhjavaweb.dto.PhotoDTO;
import com.laptrinhjavaweb.service.IPhotoService;

@RestController
public class PhotoAPI {
	
	@Autowired
	private IPhotoService photoService; 
	
	@PostMapping(value = "/photo")
	public PhotoDTO
	createNew(@RequestBody PhotoDTO model) {
		PhotoDTO dto = photoService.save(model);
		return dto;
	}
	
	@PutMapping(value="/photo/{id}")
	public PhotoDTO updateNew(@RequestBody PhotoDTO model, @PathVariable("id") Long id) {
		model.setId(id);
		return photoService.save(model);
	}
	
	@DeleteMapping(value="/photo")
	public void deleteNew(@RequestBody long[] ids) {
		photoService.delete(ids);
	}
	
	@GetMapping(value="/photo/{id}")
	public PhotoDTO getPhoto(@PathVariable("id") Long id) {
		return photoService.get(id);
	}
	
	@GetMapping(value="/photos")
	public PhotoOutput showNew(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "limit", required = false) Integer limit) {
		PhotoOutput result = new PhotoOutput();
		if(page != null && limit != null) {
			result.setPage(page);
			result.setTotalPage((int)Math.ceil((double)(photoService.totalItem() / limit)));
			
			Pageable pageable = new PageRequest(page - 1, limit);
			result.setListResult(photoService.findAll(pageable));
		} else {
			result.setListResult(photoService.findAll());
		}
		
		return result;
	}
}
