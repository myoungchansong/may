package com.may.action;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.common.Constants;
import com.may.dao.blogDAO;
import com.may.dto.blogDTO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class mgplayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="blog.bizpoll";
		//파일 업로드 처리
		File uploadDir = new File(Constants.UPLOAD_PATH);
		
		if(!uploadDir.exists()) { //저장할 경로가 없다면
			uploadDir.mkdir();	// 디렉토리를 생성하세요
			
		}
		//request를 확장시킨 MultipartRequest생성
		//request는 전부 String 타입
		//파일 <- request로는 전송불가
		//파일 <- request를 향상시킨 mutipartRequset를 사용
		//파일뿐만 아니라 기존에 String 타입도 전부 mutil타입으로 받아야함
		MultipartRequest multi = new MultipartRequest(request, 
				Constants.UPLOAD_PATH, 								//파일 드렉토리
				Constants.MAX_UPLOAD, 								//업로드 최대 용량
				"UTF-8", 											//인코딩
				new DefaultFileRenamePolicy());						//파일 중복값
		
		String title = multi.getParameter("tilte");
		String content = multi.getParameter("content");
		String loginuser = multi.getParameter("username");
		String filename = " ";
		int filesize = 0;
	
		//multipart를 사용하기 위해서는
		//cos.jar라는 라이브러리가 필요함
//		http://www.servlets.com/
		System.out.println(title+content+loginuser);
		try {
			Enumeration files =multi.getFileNames();
			while (files.hasMoreElements()) {
					String file1 = (String)files.nextElement();
					filename = multi.getFilesystemName(file1);		//첨부파일의 파일이름
					File f1 = multi.getFile(file1);					//첨부파일의 파일
					if(f1 != null) {
						filesize = (int)f1.length(); //첨부파일의 파일사이즈 저장
					}
		}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(filename == null || filename.trim().equals("")) {
			filename = "-";
		}
		
		blogDAO bDao = blogDAO.getInstance();
		blogDTO bDto = new blogDTO(title, content, loginuser, filename, filesize);
		int result = bDao.mginsert(bDto);
		
		if(result >0) {
			System.out.println("등록성공");
			
		} else {
			System.out.println("등록 실패");
			
		}
		
		
		
		
		
		
		ActionForward forward =new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		// 등록시 true로 바꿔야함
		return forward;
	}

}
