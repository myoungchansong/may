package com.may.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.may.action.Action;
import com.may.action.ActionForward;
import com.may.action.Constructbizpoll;
import com.may.action.blogAction;
import com.may.action.blogDetailAction;
import com.may.action.blogSearchAction;
import com.may.action.blogdeleteAction;
import com.may.action.blogdeleteplayAction;
import com.may.action.bloggoodcntAction;
import com.may.action.blogupadateplayAction;
import com.may.action.bloguptaeAction;
import com.may.action.blogviewcntAction;
import com.may.action.commentlistAction;
import com.may.action.downloadAction;
import com.may.action.galleryAction;
import com.may.action.IdCheckAction;
import com.may.action.IndexAction;
import com.may.action.LoginOutPlayAction;
import com.may.action.LoginPlayAction;
import com.may.action.Loginbizpoll;
import com.may.action.MemberAction;
import com.may.action.MemberPlayAction;
import com.may.action.MemberUpdateAction;
import com.may.action.MemberplayUpdateAction;
import com.may.action.PwCheckAction;
import com.may.action.PwUpdateAction;
import com.may.action.PwUpdatePlayAction;
import com.may.action.memberdeleteAction;
import com.may.action.memberdeleteplayAction;
import com.may.action.mgAction;
import com.may.action.mgplayAction;
import com.may.action.replyDeleteAction;
import com.may.action.replyinsertAction;
import com.may.action.replyupdateAction;
import com.may.action.replyupdateformAction;
import com.may.action.updateAction;

/**
 * Servlet implementation class BizpollFrontController
 */
@WebServlet("/BizpollFrontController")
public class BizpollFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BizpollFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//GET,POST 둘다 받음
		
		//한글깨짐 방지(POST방식): 가장 위에 적어주세요.
		request.setCharacterEncoding("UTF-8");
		
		Action action =null; 			// 실제 동작하는 부분
		ActionForward forward = null;   //forward, sendRedirect 설정 
		
		String uri = request.getRequestURI();
		String ctx = request.getContextPath();
		String command = uri.substring(ctx.length());  //index.bizpoll
		
		System.out.println("11111111111uri:"+uri);
		System.out.println("111111111111111ctx:"+ctx);
		System.out.println("페이지 이동====>"+command);
		System.out.println("dwqdwqdqwdwq");

		if (command.equals("/index.bizpoll")) {
			action = new IndexAction();
			forward = action.excute(request, response);
			// WEB에서는 무조건 REQUEST, RESPONSE를 매개변수로 받아야한다
		} else if (command.equals("/construct.bizpoll")) {
			action = new Constructbizpoll();
			forward = action.excute(request, response);
		} else if (command.equals("/member.bizpoll")) {
			action = new MemberAction();
			forward = action.excute(request, response);
		} else if (command.equals("/memberplay.bizpoll")) {
			action = new MemberPlayAction();
			forward = action.excute(request, response);
		} else if (command.equals("/login.bizpoll")) {
			action = new Loginbizpoll();
			forward = action.excute(request, response);
		} else if (command.equals("/loginPlay.bizpoll")) {
			action = new LoginPlayAction();
			forward = action.excute(request, response);
		} else if (command.equals("/loginOut.bizpoll")) {
			action = new LoginOutPlayAction();
			forward = action.excute(request, response);
		} else if (command.equals("/MemberUpdate.bizpoll")) {
			action = new MemberUpdateAction();
			forward = action.excute(request, response);
		} else if (command.equals("/MemberplayUpdate.bizpoll")) {
			action = new MemberplayUpdateAction();
			forward = action.excute(request, response);
		} else if (command.equals("/idCheck.bizpoll")) {
			System.out.println("컨트롤러 탓음");
			action = new IdCheckAction();
			forward = action.excute(request, response);
		} else if (command.equals("/pwCheck.bizpoll")) {
			action = new PwCheckAction();
			forward = action.excute(request, response);
		} else if (command.equals("/memberpw.bizpoll")) { // pw 수정페이지 출력
			action = new PwUpdateAction();
			forward = action.excute(request, response);
		} else if (command.equals("/memberpwplay.bizpoll")) {  // pw 실제로 수정하는 동작
			action = new PwUpdatePlayAction();
			forward = action.excute(request, response);
		} else if (command.equals("/update.bizpoll")) {  
			action = new updateAction();
			forward = action.excute(request, response);
		} else if (command.equals("/memberdeleteplay.bizpoll")) { 
			action = new memberdeleteplayAction();
			forward = action.excute(request, response);
		} else if (command.equals("/memberdelet.bizpoll")) {  
			action = new memberdeleteAction();
			forward = action.excute(request, response);
		} else if (command.equals("/blog.bizpoll")) {
			action = new blogAction();
			forward = action.excute(request, response);
		} else if (command.equals("/gallery.bizpoll")) {
			action = new galleryAction();
			forward = action.excute(request, response);
		} else if (command.equals("/blogSearch.bizpoll")) {
			action = new blogSearchAction();
			forward = action.excute(request, response);
		} else if (command.equals("/blogDetail.bizpoll")) {
			action = new blogDetailAction();
			forward = action.excute(request, response);
		} else if (command.equals("/blogviewcnt.bizpoll")) {
			action = new blogviewcntAction();
			forward = action.excute(request, response);
		} else if (command.equals("/mgAction.bizpoll")) {
			action = new mgAction();
			forward = action.excute(request, response);
		} else if (command.equals("/mgplayAction.bizpoll")) {
			action = new mgplayAction();
			forward = action.excute(request, response);
		} else if (command.equals("/download.bizpoll")) {
			action = new downloadAction();
			forward = action.excute(request, response);
		} else if (command.equals("/blogupdate.bizpoll")) {
			action = new bloguptaeAction();
			forward = action.excute(request, response);
		} else if (command.equals("/blogupadateplay.bizpoll")) {
			action = new blogupadateplayAction();
			forward = action.excute(request, response);
		} else if (command.equals("/blogupadateplay.bizpoll")) {
			action = new blogdeleteAction();
			forward = action.excute(request, response);
		} else if (command.equals("/blogdelete.bizpoll")) {
			action = new blogdeleteplayAction();
			forward = action.excute(request, response);
		} else if (command.equals("/commentlist.bizpoll")) {
			action = new commentlistAction();
			forward = action.excute(request, response);
		} else if (command.equals("/replyDelet.bizpoll")) {
			action = new replyDeleteAction();
			forward = action.excute(request, response);
		} else if (command.equals("/replyinsert.bizpoll")) {
			action = new replyinsertAction();
			forward = action.excute(request, response);
		} else if (command.equals("/replyupdate.bizpoll")) {
			action = new replyupdateAction();
			forward = action.excute(request, response);
		} else if (command.equals("/replyupdateform.bizpoll")) {
			action = new replyupdateformAction();
			forward = action.excute(request, response);
		} else if (command.equals("/bloggoodcnt.bizpoll")) {
			action = new bloggoodcntAction();
			forward = action.excute(request, response);
		} 
		
		
		// 공통 분기 작업(페이지 이동)
		if (forward != null) {
			if (forward.isRedirect()) { // true : sendredirect 방식
				response.sendRedirect(forward.getPath());
			} else { // false: forward 방식

				// 목적지 index.jsp
				// 짐 : bestlist
				// 이동수단: forward
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}

	}

}
