package mybatis;

import java.io.IOException; // 자바에서 만들어 놓은 기능
import java.io.Reader;

import org.apache.ibatis.io.Resources; // 마이바티스에서 만들어 놓은 기능
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapConfig {
	private static SqlSessionFactory sqlSessionFactory; // 값이 없으니 null , 공장건물
	
	static {  // static 블럭을 정적블럭이라고 한다. 클래스 로딩시 1회만 실행되는 코드
		String resource = "mybatis/Configuration.xml"; // "mybatis/Configuration.xml" 을 String resource 변수에 값을 넣어놓은 것 뿐, 실행되는 구문이 아니다
		
		try {
			Reader reader = Resources.getResourceAsReader(resource); // Resources 위에 String resource 랑 다르다! "mybatis/Configuration.xml"을 resource에 집어 놓고,
																	 // 그것을 reader에 집어 넣어라. reader안에 configuration.xml 파일이 들어 있다!!
			
			if(sqlSessionFactory == null) { 
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); // Factory를 만들건데 Configuration.xml 설정값을 토대로 공장을 만들어라!!.build(reader)
																				  // 공장생성, build패턴(빌드 라는 전문가에게 configuration.xml 정보를 주고 sqlSessionFactory 공장을 만들어 주세요!! )
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // static 블럭 끝나는 부분
	
	public static SqlSessionFactory getsqlSession() { // 만든 공장을 보내주는 것!!!
		return sqlSessionFactory;
	}
}
