package com.koreait.ProjectWMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.ProjectWMS.dto.InOutRegisterDTO;
import com.koreait.ProjectWMS.service.InOutRegisterService;

@Controller
public class InOutRegisterController {
	@Autowired
	private InOutRegisterService service;
	
	@GetMapping("/inoutRegister")
	public String inoutRegister(Model model) {
		model.addAttribute("nextTno", service.getNextTno());
		model.addAttribute("today", java.time.LocalDate.now());
		return "inoutRegister";
	}
	
	@PostMapping("/inoutRegister")
	public String inoutRegister(InOutRegisterDTO dto) {
	    service.inoutRegister(dto);
	    return "redirect:/viewInoutRegister"; // 전체 내역으로 이동
	}
	
	@GetMapping("/viewInoutRegister")
	public String viewInoutRegister(Model model) {
		List<InOutRegisterDTO> list = service.getAllInoutWithJoin();
	    model.addAttribute("inoutList", list);
	    return "viewInoutRegister";
	}
}
