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

public class blogupadateplayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url ="blog.bizpoll";
		
		File uploadDir = new File(Constants.UPLOAD_PATH);
		
		if(!uploadDir.exists()) { //저장할 경로가 없다면
			uploadDir.mkdir();	// 디렉토리를 생성하세요
			
		}
		
		
		MultipartRequest multi = new MultipartRequest(request, 
				Constants.UPLOAD_PATH, 								//파일 드렉토리
				Constants.MAX_UPLOAD, 								//업로드 최대 용량
				"UTF-8", 											//인코딩
				new DefaultFileRenamePolicy());
		
		
		
		String bno1 = multi.getParameter("bno");
		String title = multi.getParameter("tilte");
		String content = multi.getParameter("content");
		String loginuser = multi.getParameter("username");
		String postfile = multi.getParameter("post-file-name");
		String postsize1 = multi.getParameter("post-file-size");
		
		
		String filename = " ";
		int filesize = 0;
		int bno = Integer.parseInt(bno1);
		int postsize = Integer.parseInt(postsize1);
		System.out.println("bno===>"+bno);
		System.out.println("====>filename"+filename);
		System.out.println("====>postfile"+postfile);
		System.out.println("====>postsize"+postsize);
		System.out.println(title+content+loginuser);
		
		
		File file = new File(Constants.UPLOAD_PATH+ postfile);
		file.delete();
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
		System.out.println("현재 파일 이름postfile : "+postfile);
		System.out.println("현재 파일 이름filename : "+filename);
		if(filename==null) {
			filesize = postsize;
			filename = postfile;
		} 
			
		
		blogDAO bDao = blogDAO.getInstance();
		blogDTO bDto = new blogDTO(bno, title, content, loginuser, filename, filesize);
		int result = bDao.blogupdate(bDto);
		
		if(result >0) {
			System.out.println("수정성공");
			
		} else {
			System.out.println("수정 실패");
			
		}
		
		
		
		
		
		
		ActionForward forward =new ActionForward();
		forward.setPath(url);
		forward.setRedirect(true);
		// 등록시 true로 바꿔야함
		return forward;
	}

}
