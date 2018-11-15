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
		String filename = " ";
		int filesize = 0;
		String nowFileName= multi.getParameter("now-file-name");
		String nFileSize = multi.getParameter("now-file-size");
		System.out.println("nFileSize====>>"+nFileSize);
		
		// nowFileSize 숫자로 변환
		// 값이 없으면 0부여, 값이 있으면 숫자로 변환
		int nowFileSize =0;
		if(!nFileSize.equals("")) {
			nowFileSize = Integer.parseInt(nFileSize);
		}
		// 과거 filename과 filesize 불어오기
		blogDAO bDao = blogDAO.getInstance();
		blogDTO bDto = bDao.blogDetailView(bno1);
		String pfilename = bDto.getFilename();
		String pfilesize = String.valueOf(bDto.getFilesize());
		System.out.println("과거 첨부파일 : "+pfilename +","+pfilesize);
		System.out.println("현재 첨부파일 : "+nowFileName+","+nFileSize);
		
		int flag=0;
		if(nowFileName.equals(pfilename) && nowFileSize ==0) {
			//파일이름이 같으면서,
			//사이즈가 같거나
			//파일 지우지않음, filename과 filesize도 수정하면 안됨
			flag=1;
		} else {
			File file = new File(Constants.UPLOAD_PATH+ pfilename);
			file.delete();
		}
		
		
		
		try {
			Enumeration files =multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String file1= (String)files.nextElement();
				System.out.println("filel : "+ file1);
				filename = multi.getFilesystemName(file1); // 파일네임을 가지고옴 (중복정책이 부여된 값을 가져온다)
				System.out.println("저장 된 첨부 파일  : "+ filename);
			
				if(nowFileSize !=0) {
					String result =filename.substring(nowFileName.length());
					System.out.println("TEST:"+nowFileName+","+filename+","+result);
					
					
					if(result.length()>0) {
						File file = new File(Constants.UPLOAD_PATH + filename);
						File fileNew = new File(Constants.UPLOAD_PATH+nowFileName);
						file.renameTo(fileNew);
						
						filename = nowFileName;
						filesize = nowFileSize;
						
					}
				}
			File f1 = multi.getFile(file1);		
			
			if(f1 != null) {
				filesize = nowFileSize;
			}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		if(filename == null || filename.trim().equals("")) {
			filename ="-";
		}
		
		if(flag == 1) {
			filename = "no";
		}
		
		
		int bno = Integer.parseInt(bno1);
		bDto = new blogDTO(bno, title, content, loginuser, filename, filesize);
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
