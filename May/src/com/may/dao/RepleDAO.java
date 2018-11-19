package com.may.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.may.dto.RepleDTO;
import com.may.mybatis.SqlMapConfig;

public class RepleDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	
	 int result=0;
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
	
	public RepleDTO replyselset(int rno){
		RepleDTO rDto = null;
		System.out.println("111111111111111111111111");
		System.out.println("=====>replyselset"+rno);
		sqlSession = sqlSessionFactory.openSession();
		System.out.println("2222222222222222222222");
		try {
			rDto = sqlSession.selectOne("replyselset", rno);
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return rDto;
	}
	public int repleupdate(RepleDTO rDto) {
		System.out.println("=====>repleupdate"+rDto.toString());
		sqlSession = sqlSessionFactory.openSession();
		System.out.println("4444444444444444444444444");
		try {
			result = sqlSession.update("repleupdate", rDto);
			sqlSession.commit();
			System.out.println("444444444444444444444444444");
			System.out.println("dao"+result);
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	
	
	public int replydelete(String rno){
		sqlSession = sqlSessionFactory.openSession();
		try {
			
			result =  sqlSession.delete("replydelete", rno);
			sqlSession.commit();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	public int replyinsert(RepleDTO rDto){
		sqlSession = sqlSessionFactory.openSession();
		try {
			System.out.println("11111111111111111");
			result = sqlSession.insert("replyinsert", rDto);
			sqlSession.commit();
			System.out.println("222222222222222222");
		}
		catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	
	public void blogReplyCntPlus(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		System.out.println("==================DaoBno"+bno);
		
		try {
			
			sqlSession.update("blogReplyCntPlus", bno);
			sqlSession.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		
	}
	public void blogReplycntminus(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		System.out.println("==================DaoBno"+bno);
		
		try {
			
			sqlSession.update("blogReplycntminus", bno);
			sqlSession.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public int blogallreplydelete(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.delete("blogallreplydelete", bno);
			sqlSession.commit();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	
	
}
