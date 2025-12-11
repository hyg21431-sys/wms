package com.koreait.ProjectWMS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.koreait.ProjectWMS.dto.GrossProfitDTO;

@Mapper
public interface GrossProfitDAO {
	@Select("SELECT p.product_code, p.product_name, "
			+ "SUM(i.t_count) AS t_count, "	//출고 수량 합계
			   //(단가차 × 수량)의 합계 = 총 매출이익
			+ "SUM(i.t_count * (p.product_outcost - p.product_incost)) AS grossprofit "
			+ "FROM inout_tbl i "	//입출고 테이블 별칭 i
			   //제품 테이블과 제품코드로 조인
			+ "JOIN product_tbl p ON i.product_code = p.product_code "
			+ "WHERE i.t_type = 'O' "	//출고(O)만 집계 (입고 제외)
			   //제품별로 묶어서 합계 계산
			+ "GROUP BY p.product_code, p.product_name "
			+ "ORDER BY p.product_code ASC")	//제품코드 오름차순 정렬
	public List<GrossProfitDTO> getGrossProfitList();
}
