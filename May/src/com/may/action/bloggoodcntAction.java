package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.blogDAO;

public class bloggoodcntAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bno =request.getParameter("bno");
		System.out.println("goodcntbno===>"+bno);
		
		blogDAO bDao = blogDAO.getInstance();
		bDao.goodcnt(bno);
		
		
		return null;
	}
}


