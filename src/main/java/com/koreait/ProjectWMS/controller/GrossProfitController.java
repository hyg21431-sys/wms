package com.koreait.ProjectWMS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.koreait.ProjectWMS.dto.GrossProfitDTO;
import com.koreait.ProjectWMS.service.GrossProfitService;

@Controller
public class GrossProfitController {
	@Autowired
    private GrossProfitService service;
	
    @GetMapping("/grossProfit")
    public String grossProfit(Model model) {
    	// DAO -> Service -> Controller로 데이터 불러오기
        List<GrossProfitDTO> list = service.getGrossProfitList();
        model.addAttribute("grossProfitList", list);

        // 합계 계산
        // list.stream() → GrossProfitDTO 객체들이 흘러온다.
        // .mapToInt(GrossProfitDTO::getT_count) → 각 객체에서 t_count 값(int)을 뽑는다.
        // .sum() → 뽑힌 값들을 전부 합산한다.
        int totalCount = list.stream().mapToInt(GrossProfitDTO::getT_count).sum();
        int totalProfit = list.stream().mapToInt(GrossProfitDTO::getGrossprofit).sum();

        // 뷰에서 사용할 데이터 세팅
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("totalProfit", totalProfit);

        return "grossProfit";
    }
}
