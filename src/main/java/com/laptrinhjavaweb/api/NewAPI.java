package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.service.INewService;

@RestController
public class NewAPI {
	
	@Autowired
	private INewService iNewService; 
	
	@PostMapping(value = "/new")
	public NewDTO createNew(@RequestBody NewDTO model) {
		return model;
	}
	
	@PutMapping(value="/new")
	public NewDTO updateNew(@RequestBody NewDTO model) {
		return model;
	}
	
	@DeleteMapping(value="/new")
	public void updateNew(@RequestBody long[] ids) {
	}
}
