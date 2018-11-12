package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.may.dao.MayMemberDAO;
import com.may.dto.MayMemberDTO;

public class MemberplayUpdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url ="";
		
		HttpSession session = request.getSession();
		
		ActionForward forward =new ActionForward();		
		
		String id = request.getParameter("input_id");
		String name = request.getParameter("input_name");
		String phone = request.getParameter("input_ph");
		String emailid = request.getParameter("input_email_id");
		String emailurl = request.getParameter("input_email_pw");
		String email = emailid + emailurl;
		
		
//		싱글톤 패넡
//		객체생성은 한번만 이루어지고
//		나머지는 생성된 객체를 빌려 쓰는 형태로 작성됨.
		MayMemberDAO mDao =  MayMemberDAO.getInstance();
		MayMemberDTO mDto = new MayMemberDTO(id, name, phone, email);
		
		System.out.println(mDto.toString());
		
		int result = mDao.update(mDto);
		
		if (result > 0) {
			System.out.println("수정성공");
			//session값을 최신정보로 수정
			//id값 삭제후
			session.removeAttribute("id");
			//id값 재입력
			session.setAttribute("loginUser", mDto);
			url="index.bizpoll";
			
		} else {
			System.out.println("실패");
			url="MemberUpdate.bizpoll";
		}
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
		
	}

}
