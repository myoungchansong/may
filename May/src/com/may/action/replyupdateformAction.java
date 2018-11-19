package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.RepleDAO;
import com.may.dto.RepleDTO;

public class replyupdateformAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="blog/close.jsp";
		System.out.println("==================================");
		int rno= Integer.parseInt(request.getParameter("rno"));
		String content = request.getParameter("comment_content");
		System.out.println("rno ===>"+ rno);
		System.out.println("content ===>"+ content);
		
		
		RepleDAO rDao = RepleDAO.getInstance();
		RepleDTO rDto = new RepleDTO(rno, content);
		
		int result = rDao.repleupdate(rDto);
		System.out.println("action "+result);
		if(result > 0) {
			System.out.println("수정 ㅇ");

		}else 
			System.out.println("수정x");
		
		ActionForward forward =new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
