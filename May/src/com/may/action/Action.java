package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	// 추상 매서드
	// 꼭사용하세요
	
	//FORWARD SendRedirect 결정 => ActionForward
	
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
	
}
