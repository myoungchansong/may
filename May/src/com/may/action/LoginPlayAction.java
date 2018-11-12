package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.may.dao.MayMemberDAO;
import com.may.dto.MayMemberDTO;

public class LoginPlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println("id===>"+id+"pw======>"+pw);
		//dao클래스에 logincheck()매서드를 활용하여
		//id pw값으로 select절에 where 조건으로 검색후
		//결과 값을 가지고 현재 지금 이곳 action단으로 돌아오는 코드를 작성 
//		ArrayList<MayMemberDTO> loginlist = new ArrayList<>(); 
		
		MayMemberDAO mDao = MayMemberDAO.getInstance();
		MayMemberDTO mDto = mDao.logincheck(id, pw);
		String message = null;
		
//		System.out.println(mDto.toString());
//		mDao.logincheck(mDto);
		if(mDto != null) {	//로그인 성공
			//session 값에 login된 회원정보를 담아야함 
			System.out.println("action 로그인 성공");
			session.removeAttribute("id");	//혹시 모를  기존의 남아있는 값을 제거
			session.setAttribute("loginUser", mDto);
			message ="1";
			
		} else {
			message ="-1";
		}
		JSONObject jObj = new JSONObject();
		jObj.put("message", message);
		response.setContentType("application/x-json; charset=UTF-8");
		response.getWriter().print(jObj);
		
		
		return null;
		
	}

}
