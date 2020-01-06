package marcket;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class SaleDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getsqlSession();
	SqlSession sqlSession;
	int result;
	List<SaleDTO> list;
	
	public int insertSale(HashMap<String, Object> map) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("sale.insert", map);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	// 일일판매량 출력하는 함수
	public void dashBoard() {
		sqlSession = sqlSessionFactory.openSession();
		int cnt = 0;
		int price = 0;
		try {
			list = sqlSession.selectList("sale.dashBoard");
			int i = 0;
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
			System.out.println("▦▩▦▩ 번호\t 제품명\t 판매수량\t 가격\t ");
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			for(SaleDTO line : list) {
				System.out.print("▦▩▦▩ "+ (i+1) +"\t");
				System.out.print(list.get(i).getSname() + "\t");
				System.out.print(list.get(i).getCnt() + "\t");
				System.out.print(list.get(i).getTprice() + "\t");
				System.out.println();
				cnt+= line.getCnt();
				price += line.getTprice();
				i += 1;
			}
			System.out.println("〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓〓");
			System.out.println("오늘 판매한 제품은 총" +list.size()+ "종류, ");
			System.out.println("총 "+cnt+"개, 판매액"+price+"원 입니다.");
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
	}

}
