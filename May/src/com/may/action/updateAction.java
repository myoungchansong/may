package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateAction implements Action{
	
	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) {
		String url ="update.jsp";
		ActionForward forward =new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}	
	
}
