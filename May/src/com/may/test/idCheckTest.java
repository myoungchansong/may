package com.may.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.may.dao.MayMemberDAO;

public class idCheckTest {
	String userid ="qwer1234";
	
	@Test
	public void testConfirmID() {
		
		MayMemberDAO mDao = MayMemberDAO.getInstance();
		
		mDao.confirmID(userid);
		
		
	}

}
