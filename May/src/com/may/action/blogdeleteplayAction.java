package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.blogDAO;


public class blogdeleteplayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String bno = request.getParameter("bno");
		System.out.println("======>bno"+bno);
		
		
		blogDAO bDao = blogDAO.getInstance();
//		댓글 다삭제하는거 만들기  파일 삭제 
		
		int result = bDao.blogdelete(bno);
		if(result >0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
		
		return null;
	}

}
