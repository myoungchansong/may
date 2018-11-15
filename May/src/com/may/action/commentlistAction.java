package com.may.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.RepleDAO;
import com.may.dto.RepleDTO;

public class commentlistAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="blog/commentlist.jsp";
		
		String bno =request.getParameter("bno");
		System.out.println("bno=====>"+bno);
		
		RepleDAO rDao = RepleDAO.getInstance();
		List<RepleDTO> replyList = rDao.replyListAll(bno);
		request.setAttribute("replyList", replyList);
		
		
		ActionForward forward =new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
