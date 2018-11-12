package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.may.dao.MayMemberDAO;

public class IdCheckAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
//		페이지 이동 x return 는null
		String userid = request.getParameter("id");
		System.out.println("id ==> "+userid);
		
		if(userid != null) {
			if(userid.trim().equals("") == false) {
				System.out.println("test");
				MayMemberDAO mDao = MayMemberDAO.getInstance();
				System.out.println("userid================>"+userid);
				String msg = mDao.confirmID(userid);
				System.out.println("===============idCheck>"+msg);
				/*사용 x*/
				/*request.setAttribute("idCount", msg);*/
				/*ajax = json방식 => 값을 대신 전달 json방식*/
				JSONObject jObj = new JSONObject();
				//json.simple 라이브러리 필요
				jObj.put("message", msg);
				jObj.put("id", userid);
				
				if(jObj.isEmpty()) {
					System.out.println("jObj에 값없음!!!");
				} else {
					System.out.println("값있음!!!");
				}
		
				
//				json객체에 담은 데이터를 호출한 페이지로 전송하는 기능
				response.setContentType("application/x-json; charset=UTF-8");
				response.getWriter().print(jObj);
				
			}
		}
		return null;
	}
	
}
