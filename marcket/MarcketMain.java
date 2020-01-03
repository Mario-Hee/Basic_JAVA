package marcket;

import java.util.Scanner;

public class MarcketMain {
	// 내부저장소
	// 관리자 계정 ID와 PW 선언
	String id = "admin";
	String pw = "1234";
	
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		ProductDAO pDao = new ProductDAO();
		MarcketMain mm = new MarcketMain();
		int code = 0;
		Boolean flag = false;
		ProductDTO pDto;
		
		// 프로그램 시작
		String userid = "";
		String userpw = "";
		
		System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
		System.out.println("▦▩ Matcket System Ver1.0 ▦▩");
		
		// 로그인 체크
//		do { // 반복 전에 최초 1회 실행하고 조건문은 반복한다.
//			System.out.println("▦▩ [MSG] Please login to use.");
//			System.out.print("▦▩ ID>>");
//			userid = sc.nextLine();
//			System.out.print("▦▩ PW>>");
//			userpw = sc.nextLine();
//		} while(mm.login(userid, userpw));
		
		// 로그인 성공 업무 시작
		System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
		System.out.println("▦▩▦▩1. 물건 판매 ");
		System.out.println("▦▩▦▩2. 제품 등록&추가");
		System.out.println("▦▩▦▩3. 제품 수정");
		System.out.println("▦▩▦▩4. 제품 삭제");
		System.out.println("▦▩▦▩5. 제품 조회");
		System.out.println("▦▩▦▩6. 제품 검색");
		System.out.println("▦▩▦▩7. 일일 매출 현황");
		System.out.println("▦▩▦▩8. 프로그램 종료");
		while(true) {
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
			System.out.print("▦▩▦▩ Code>>");
			code = sc.nextInt();
			
			if(code >= 1 && code <= 8) {
				break;
			} else {
				System.out.println("▦▩▦▩ [Msg] Please enter a vaild value ▦▩▦▩");
			}
		}
		// 1~8중에서 입력
		if(code == 1) { //제품 판매
			
		} else if(code == 2) { //제품 등록&추가 = 물건 새로 등록 & 추가:기존 물건에 재고수량만 늘어나는것
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
			System.out.print("▦▩▦▩ 등록할 제품명을 입력해주세요>>");
			sc.nextLine();
			String pname = sc.nextLine();	
			
			if(pDao.pdtAlready(pname)) {
				// 기존에 등록된 제품임으로 추가(UPDATE) 기능
				// 입고수량 입력받아서 UPDATE
				System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
				System.out.print("▦▩▦▩ 제품수량>>");
				int cnt = sc.nextInt();			
				pDao.cntPlusPdt(pname, cnt);
			} else {
				// 최초 등록된 제품임으로 등록(INSERT) 기능
				// 제조회사, 가격, 입고수량 입력 받아서 INSERT
				System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
				System.out.print("▦▩▦▩ 제조회사>>");
				String company = sc.nextLine();
				System.out.print("▦▩▦▩ 제품가격>>");
				int price = sc.nextInt();
				System.out.print("▦▩▦▩ 제품수량>>");
				int cnt = sc.nextInt();
				pDto = new ProductDTO(pname, company, price, cnt);
				pDao.insertPdt(pDto);
			}

		} else if(code == 3) { //제품수정
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
			System.out.println("▦▩▦▩ 제품을 수정해주세요.");
			System.out.print("▦▩▦▩ 제품명>>");
			sc.nextLine();
			String pname = sc.nextLine();
			System.out.print("▦▩▦▩ 제품가격>>");
			int price = sc.nextInt();
			pDao.updatePdt(pname, price);
			
		} else if(code == 4) { // 제품 삭제
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
			System.out.println("▦▩▦▩ 삭제할 제품명을 입력해주세요.");
			System.out.print("▦▩▦▩ 제품명>>");
			sc.nextLine();
			String pname = sc.nextLine();
			pDao.deletePdt(pname);		
			
		} else if(code == 5) { //제품 조회
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
			System.out.println("▦▩▦▩ 제품을 조회합니다.");
			
			pDao.selectPdt();
			
		} else if(code == 6) { //제품 검색
			System.out.println("▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩▦▩");
			System.out.println("▦▩▦▩ 검색할 제품명을 입력해주세요.");
			pDao.searchPdt();
			
		} else if(code == 7) { //일일 매출 현황
			
		} else if(code == 8) {
			System.out.println("▦▩▦▩ [Msg] Exit the program.");
			System.exit(0);
		}
	}
	
	public boolean login(String userid, String userpw) {
		Boolean flag = true; // 로그인 유무 판별 true: 실패, false:성공
		
		if(userid.equals(id) && userpw.equals(pw)) { // 로그인 성공, 기본에 있던 아이랑 비번을 비교하여 성공유무 판별
			flag = false;
			System.out.println("▦▩ Welcom admin, Have a nice day");
			}else {
				System.out.println("▦▩ [Msg] Login denied.");
			}
		return flag;
		}
	}

