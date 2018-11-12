package com.may.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.ProductDAO;
import com.may.dao.blogDAO;
import com.may.dto.CriteriaDTO;
import com.may.dto.PageMakerDTO;
import com.may.dto.ProductDTO;
import com.may.dto.blogDTO;


public class blogAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String url = "blog/blog.jsp";
		
		
		
		CriteriaDTO criDto = new CriteriaDTO();
		
		
		int page =1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("페이지 번호 : "+ page);
		criDto.setPage(page);
		
//		====================================================================
		
		String flag =null;
		String keyword = null;
		
		if(request.getParameter("keyword")!=null) {
			flag = request.getParameter("flag");
			keyword = request.getParameter("keyword");
			System.out.println("===========> 게시글 검색기능 <===========");
			System.out.println(page+","+flag+","+keyword);
			criDto.setFlag(flag);
			criDto.setKeyword(keyword);
			
			request.setAttribute("flag", flag);
			request.setAttribute("keyword", keyword);
		}
		
		
		
		
		blogDAO bDao = blogDAO.getInstance();
//		게시글 목록 정보들 출력
		List<blogDTO> blogList = bDao.blogListAll(criDto);
		
		request.setAttribute("blogList", blogList);
		
//     현재 날짜 출력 =============================================================
		
		Date today = new Date();
		request.setAttribute("today", today);
		
//	   	페이지  =============================================================		
		
		
		PageMakerDTO pageMaker = new PageMakerDTO();
		pageMaker.setCriDto(criDto);
		int totalcount = bDao.totalCount(criDto);
		pageMaker.setTotalCount(totalcount);
		request.setAttribute("pageMaker", pageMaker);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
//		사진 ==========================================
		ProductDAO pDao = ProductDAO.getInstance();
		List<ProductDTO> bestList = pDao.bestView();
		
		List<ProductDTO> newView = pDao.newView();
		
		request.setAttribute("bestlist", bestList);
		request.setAttribute("newView", newView);
		request.setAttribute("pageMaker", pageMaker);
		System.out.println("==================>"+pageMaker);
		
		
		
		
		
		
		ActionForward forward = new ActionForward(); 
	
		forward.setPath(url);	
		forward.setRedirect(false); 
		
		return forward;
	}
	
}
