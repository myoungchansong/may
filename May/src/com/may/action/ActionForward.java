package com.may.action;

public class ActionForward {
	
	//view page(결과값을 어디로 전송할지)
	
	private String path; //"index.jsp"
	
	//페이지 이동하는 방법(sendredirect, forward)
	// true -> sendredirect 
	// false -> forward
	private boolean isRedirect; // false 
	

	public String getPath() {
		return path;
	}

	public void setPath(String path) { //path -> "index.jsp"
		this.path = path;
	}
	// 매서드 호출이 종료 대면 원래 있던 곳으로 돌아감

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	
	
}
