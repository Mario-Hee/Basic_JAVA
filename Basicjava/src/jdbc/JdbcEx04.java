package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.print("삭제할 이름:");
		String name = sc.nextLine();
		
		String ur1 = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "java";
		String password = "1234";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(ur1, user, password);
			
			String sql = "DELETE FROM tbl_study " // tbl_study 뒤에 한칸 띄어쓰기 해야한다, 안그러면 오류 난다!!
						+ "WHERE sname = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
	}

}
