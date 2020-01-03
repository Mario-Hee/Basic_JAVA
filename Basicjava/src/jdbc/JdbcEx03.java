package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx03 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in) ;
	
	System.out.print("번호:");
	int num = sc.nextInt();
	System.out.print("이름:");
	sc.nextLine();
	String name = sc.nextLine();
	System.out.print("나이:");
	int age = sc.nextInt();
		
	
		try { // 예외가 발생할 수도 있는 부분
			
			Connection conn = DBManager.getConnection(); //.Connection 자바와 오라클이 연결맺는 부분(정보셋팅해 놓은 걸 붙임)
			
			String sql = "INSERT INTO tbl_study VALUES(?, ?, ?)"; // 실행문이 아닌, 변수에 담은 것 ,?변수를 바인딩 변수라고 한다
			PreparedStatement pstmt = conn.prepareStatement(sql); // PreparedStatement 값을 동적으로 바꿀 수 있는 것 conn. <- 자바랑 디비랑 손 잡음.
			// 자바가 디비에게 sql문을 가지고 명령을 할 것인지만 등록 해놓음  	
			pstmt.setInt(1, num); //물음표의 개수와 아래의 개수를 맞춰야 함!
			pstmt.setString(2, name);
			pstmt.setInt(3 , age);
			
			int result = pstmt.executeUpdate(); // executeUpdate();자바가 디비에게 명령하는 문(DB한테 갔다오면서 값을 줌) pstmt.으로 실행해!
			if(result > 0) {
				System.out.println("등록 성공");
			} else {
				System.out.println("등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
	}
}
