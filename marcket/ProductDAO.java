package marcket;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getsqlSession();
	SqlSession sqlSession;
	int result;
	List<ProductDTO> list;
	Boolean flag = false; // default: false
	
	// 제품 등록&추가 기능 작동시 기존에 등록된 제품인지 최초입고제품인지 판별하는 기능
	public boolean pdtAlready(String pname) {
		sqlSession = sqlSessionFactory.openSession();
		try {
			result = sqlSession.selectOne("pdt.already", pname);
			
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
	
	public void cntPlusPdt(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("cnt", cnt);
		try {
			System.out.println(map.get(pname));
			System.out.println(map.get(cnt));
			result = sqlSession.update("cntPlusPdt", map);
			
			if(result > 0) {
				System.out.println("▦▩▦▩ 제품을 추가 했습니다.");
		  } else {
			  System.out.println("▦▩▦▩ 제품을 추가하는데에 실패했습니다.");
		  }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void insertPdt(ProductDTO pDto) {
		sqlSession = sqlSessionFactory.openSession();
		try { 
			sqlSession.insert("insertPdt", pDto);
			
			if (result > 0) {
				System.out.println("▦▩▦▩ 제품을 최초 등록하였습니다.");
			} else {
				System.out.println("▦▩▦▩ 제품 등록을 실패했습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void updatePdt(String pname, int price) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("price", price);
		
		try {
			result = sqlSession.update("updatePdt", map);
			if(result > 0) {
				System.out.println("▦▩▦▩ 해당 제품을 수정하였습니다.");
			} else {
				System.out.println("▦▩▦▩ 해당 제품 수정에 실패하였습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}
	
	
	public void deletePdt(String pname) {
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		
		try {
			result = sqlSession.delete("deletePdt", map);
			if (result > 0) {
				System.out.println("▦▩▦▩ 해당 제품을 삭제하였습니다.");
			} else {
				System.out.println("▦▩▦▩ 해당 제품 삭제에 실패했습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void selectPdt() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("selectPdt");
			
			if(result > 0) {
				System.out.println("▦▩▦▩ 번호\t제품명\t회사\t가격\t수량");
			}
			for(ProductDTO line : list) {
				System.out.println(line.toString());
			}
			System.out.println("현재 등록된 제품은 총" +list.size()+ "개 입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void searchPdt() {}
	
	
	

}
