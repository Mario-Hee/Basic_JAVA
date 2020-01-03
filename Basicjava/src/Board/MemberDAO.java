package Board;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class MemberDAO {

		SqlSessionFactory sqlSessionFacory = SqlMapConfig.getsqlSession();
		SqlSession sqlSession;
		
		//DB => YES => Login OK
	    //   => NO => ID or PW 가 틀렸습니다.
		//로그인 기능
		public void login(String id, String pw) { 
			sqlSession = sqlSessionFacory.openSession(true);
			HashMap<String, String> map = new HashMap<>();
			map.put("id", id);
			map.put("pw", pw);
			try {
				int flag = sqlSession.selectOne("member.login", map);
				
				if(flag > 0) { //로그인 성공
					System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
					System.out.println("▩▩▩＃＃반갑습니다." + id + "님");
					System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
					BoardMain.session = "YES";
					BoardMain.userid = id;
				} else { //로그인 실패
					System.out.println("＃＃로그인 실패! ID 또는 PW가 틀렸습니다. 확인해주세요!");
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				sqlSession.close();
			}
			
		}
		
		// 로그아웃 기능
		public void logout() {
		}
		
		public void boardDelete() {
			sqlSession = sqlSessionFacory.openSession();
			
		}
		
	}
 