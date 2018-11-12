package com.may.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.may.common.DBManager;
import com.may.dto.ProductDTO;
import com.may.mybatis.SqlMapConfig;

public class ProductDAO {

	// Mybatis 셋팅값 호출

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	// mapper에 접근하기 위한 sqlsession

	SqlSession sqlSession;

	// 싱글톤으로 NEW 없이 사용하기 떄문에
	// 다른곳에 NEW로 객체생성 못하게 PRIVATE으로 막음
	private ProductDAO() {
	}

	// 싱글톤 패턴- 객체생성 1회 실시 후 공유해서 사용
	// 객체생성1회 실시
	private static ProductDAO instance = new ProductDAO();

	// 외부에서 getInstance()를 활용하여 1회 실시한 객체를 공유
	public static ProductDAO getInstance() {
		return instance;
	}

	// 실제 동작들..
	// best상품목록 출력(index 페이지)

	public List<ProductDTO> bestView() {
		sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> bestlist = null;
		try {
			bestlist = sqlSession.selectList("bestView");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return bestlist;
	}
	
	public List<ProductDTO> newView() {
		sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> newView = null;
		try {
			newView = sqlSession.selectList("newView");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return newView;
	}
	public List<ProductDTO> allView()	{
		sqlSession = sqlSessionFactory.openSession();
		List<ProductDTO> allView = null;
		try {
			allView = sqlSession.selectList("allView");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return allView;
	}
	

	// ==================================================================================================
	// Mybatis 사용하기 전 DBManager와
	// PreparStatemnet 방식으로 구현한 dao객체

	/*
	 * Connection conn = null; PreparedStatement pstmt = null; ResultSet rs =null;
	 * ArrayList<ProductDTO> list = new ArrayList<>(); int result = 0;
	 * 
	 * public ArrayList<ProductDTO> bestView(){ try { conn=
	 * DBManager.getConnection(); String sql = "SELECT * FROM best_pro_view "; pstmt
	 * = conn.prepareStatement(sql); rs =pstmt.executeQuery();
	 * 
	 * while(rs.next()) { String p_code = rs.getString("p_code"); String p_nmae =
	 * rs.getString("p_nmae"); int p_price = rs.getInt("p_price"); String p_img =
	 * rs.getString("p_img"); Date p_indate = rs.getDate("p_indate"); ProductDTO
	 * pDto = new ProductDTO(p_code, p_nmae, p_price, p_img, p_indate);
	 * list.add(pDto);
	 * 
	 * }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally {
	 * DBManager.close(conn, pstmt, rs); } return list; }
	 */
}
