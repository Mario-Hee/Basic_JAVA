package Bank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import common.DBManager;
import mybatis.SqlMapConfig;

public class BankDAO {
	// MyBatis 세팅값 호출
	//Session을 생성하는 공장을 만드는 과정
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getsqlSession();
	
	// mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;
	
	
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BankDTO> list = new ArrayList<>();
	BankDTO bDto;
	List<BankDTO> list2;
	int result;

	public void insertBank(String bname, String pw) {
	sqlSession = sqlSessionFactory.openSession(true);
	
		try {
			BankDTO bDto = new BankDTO(bname, pw);
			result = sqlSession.insert("insertBank", bDto );
			
			if(result > 0) {
				System.out.println("▩▩▩" + bname + "님 신규 계좌를 개설하였습니다.");
			} else {
				System.out.println(" 계좌개설에 실패하였습니다. 관리자에게 문의해주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sqlSession.close();

		}
	}

	public void updateBank(int money,int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>(); //제네릭<> 안은 레퍼런스(객체자료형) 타입밖에 못 온다.
		map.put("bno", bno);
		map.put("money", money);
		map.put("flag ", 1);
		try {
			System.out.println(bno + "," + money);
			System.out.println(map.get("bno"));
			System.out.println(map.get("money"));
			result = sqlSession.update("changeMoney", map);
			
			if(result > 0) {
				System.out.println("▩▩▩ 입금 성공하였습니다.");
				System.out.println("▩▩▩ 현재 계좌 잔액은 " + balanceMoney(bno) + "입니다."); 
			} else {
				System.out.println("입금에 실패하였습니다. 관리자에게 문의해주세요.");
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			sqlSession.close();
		}
	}


	public void selectBank() {
		sqlSession = sqlSessionFactory.openSession(); // 공장Factory를 토대로 Session 하나 만들어달라!
		
		try {
			
			list2 = sqlSession.selectList("selBank"); // SelectOne 단건일때(꼭 한건이여야한다, 그이상은 에러난다.), SelectList 여러건일때(두건 이상일때) 사용한다.
			
			for (BankDTO line : list2) {
				System.out.println(line.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sqlSession.close();
		}
	}

	public void bankSreach(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank " 
			           + "WHERE bname = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			rs = pstmt.executeQuery();

			list.clear();
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String bname = rs.getString("bname");
				String pw = rs.getString("pw");
				int money = rs.getInt("money");
				Date regdate = rs.getDate("regdate");
				bDto = new BankDTO(bno, bname, pw, money, regdate);
				list.add(bDto);
			}

			System.out.println(" ====================================");
			System.out.println("  계좌번호 | " + bDto.getBno());
			System.out.println("  예금주 | " + bDto.getBname());
			System.out.println("  금액 | " + bDto.getMoney());
			System.out.println("  개설일자 | " + bDto.getRegdate());
			System.out.println(" ====================================");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int checker(int bno, String pw) {
		int result = 0 ;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT bno, pw " 
					   + "FROM tbl_bank";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int bno2 = rs.getInt("bno");
				String pw2 = rs.getString("pw");
//				System.out.println(bno2);
//				System.out.println(pw2);
				if (bno2 == bno && pw2.equals(pw)) {
					result = 1;
					break;
				} 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int moneyChecker(int bno, int money) {
		int result = 0 ;
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT money "
					   + "FROM tbl_bank "
					   + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(money <= rs.getInt("money")){
					result = 1;
					break;
				} 
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void selectAccount(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			BankDTO bDto = new BankDTO(bno, pw);
			bDto =  sqlSession.selectOne("selectAccount", bDto);
			// SelectOne => DTO		
			// SelectList => List or DTO
			if (bDto == null) {
				System.out.println("▩▩▩ 존재하지 않는 계좌번호이거나 비밀번호가 맞지 않습니다.");
				return;
			} else {
				System.out.println("▩▩▩ " +bno+"계좌의 총 금액은 " + bDto.getMoney()+" 입니다.");
			}
			System.out.println(bDto.toString());
					
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sqlSession.close();
		}
		
	}
	public void deleteBank(int bno) {
		sqlSession = sqlSessionFactory.openSession();
		
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		// map.put("pw", pw);
		
		try {			
			result = sqlSession.delete("deleteBank", map); 
		
			if(result > 0) {
				System.out.println("▩▩▩" + bno + " 계좌를 해지 하였습니다.");
				
			} else {
				System.out.println("계좌 해지하는데 실패하였습니다. 관리자에게 문의해주세요.");
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 계좌 잔액 조회
	public int balanceMoney(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		int money = 0;
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + bno);
		try {

			money = sqlSession.selectOne("balanceMoney", bno);
			System.out.println(">>>>>>>>>> " + money);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		} 
		return money;
	}
	public boolean CheckUser(int bno, String pw) {
		boolean flag = false;
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, Object>map = new HashMap<>();
		map.put("bno", bno);
		map.put("pw", pw);
		try {
			sqlSession.selectOne("CheckUser", map);
			if(result > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
	}
	
	
	//출금
	public void minusMoney(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession();
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bno", bno);
		map.put("money", money);
		map.put("flag", 0);
		try {
			result = sqlSession.update("changeMoney", map);
			if(result > 0) {
				System.out.println("▩▩▩" +money+ "출금성공하였습니다.");
				System.out.println("▩▩▩ 현재계좌 잔액은 " + balanceMoney(bno));
			} else {
				System.out.println("▩▩▩ 출금에 실패하였습니다. 관리자에게 문의해주세요.");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			sqlSession.close();
		}
	}
}
 



