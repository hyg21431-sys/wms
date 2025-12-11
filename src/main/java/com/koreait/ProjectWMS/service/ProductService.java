package com.koreait.ProjectWMS.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.ProjectWMS.dao.ProductDAO;
import com.koreait.ProjectWMS.dto.ProductDTO;

@Service
public class ProductService {
	@Autowired
	private ProductDAO dao;
	
	public List<ProductDTO> getProductList() {
		return dao.selectProduct();
	}
	
	public Map<String, Integer> getTotalCost() {
		return dao.selectTotalCost();
	}
}
