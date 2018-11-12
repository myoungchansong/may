package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.may.dao.MayMemberDAO;
import com.may.dto.MayMemberDTO;

public class MemberPlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="member_join.jsp";
		
		//view 단에서 전송한 데이터를 받아오세요
		//페이지 이동 기능 x
		//                               input의 네임 값 
		System.out.println("memberplayaction111111");
		String id = request.getParameter("input_id");
		String pw = request.getParameter("input_pw");
		String pw2 = request.getParameter("input_pw2");
		String name = request.getParameter("input_name");
		String phone = request.getParameter("input_ph");
		String emailid = request.getParameter("input_email_id");
		String emailurl = request.getParameter("input_email_pw");
		String email = emailid + emailurl;
		System.out.println("memberplayaction22222");
		MayMemberDTO mDto = new MayMemberDTO(id, pw, name, phone, email);
		System.out.println(mDto.toString());
		MayMemberDAO mDao = MayMemberDAO.getInstance();
		
		int result = mDao.maym(mDto);
		System.out.println("memberplayaction33333");
		if (result >0) {
			System.out.println("등록성공");
		}else {
			System.out.println("실패");
			url = "memberplay.bizpoll";
		}
		ActionForward forward =new ActionForward();		
		forward.setPath(url);
//		forward.setRedirect(false);
		forward.setRedirect(true);
		return forward;
	}
	
}
