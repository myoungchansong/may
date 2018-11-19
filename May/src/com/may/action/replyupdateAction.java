package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.RepleDAO;
import com.may.dto.RepleDTO;

public class replyupdateAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="blog/updaterepleform.jsp"; //form.jsp에다가 보내기 
		int rno = Integer.parseInt(request.getParameter("rno"));
		System.out.println("======>rno"+rno);
		RepleDAO rDao = RepleDAO.getInstance();
		RepleDTO rDto=rDao.replyselset(rno);
		request.setAttribute("replyList", rDto);
		
		ActionForward forward =new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
