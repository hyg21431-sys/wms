package com.koreait.ProjectWMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.ProjectWMS.dao.GrossProfitDAO;
import com.koreait.ProjectWMS.dto.GrossProfitDTO;

@Service
public class GrossProfitService {
	@Autowired
	private GrossProfitDAO dao;
	
	public List<GrossProfitDTO> getGrossProfitList() {
		return dao.getGrossProfitList();
	}
}
