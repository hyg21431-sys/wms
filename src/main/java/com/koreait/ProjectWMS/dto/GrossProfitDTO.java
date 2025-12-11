package com.koreait.ProjectWMS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GrossProfitDTO {
    private String product_code;   // 제품코드
    private String product_name;   // 제품명
    private int t_count;           // 출고수량 (SUM)
    private int grossprofit;       // 출고매출이익 (SUM)
}