package com.koreait.ProjectWMS.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.dao.DataAccessException;

import com.koreait.ProjectWMS.dto.InOutRegisterDTO;

@Mapper
public interface InOutRegisterDAO {
	@Select("SELECT i.t_no, i.product_code, p.product_name, i.t_type, i.t_count, c.company_name, i.t_date " 
			+ "FROM inout_tbl i " 
			+ "JOIN product_tbl p ON i.product_code = p.product_code " 
			+ "JOIN company_tbl c ON i.company_code = c.company_code " 
			+ "ORDER BY i.t_no ASC")
	List<InOutRegisterDTO> getAllInoutWithJoin() throws DataAccessException;
	
	@Select("SELECT MAX(t_no) FROM inout_tbl")
	String getLastTno();
	
	@Insert("INSERT INTO inout_tbl(t_no, product_code, t_type, t_count, t_date, company_code)"
			+ "values (#{t_no}, #{product_code}, #{t_type}, #{t_count}, now(), #{company_code})")
	public void insertInout(InOutRegisterDTO dto) throws DataAccessException;
}
