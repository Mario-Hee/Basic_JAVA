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
	// 기존에 등록된 제품 수량 추가
	public void cntPlusPdt(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("cnt", cnt);
		map.put("flag", "plus");
		try {
			System.out.println(map.get(pname));
			System.out.println(map.get(cnt));
			result = sqlSession.update("cntchangePdt", map);
			
			if(result > 0) {
				System.out.println("▦▩▦▩ \""+pname+"\"제품의 수량을 "+ cnt +"개 추가하였습니다.");
		  } else {
			  System.out.println("▦▩▦▩ [Msg] Error, Contact your admin.");
		  }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 상품 판매시 재고를 마이너스 하는 함수
	public void cntminusPdt(String pname, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("cnt", cnt);
		map.put("flag", "minus");
		try {
			sqlSession.update("cntchangePdt", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 신규 상품 입고등록
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
			list = sqlSession.selectList("pdt.select");
			printList(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 출력
	public void printList(List<ProductDTO> list) {
		int i =1;
		try {
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
			System.out.println("▦▩▦▩ 번호\t제품번호\t제품명\t제조사\t가격\t재고\t입고일자");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			for(ProductDTO line : list) {
				System.out.println("▦▩▦▩ "+ i +"\t"+ line.toString());
				i += 1;
			}
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("현재 등록된 제품은 총" +list.size()+ "개 입니다.");
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 제품 전체조회(재고가 > 1)
	public List<ProductDTO> selectUsePdt() {
		sqlSession = sqlSessionFactory.openSession();
		try {
			list = sqlSession.selectList("pdt.selectUsePdt");
			printList(list);			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return list;
	}
	



	public void searchPdt() {}
	
	
	

}
