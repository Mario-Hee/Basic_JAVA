/*
 * @source : DBManager.java
 * @description : Connection 객체를 취득, 사용이 끝난
 *				  자원을 해제하는 클래스
 ************************************************************
 * DATE					AUTHOR					DESCRIPTION
 ************************************************************
 * 2019.12.12			초롱이					 최초작성 
 ************************************************************ 
 */
package problem.DDEnter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBManager {
	  
	// 인스턴스의 주소를 저장하기 위한 참조 변수
	private static Connection conn;
	
	//Connection 관련 정보 상수
	private final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private final static String USER = "java";
	private final static String PASS = "1234";
	
	// 반드시 생성자를 private 으로 선언하여 은닉화 시킨다
	// => 외부에서 객체생성을 하지 못하도록 막음
	private DBManager() {} // default 생성자
	
	public static Connection getConnection() {
		conn = null;
		if (conn == null) {
			try {  //예외처리
				Class.forName(DRIVER); 
				conn = DriverManager.getConnection(URL, USER, PASS); //연결이 성공하면 conn에 담는다ㅏ!! conn(연결정보)
				
			} catch (Exception e) {
				e.printStackTrace();
				
			} 

		}
		return conn; // DB랑 연결된 정보값을 가지고 가라!! DAO에 있따
	}
	
}
