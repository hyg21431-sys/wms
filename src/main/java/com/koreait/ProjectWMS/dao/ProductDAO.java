package com.koreait.ProjectWMS.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.koreait.ProjectWMS.dto.ProductDTO;

@Mapper
public interface ProductDAO {
	@Select("select * from product_tbl order by product_code asc")
	public List<ProductDTO> selectProduct() throws DataAccessException;
	
	@Select("SELECT SUM(product_incost) AS totalIncost, SUM(product_outcost) AS totalOutcost FROM product_tbl")
    Map<String, Integer> selectTotalCost();  // 합계만 반환
}
