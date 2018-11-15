package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.RepleDAO;
import com.may.dto.RepleDTO;

public class replyinsertAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user =request.getParameter("user");
		String content =request.getParameter("keyword");
		String bno1 = request.getParameter("bno");
		System.out.println("user : "+user);
		System.out.println("content : "+content);
		System.out.println("bno : "+bno1);
		
		int bno =Integer.parseInt(bno1);
		
		RepleDAO rDao = RepleDAO.getInstance();
		RepleDTO rDto = new RepleDTO(content,user,bno);
		rDao.replyinsert(rDto);
		
		return null;
	}

}
