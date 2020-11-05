package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class AbstractDTO<T> {
	private Long id;
	
	private Date createddate;
	
	private Date  modifieddate;
	
	private String createdby;
	
	private String  modifiedby;
	
	private List<T> listResult = new ArrayList<>(); 
}
