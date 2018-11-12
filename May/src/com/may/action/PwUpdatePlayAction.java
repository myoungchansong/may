package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.MayMemberDAO;

public class PwUpdatePlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		
		String id = request.getParameter("updateId");
		String pw = request.getParameter("input_pw1");
		System.out.println("기존 id:"+id);
		System.out.println("새로운 pw : "+pw);
		
		MayMemberDAO mDao = MayMemberDAO.getInstance();
		
		int result = mDao.updatepw(id, pw);
		
		if(result>0) {
			System.out.println("결과" + result);
			System.out.println(" 수정 완료");
			url = "index.bizpoll";
		}else {
			System.out.println("수정 실패");
			url = "memberpw.bizpoll";
//		새 비밀번호
		}
		
		ActionForward forward =new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
		
		
	}

}
