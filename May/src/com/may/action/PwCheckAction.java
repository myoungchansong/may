package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.may.dao.MayMemberDAO;

public class PwCheckAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id: "+ id);
		System.out.println("pw: "+ pw);
		
	
		MayMemberDAO mDao =  MayMemberDAO.getInstance();
		String msg = mDao.confirmPw(id, pw);
		JSONObject jObj = new JSONObject();
		
		jObj.put("msg", msg);
		jObj.put("pw", pw);
		
		if(jObj.isEmpty()) {
			System.out.println("값없음 ");
			
		}else {
			System.out.println("값있음!!!");
			
		}
		
		
//		DB에서 PW 값 가지고 와서 비교
//		SELECT pw FROM member
//		WHERE id = ?;
//		id 값을 구하는 2가지 (session)
//		1. controller단에서 session객체 호출해서 id값 빼오는 방법
//		2. view단에서 session에 담겨있는 id값을 pw값과 함께 보내는 방법
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		return null;
	}

}
