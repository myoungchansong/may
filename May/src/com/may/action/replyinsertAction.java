package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.RepleDAO;
import com.may.dao.blogDAO;
import com.may.dto.RepleDTO;
import com.may.dto.blogDTO;

public class replyinsertAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user =request.getParameter("user");
		String content =request.getParameter("keywordInput");
		String bno1 = request.getParameter("bno");
		
	
		System.out.println("user :"+user);
		System.out.println("content :"+content);
		System.out.println("bno1 :"+bno1);
		
		
		int bno =Integer.parseInt(bno1); 
		System.out.println("bno : "+ bno);
		RepleDAO rDao = RepleDAO.getInstance();
		
		RepleDTO rDto = new RepleDTO(content,user,bno);
		int result = rDao.replyinsert(rDto);
//		여기에다가 댓글카운트 1증가하는 코드작성
			
			rDao.blogReplyCntPlus(bno1);
	
		
		return null;
	}

}
