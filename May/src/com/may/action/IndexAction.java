package com.may.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.dao.ProductDAO;
import com.may.dto.ProductDTO;


public class IndexAction implements Action {

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String url = "index.jsp";
		//동작하는 부분
		// best 상품을 출력 -> best 상품을 db에서 조회 
		// model단으로 이동(dao)
//		ProductDAO pDao = new ProductDAO();
//		//ProductDTO타입의 ArrayList객체 생성
//		ArrayList<ProductDTO> bestlist = new ArrayList<>();
//		//pDao클래스의bestView매서드를 호출후 리턴 값을 bestlist에 담는다
//		bestlist = pDao.bestView();
//		//화면(View)단으로 전송할 데이터를 담는다 
//		//					("이름표",	 실제 값 );
		
		
		ProductDAO pDao = ProductDAO.getInstance();
		List<ProductDTO> bestList = pDao.bestView();
		
		List<ProductDTO> newView = pDao.newView();
		
		request.setAttribute("bestlist", bestList);
		request.setAttribute("newView", newView);

		
//		값 받아오는지 확인 
//		for (ProductDTO productDTO : bestlist) {
//			System.out.println(productDTO.getP_code()+"\t");
//		}
//		어떤 view단으로 이동하는지 설정
		ActionForward forward = new ActionForward(); //ActionForward 객체 생성
//		ActionForward의 클래스의 setpath매서드를 호출
//		매개변수로 url값("index.jsp")을 전송
		forward.setPath(url);	//index.jsp로 이동
//		ActionForward의 클래스의 setRedirect매서드를 호0출 
//		매개변수로 boolean타입의 false값을 전송
		forward.setRedirect(false); //forward 방승을 사용
		
		return forward;
	}
	
}
