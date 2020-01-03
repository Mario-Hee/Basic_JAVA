package problem.DDBoard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.comon.DBManager;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<>(); // 전역변수에 선언을 해놓고 초기화해서 사용한다.
	
	
	public void BoardInsert(BoardDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno, title, content, writer) "
					   + "VALUES(seq_board.NEXTVAL, ?, ?, ? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getTitle());
			pstmt.setString(2, mDto.getContent());
			pstmt.setString(3, mDto.getWriter());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▶▶" + mDto.getTitle()+ "게시글을 등록하였습니다.");
			} else {
				System.out.println("▶▶ 등록에 실패하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}
	public void BoardUpdate(BoardDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board "
					   + "SET title = ?, "
					   + "    content = ?, "
					   + "    writer = ? "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mDto.getTitle());
			pstmt.setString(2, mDto.getContent());
			pstmt.setString(3, mDto.getWriter());
			pstmt.setInt(4, mDto.getBno());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▶▶" + mDto.getTitle()+ "게시글을 수정하였습니다.");
			} else {
				System.out.println("▶▶ 수정에 실패하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		try {
			conn.close();
			pstmt.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public void BoardDelete(String bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_board "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▶▶" + bno + "게시글을 삭제하였습니다.");
			} else {
				System.out.println("▶▶ 삭제에 실패하였습니다. 관리자에게 문의해 주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void BoardSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); 
			list.clear();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				BoardDTO mDto = new BoardDTO(bno, title, content, writer, regdate);	
				list.add(mDto); //list.clear();를 쓰지 않으면 값이 중복되서 계속 뜬다
				// list.add 기존의 리스트 값에 더하다.
			}
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("▶▶번호\t 제목\t 내용\t 작성자\t 작성일자");
			for(BoardDTO line : list) {	
				System.out.println(line.toString());	
			}
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	public void BoardSearch(String title) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board "
					   + "WHERE title LIKE ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%" );
			ResultSet rs = pstmt.executeQuery();
			list.clear();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
			    title = rs.getString("title");
			    String content = rs.getString("content");
			    String writer = rs.getString("writer");
			    Date regdate = rs.getDate("regdate");
			    BoardDTO mDto = new BoardDTO(bno, title, content, writer, regdate);
			    list.add(mDto);		 					
			}
			for(BoardDTO line : list) {
				System.out.println(line.toString());
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
		try {
			conn.close();
			pstmt.close();
			
		} catch (Exception e2) {
			e2.printStackTrace();
			
		} finally {
			
		}
	}
	public void BoardView() {}
	public void BoardSort() {}
	
	
}
