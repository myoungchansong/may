package com.may.common;

//공통으로 사용하는 commondmfh 패키지 todtjd
//싱글톤 패턴을 활용한 공유 방법
//싱글톤 : static 생성자
//객체를 한번만 실행, 다른클래스에 사용 할때는 한번 생성된 객체를 별라다가 공유의 목적으로 사용하게 만드는  방법


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;





public class DBManager {
private static Connection conn;





private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
private final static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
private final static String USER = "java";
private final static String PASS ="1234";




//생성자를 private으로 만들어 은닉화 시킨다
//외부에서 인스턴스를 생성하지 못하다록 선억
//eu => 공유해서 사용하려고 하는데 다른 개발자가 객체생성 해서 사용하면 공유의 의미가 없음
private DBManager()	{


}

public static Connection getConnection() {
conn = null;

if(conn == null)	{
	try {
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(URL, USER, PASS);
			}catch(Exception e)	{
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs)	{
		try {
		if(rs != null)	{
			try {
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(pstmt !=null)	{
			try {
				pstmt.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(conn !=null)	{
			try {
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
			}catch (Exception e) {
			e.printStackTrace();
			}
		}
	
	
	
	
	
	public static void close(Connection conn, PreparedStatement pstmt)	{
	try {
	
	if(pstmt !=null)	{
		try {
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	if(conn !=null)	{
		try {
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		}catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	
	
	
	

}

