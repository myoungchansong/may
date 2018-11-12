package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.blogDAO;
import com.may.dto.blogDTO;

public class bloguptaeAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="blog/updateblog.jsp";
	
		String bno = request.getParameter("bno");
		
		System.out.println("====>"+bno);
		
		blogDAO bDao = blogDAO.getInstance();
		blogDTO bDto = bDao.blogDetailView(bno);
		
		request.setAttribute("blogview", bDto);
		
		
		ActionForward forward =new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
