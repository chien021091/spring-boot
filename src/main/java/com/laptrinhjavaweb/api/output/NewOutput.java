package com.laptrinhjavaweb.api.output;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.NewDTO;

import lombok.Data;

@Data
public class NewOutput {
	private int page;
	private int totalPage;

	private List<NewDTO> listResult = new ArrayList<>();
}
