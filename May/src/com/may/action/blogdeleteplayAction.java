package com.may.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.common.Constants;
import com.may.dao.RepleDAO;
import com.may.dao.blogDAO;


public class blogdeleteplayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="blog.bizpoll";
		
		String bno = request.getParameter("bno");
		String filename =request.getParameter("filename");
		System.out.println("======>bno"+bno);
		System.out.println("======>filename"+filename);
		RepleDAO rDao = RepleDAO.getInstance();
		int result = rDao.blogallreplydelete(bno);
		
		blogDAO bDao = blogDAO.getInstance();
		File file = new File(Constants.UPLOAD_PATH+ filename);
		file.delete();
		
		result = bDao.blogdelete(bno);
		if(result >0) {
			System.out.println("삭제 성공");
			
		} else {
			System.out.println("삭제 실패");
		}
		
		ActionForward forward =new ActionForward();
		forward.setPath(url);
		forward.setRedirect(false);
		return forward;
	}

}
