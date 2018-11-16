package com.may.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.may.dao.MayMemberDAO;

public class logincheak {

	@Test
	public void testLogincheck() {
		String id= "qwer1234";
		String pw = "qwer123456";
		
		MayMemberDAO bDao = MayMemberDAO.getInstance();
		/*bDao.login();*/
		
	}

}
