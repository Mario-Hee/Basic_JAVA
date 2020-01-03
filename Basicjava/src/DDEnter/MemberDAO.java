package problem.DDEnter;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberDAO {  // 데이터베이스를 타는 기능들 모음 DAO
	Connection conn; // 앞글자가 대문자이므로 객체자료형전역변수 이므로 디폴트 값이 초기화 해준다 NULL
	PreparedStatement pstmt; //앞글자가 대문자이므로 전역변수 이므로 디폴트 값이 초기화 해준다 NULL
	
	
	// 1.아티스트 등록
	public void memInsert(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection(); // DBManager가 클래스이름이므로 static메서드이다 
			String sql = "INSERT INTO tbl_enter(ano, aname, major, groupyn, groupnm, sal) " 
					   + "VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?, ?)"; //SQL미완성문!
			pstmt = conn.prepareStatement(sql); // pstmt에 연결정보를 집어 넣어줘!! 
			pstmt.setString(1, mDto.getAname()); //첫번째 물음표- mDto의 get값을 넣어줘! = 공유
			pstmt.setString(2, mDto.getMajor()); //두번째 물음표- mDto의 get값을 넣어줘! = 연기
			pstmt.setString(3, mDto.getGroupyn());//세번째 물음표- mDto의 get값을 넣어줘! = y
			pstmt.setString(4, mDto.getGroupnm());//네번째 물음표- mDto의 get값을 넣어줘! = 도깨비
			pstmt.setInt(5, mDto.getSal()); //다섯번째 물음표- mDto의 get값을 넣어줘! = 9000
			
			int result = pstmt.executeUpdate(); //SQL문 완성!!! 이제 실행 해!!!!!  DB로 값을 전달해서 return값을 돌려 받는다!
			if(result > 0) { // result가 1이면 성공 0이면 실패!! 
				System.out.println("▦▦" + mDto.getAname() + "계약할 아티스트 정보를 입력해 주세요.");
			} else {
				System.out.println("▦▦ 등록에 실패하였습니다. 관리자에게 문의해주세요");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		} finally {
			
		}
		
	} // 메서드 끝난다. 메인으로 가서 mDao.memInsert(mDto);로 가!!
	
	
	// 2.아티스트 수정
	public void memUpdate(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_enter " 
						+ "SET aname = ?, " 
						+ "    major = ?, "
						+ "    groupyn = ?, "
						+ "    groupnm = ?, "
						+ "    sal = ? "
						+ "WHERE ano = ?";
//						+ "VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?, ?)";  인서트에서만 사용
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			pstmt.setString(6, mDto.getAno());
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▦▦" + mDto.getAname() + "수정할 아티스트 정보를 입력해 주세요.");
			} else {
				System.out.println("▦▦ 수정에 실패하였습니다. 관리자에게 문의해주세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	// 3.아티스트 삭제
	public void memDelete(String ano) {
		try {
			// 1. 드라이버 로드, 2. DB 연결
			conn = DBManager.getConnection(); 
			// 3. SQL문 작성(PreparedStatment 방식)
			String sql = "DELETE FROM tbl_enter "
					   + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			// 3.1 미완성 	SQL문 완성(바인딩변수 사용)
			pstmt.setString(1, ano);
			// 4. SQL문 실행!!
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▦▦" + ano + " 아티스트와 계약을 해지하였습니다.");
			} else {
				System.out.println("▦▦ 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}
				
		} catch(Exception e2) {
			e2.printStackTrace();
		} finally {

		}
	}
	// 4.아티스트 조회
	public void memSelect() {}
	// 5.아티스트 검색
	public void memSearch() {}


}
