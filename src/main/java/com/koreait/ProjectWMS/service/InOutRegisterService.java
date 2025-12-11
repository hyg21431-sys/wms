package com.koreait.ProjectWMS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.ProjectWMS.dao.InOutRegisterDAO;
import com.koreait.ProjectWMS.dto.InOutRegisterDTO;

@Service
public class InOutRegisterService {
	@Autowired
	private InOutRegisterDAO dao;
	
	public List<InOutRegisterDTO> getAllInoutWithJoin() {
	    return dao.getAllInoutWithJoin();
	}
	
	public void inoutRegister(InOutRegisterDTO dto) {
        // DB에서 마지막 번호 조회
        String lastTno = dao.getLastTno();
        String newTno;

        if (lastTno == null) {
            // 첫 데이터일 경우
            newTno = "20240001";
        } else {
            // 문자열 → 숫자 변환 후 +1
            int next = Integer.parseInt(lastTno) + 1;
            newTno = String.valueOf(next);
        }

        // DTO에 세팅
        dto.setT_no(newTno);

        // DB 저장
        dao.insertInout(dto);
	}
	
	// 화면에서 미리 보여줄 때 쓸 수 있는 메서드
    public String getNextTno() {
        String lastTno = dao.getLastTno();
        if (lastTno == null) return "20240001";
        return String.valueOf(Integer.parseInt(lastTno) + 1);
    }
}
