package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class mgAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
	{
	String url ="blog/mg.jsp";
	ActionForward forward =new ActionForward();
	forward.setPath(url);
	forward.setRedirect(false);
	
	return forward;
	}

}
