package problem.dotorybook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BookDTO> list = new ArrayList<>();
	
	public void bookInsert(BookDTO bDto) {
		try {
		conn = DBManager.getConnection();
		String sql = "INSERT INTO tbl_book(bno, bname, price, company, writer) "
				   + "VALUES(seq_book.NEXTVAL, ?, ?, ?, ?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, bDto.getBname());
		pstmt.setInt(2, bDto.getPrice());
		pstmt.setString(3, bDto.getCompany());
		pstmt.setString(4, bDto.getWriter());
		
		int result = pstmt.executeUpdate();
		if(result > 0) {
			System.out.println("●●"+bDto.getBname()+"등록할 도서를 입력했습니다.");
		} else {
			System.out.println("●● 등록에 실패하였습니다. 관리자에게 문의해주세요.");
		} 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
		}
}	
	public void bookUpdate(BookDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_book "
					   + "SET bname = ?, "
					   + "    price = ?, "
					   + "    company = ?, "
					   + "    writer = ? "
					   + "WHERE bno = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setInt(2, bDto.getPrice());
			pstmt.setString(3, bDto.getCompany());
			pstmt.setString(4, bDto.getWriter());
			pstmt.setString(5, bDto.getBno());
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("●●"+bDto.getBname()+"도서를 수정했습니다.");
			} else {
				System.out.println("●● 수정에 실패했습니다. 관리자에게 문의해주세요.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void bookDelete(String bno) {
		try {
			conn =DBManager.getConnection();
			String sql = "DELETE FROM tbl_book "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("●●"+bno+"도서를 삭제했습니다.");
			} else {
				System.out.println("●● 삭제에 실패했습니다. 관리자에게 문의해주세요.");
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		} finally {
			
		}
	}
	public void bookSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book ";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String bno = rs.getNString("bno");
				String bname = rs.getNString("bname");
				int price = rs.getInt("price");
				String company = rs.getNString("company");
				String writer = rs.getNString("writer");
				Date regdate = rs.getDate("regdate");
				BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDto);
			}
			
			for (BookDTO line : list) {
				System.out.print(line.getBno() + "\t");
				System.out.print(line.getBname() + "\t");
				System.out.print(line.getPrice() + "\t");
				System.out.print(line.getCompany() + "\t");
				System.out.print(line.getWriter() + "\t");
				System.out.print(line.getRegdate() + "\t");
				System.out.println();
				
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void bookSearch(String bname) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book "
					   + "WHERE bname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bname+"%" );
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {	
				String bno = rs.getNString("bno");
				bname = rs.getNString("bname");
				int price = rs.getInt("price");
				String company = rs.getNString("company");
				String writer = rs.getNString("writer");
				Date regdate = rs.getDate("regdate");
				BookDTO bDto = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDto);
			}
			for (BookDTO line : list) {
				System.out.println(line.toString());
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void madeBy() {}
	}
