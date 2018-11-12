package com.may.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.may.dto.MayMemberDTO;
import com.may.mybatis.SqlMapConfig;

public class MayMemberDAO {
	
	
//	회원 가입 = 회원ㄷ ㅡㅇ록
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	// mapper에 접근하기 위한 sqlsession

	SqlSession sqlSession;

	// 싱글톤으로 NEW 없이 사용하기 떄문에
	// 다른곳에 NEW로 객체생성 못하게 PRIVATE으로 막음
	private MayMemberDAO() {
	}

	// 싱글톤 패턴- 객체생성 1회 실시 후 공유해서 사용
	// 객체생성1회 실시
	private static MayMemberDAO instance = new MayMemberDAO();

	// 외부에서 getInstance()를 활용하여 1회 실시한 객체를 공유
	public static MayMemberDAO getInstance() {
		return instance;
	}

	public int maym(MayMemberDTO mDto) {					//됨
		int result = 0;
		System.out.println("maymdatao111111");
		sqlSession = sqlSessionFactory.openSession();
		try {
			System.out.println("maymdatao2222222");
			result = sqlSession.insert("maym", mDto);
			System.out.println("maymdatao3333333");
			sqlSession.commit(); //insert, update, delete는 반드시 commit
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	
	
	
	//회원가입 페이지 아이디 중복 체크 ajax               				   됨
	public String confirmID(String userid) {
		String result= null;
		System.out.println("confirmid===>"+userid);
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("confirmID", userid);
			
			if (result != null) {
				result = "-1";
			} else {
				result = "1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
			return result;
	}
	
//	비밀 번호 중복 체크            									     됨
	
	public String confirmPw(String id, String pw) { 
		String result = null;
		MayMemberDTO mDto = new MayMemberDTO();
		mDto.setPw(pw);
		mDto.setId(id);
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("confirmPw", mDto);
			
			if (result != null) {
				
				result = "1";
			} else {
				
				result = "-1";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
		
	}
	
	public MayMemberDTO logincheck(String id, String pw) {       //됨
		
		sqlSession = sqlSessionFactory.openSession();
		
		MayMemberDTO mDto= new MayMemberDTO();
		mDto.setId(id);
		mDto.setPw(pw);
		try {
			
			mDto = sqlSession.selectOne("logincheck", mDto);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
			return mDto;
		
	}
	
	public int update(MayMemberDTO mDto) { 				//x
		int result= 0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.update("update", mDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
			return result;
	}
	
	public int updatepw(String id, String pw) { 			// 됨
		int result= 0;
		sqlSession = sqlSessionFactory.openSession();
		MayMemberDTO mDto= new MayMemberDTO();
		mDto.setPw(pw);
		mDto.setId(id);
		try {
			result = sqlSession.update("updatepw", mDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
			return result;
	}
	
	public int deletMember(String usedid) {
		int flag =0;
		sqlSession = sqlSessionFactory.openSession();
		try {
			flag = sqlSession.delete("deletmember",usedid);
			sqlSession.commit();
			System.out.println("DAOreturn============>"+flag);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		
		return flag;
	}
	
	/*Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<MayMemberDTO> list = new ArrayList<>(); 
	int result = 0;
	MayMemberDTO dto;
	int mag =0;
	
	public int maym(MayMemberDTO mDto){
		try {
			
			conn= DBManager.getConnection();
			String sql = "INSERT INTO maymember(id, pw, name, phone, email) "
					   + "VALUES(?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getId());
			pstmt.setString(2, mDto.getPw());
			pstmt.setString(3, mDto.getName());
			pstmt.setString(4, mDto.getPhone());
			pstmt.setString(5, mDto.getEmail());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}
	
	
	public  MayMemberDTO logincheck(String uid, String upw){
		try {
			conn= DBManager.getConnection();
		
			String sql = "SELECT * FROM maymember "
					   + "WHERE id=? AND pw=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			rs =pstmt.executeQuery();
			
			
			while(rs.next()) {
	
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				Date regdate = rs.getDate("regdate");
				dto = new MayMemberDTO(id, pw, name, phone, email, regdate);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
			return dto;
	}	
	
	// 수정 
	
	public int update(MayMemberDTO mDto) {
		try {
			conn= DBManager.getConnection();
			String sql = "UPDATE maymember SET "
					   + "name=?, "
					   + "phone=?, "
					   + "email=? "
					   + "WHERE id=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getName());
			pstmt.setString(2, mDto.getPhone());
			pstmt.setString(3, mDto.getEmail());
			pstmt.setString(4, mDto.getId());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	} 
	

	public int confirmID(String userid) {
		
		try {
			conn= DBManager.getConnection();
			String sql = "SELECT * FROM maymember "
					   + "WHERE id= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//중복된 아이디
				mag = -1;
				
			} else {
				mag = 1;
				
			}
			System.out.println("mag----->"+ mag);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		
		
		
		return mag;
	}
	
	public int confirmPw(String id, String pw) {
		try {
			conn= DBManager.getConnection();
			String sql = "SELECT id FROM maymember "
					   + "WHERE pw= ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				//중복된 비밀번호
				mag = 1;
				
			} else {
				mag = -1;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return mag;
	}
	
	public int updatepw(String id, String pw) {
		try {
			conn= DBManager.getConnection();
			String sql = "UPDATE maymember  SET "
					   + "pw = ? "
					   + "WHERE id = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pw);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
		
		
	}*/
}
