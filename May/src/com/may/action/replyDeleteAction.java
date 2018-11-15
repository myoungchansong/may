package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.may.dao.RepleDAO;

public class replyDeleteAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String rno =request.getParameter("rno");
		System.out.println("============>rno"+rno);
		
		RepleDAO rDao = RepleDAO.getInstance();
		rDao.replydelete(rno);
		
		
		
		return null;
	}

}
