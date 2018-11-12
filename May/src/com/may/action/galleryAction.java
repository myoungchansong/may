package com.may.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.ProductDAO;
import com.may.dto.ProductDTO;

public class galleryAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "gallery.jsp";
			
		
		ProductDAO pDao = ProductDAO.getInstance();
		
		List<ProductDTO> allView = pDao.allView();
		request.setAttribute("allView", allView);
	

		

		ActionForward forward = new ActionForward(); 
	
		forward.setPath(url);	
		forward.setRedirect(false); 
		
		return forward;
	}

}
