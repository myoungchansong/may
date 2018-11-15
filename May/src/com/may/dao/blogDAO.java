package com.may.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.may.dto.CriteriaDTO;
import com.may.dto.blogDTO;
import com.may.mybatis.SqlMapConfig;

public class blogDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	// mapper에 접근하기 위한 sqlsession

	SqlSession sqlSession;

	private blogDAO() {}

	private static blogDAO instance = new blogDAO();

	public static blogDAO getInstance() {
		return instance;
	}
	
	public List<blogDTO> blogListAll(CriteriaDTO criDto)	{
		sqlSession = sqlSessionFactory.openSession();
		List<blogDTO>list = new ArrayList<>();
		
		
		try {
		list = sqlSession.selectList("blogList", criDto);
		
		} catch (Exception e) {
			
		} finally {
			sqlSession.close();
		}
		
		return list;
	}
	
	public int totalCount(CriteriaDTO criDto)	{
		sqlSession = sqlSessionFactory.openSession();
		int result = 0;
		
		
		try {
			result = sqlSession.selectOne("countPaging", criDto);
			System.out.println("================>result"+result);
		} catch (Exception e) {
			
		} finally {
			sqlSession.close();
		}
		
		return result;
	}
	
	
	
	
	public List<blogDTO> blogSearch(CriteriaDTO criDto){
		sqlSession = sqlSessionFactory.openSession();
		List<blogDTO>list = new ArrayList<>();
		
		sqlSession =sqlSessionFactory.openSession();
		try {
			
		list = sqlSession.selectList("blogSearch", criDto);
			
			
		} catch (Exception e) {
		} finally {
			sqlSession.close();
		}
		
		
		return list;
	}
	
	
	
	
	
	public blogDTO blogDetailView(String bno) {
		sqlSession = sqlSessionFactory.openSession();
		blogDTO bDto = null;
		try {
		
			bDto = sqlSession.selectOne("blogDetailView", bno);
			
		} catch (Exception e) {
		} finally {
			sqlSession.close();
		}
		return bDto;
	}
	
	
	
	
	
	
	
	
	
	
	public void viewCnt( HttpSession countsession ,String bno) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			
			long update_time = 0;
			int result =0;
			
			//조회수를 증가할때 생기는 read_time_게시글번호가 없으면
			//현재 처음 조회수를 1증가하는 경우
			
			if(countsession.getAttribute("read_time_"+bno) !=null) {
				update_time = (long)countsession.getAttribute("read_time_"+bno);
			
			}
			//현재 시간을 답는다
			long current_time = System.currentTimeMillis();
			
			// 현재 시간과 조회수 1증가한 시간을 비교해서 24시간(1일)이 지나면 조회수 1증가
			if(current_time - update_time > 1000 * 60 * 60 *24) {
				
				result = sqlSession.update("viewCnt",bno);
				sqlSession.commit();
				
				countsession.setAttribute("read_time_"+bno, current_time);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}
	
	public int mginsert(blogDTO bDto) {
		int result =0;
		sqlSession = sqlSessionFactory.openSession();
		
		
		try {
			System.out.println("daotry");
//						s				값을 하나밖에 못보낸다 
			result = sqlSession.insert("mginsert", bDto);
			
			sqlSession.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return result;
	}
	
	public int blogupdate(blogDTO bDto) {
		int result =0;
		sqlSession = sqlSessionFactory.openSession();
		
		System.out.println("==================dao"+bDto.toString());
		try {
			
//										값을 하나밖에 못보낸다 
			result = sqlSession.update("blogupdate", bDto);
			System.out.println("====================="+result);
			sqlSession.commit();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return result;
	}
}
