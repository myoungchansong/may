package com.may.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.may.dto.RepleDTO;
import com.may.mybatis.SqlMapConfig;

public class RepleDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	

	SqlSession sqlSession;

	private RepleDAO() {}

	private static RepleDAO instance = new RepleDAO();

	public static RepleDAO getInstance() {
		return instance;
	}
	
	public List<RepleDTO> replyListAll(String bno){
		List<RepleDTO> list =null;
		System.out.println("=====>replybno"+bno);
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("replyListAll", bno);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return list;
	}
	
	
	
	public void replydelete(String rno){
		sqlSession = sqlSessionFactory.openSession();
		try {
			
			 sqlSession.delete("replydelete", rno);
			sqlSession.commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	public void replyinsert(RepleDTO rDto){
		sqlSession = sqlSessionFactory.openSession();
		try {
			
			 sqlSession.insert("replyinsert", rDto);
			sqlSession.commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	
	
	
	
}
