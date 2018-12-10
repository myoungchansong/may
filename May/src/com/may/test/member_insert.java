package com.may.test;


import org.junit.Test;

import com.may.dao.MayMemberDAO;
import com.may.dto.MayMemberDTO;

public class member_insert {
	String id ="test";
	String pw ="1234";
	@Test
	public void testLogincheck() {
		
		MayMemberDAO bDao = MayMemberDAO.getInstance();
		if(id.equals("null")) {
			System.out.println("아이디를 입력해주세요");
			
		} else if(pw.equals("null")) {
			System.out.println("패스워드를 입력해주세요");
			
		} else{
			MayMemberDTO mDto = bDao.logincheck(id, pw);
			if(mDto!=null) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인실패");
			}
		}
			
		
		
	}

}
