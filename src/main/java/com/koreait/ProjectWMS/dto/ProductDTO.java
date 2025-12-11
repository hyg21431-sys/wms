package com.koreait.ProjectWMS.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
	private String product_code;
	private String product_name;
	private int product_size;
	private int product_incost;
	private int product_outcost;
}
