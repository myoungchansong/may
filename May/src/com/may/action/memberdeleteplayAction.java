package com.may.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import com.may.dao.MayMemberDAO;

public class memberdeleteplayAction implements Action{

	@Override
	public ActionForward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session =request.getSession();
		String userid = request.getParameter("id");
		String userpw = request.getParameter("pw");
		System.out.println(userid+","+userpw);
		
		MayMemberDAO mDao = MayMemberDAO.getInstance();
		String message = mDao.confirmPw(userid, userpw);
		
				if(message.equals("1")) {
					System.out.println("회원삭제");
					int flag = mDao.deletMember(userid);
						if(flag > 0) {
							if(session != null) {
								session.invalidate();
					}
				} else {
					
				}
			}
			JSONObject jObj = new JSONObject();
			jObj.put("message", message);
			response.setContentType("application/x-json; charset=UTF-8");
			response.getWriter().print(jObj);
				
			/*ActionForward forward =new ActionForward();
			forward.setPath(url);
			forward.setRedirect(true);*/
			return null;
	
}
}
