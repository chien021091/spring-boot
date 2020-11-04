package com.laptrinhjavaweb.api.output;

import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dto.PhotoDTO;

public class PhotoOutput {
	private int page;
	private int totalPage;

	private List<PhotoDTO> listResult = new ArrayList<>();

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<PhotoDTO> getListResult() {
		return listResult;
	}

	public void setListResult(List<PhotoDTO> listResult) {
		this.listResult = listResult;
	}


}
