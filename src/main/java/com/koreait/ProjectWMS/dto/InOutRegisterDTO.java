package com.koreait.ProjectWMS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InOutRegisterDTO {
	private String t_no;
	private String product_code;
	private String product_name;
	private String t_type;
	private int t_count;
	private String company_code;
	private String company_name;
	private String t_date;
}
