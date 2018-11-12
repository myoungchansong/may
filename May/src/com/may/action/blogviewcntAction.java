package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.may.dao.blogDAO;

public class blogviewcntAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bno = request.getParameter("bno");
		blogDAO bDao = blogDAO.getInstance();
		
		
		//조회수 1증가
		//sessicon를 활용한 조회수 증가 정지
		
		
		String url = "blogDetail.bizpoll?bno="+bno;
		
		
		HttpSession session = request.getSession();
		
		
		bDao.viewCnt(session ,bno);
		
		ActionForward forward = new ActionForward(); 
		forward.setPath(url);	
		forward.setRedirect(false); 
		
		return forward;
	}

}
