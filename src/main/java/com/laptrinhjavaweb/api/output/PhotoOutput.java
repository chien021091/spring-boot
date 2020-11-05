package com.laptrinhjavaweb.api.output;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.PhotoDTO;

import lombok.Data;

@Data
public class PhotoOutput {
	private int page;
	private int totalPage;

	private List<PhotoDTO> listResult = new ArrayList<>();
}
