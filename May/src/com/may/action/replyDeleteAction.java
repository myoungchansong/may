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
		String bno1 = request.getParameter("bno");
		RepleDAO rDao = RepleDAO.getInstance();
		int result = rDao.replydelete(rno);
//		댓글 삭제시  댓글카운트 1증감 하는 코드작성
		System.out.println("delete====>"+bno1);
		rDao.blogReplycntminus(bno1);
		
		return null;
	}

}
