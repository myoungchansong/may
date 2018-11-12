package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginOutPlayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="index.bizpoll";
			
		HttpSession session = request.getSession();
		//session.invalidate(); 세션초기화
		
		if(session!=null)	{
			session.invalidate();
			
		}
		
		ActionForward forward =new ActionForward();	
		forward.setPath(url);
		forward.setRedirect(true);
		return forward;
	}
}
