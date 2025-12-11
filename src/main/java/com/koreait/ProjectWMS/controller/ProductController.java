package com.koreait.ProjectWMS.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.ProjectWMS.dto.ProductDTO;
import com.koreait.ProjectWMS.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/product")
	public String getProductList(Model model) {
		List<ProductDTO> list = service.getProductList();
		Map<String, Integer> total = service.getTotalCost();
		
		model.addAttribute("product", list);
		model.addAttribute("totalIncost", total.get("totalIncost"));
	    model.addAttribute("totalOutcost", total.get("totalOutcost"));
		return "product";
	}
}
