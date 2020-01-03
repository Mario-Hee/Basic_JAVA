package problem.DDEnter;

import java.util.Scanner;

public class DDEnterMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 사용자 키보드 값을 받기 위해 스캐너 객체 생성!!
		
		while(true) { //반복문
				// 1. 화면에 출력하는 부분
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				System.out.println("▦▦ 더블디 엔터 관리 시스템");
				System.out.println("▦▦ 1. 아티스트 등록");
				System.out.println("▦▦ 2. 아티스트 수정");
				System.out.println("▦▦ 3. 아티스트 해지");
				System.out.println("▦▦ 4. 아티스트 조회");
				System.out.println("▦▦ 5. 아티스트 검색");
				System.out.println("▦▦ 6. 프로그램 종료");
				System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
				
				// 2. 사용자가 실행할 프로그램을 입력받는 부분 
				int code = 0;
				while(true) {
				System.out.print("번호>> ");
				code = sc.nextInt(); 
				
				// 사용자가 1~6까지 입력하기 전까지 
				// 계속 번호를 입력하게 도는 반복문(경고 메세지 출력)
				if (code >= 1  && code  <= 6) { // &&(and)기호는  둘 다 참이여야한다
					break; //가장 가까운 반복문을 빠져나간다.
				} else {
					System.out.print("▦▦ 올바른 값을 입력하세요");
					continue; 
				}
			} // break가 빠져나가는 부분
				
				MemberDAO mDao = new MemberDAO(); //객체생성했다! 멤버DAO의 기능이 필요하다! DAO클래스에 가서 객채 생성하고 와!(호출!)
				// 사용자가 입력한 값이 1 ~ 6인 경우
				if(code == 1) {  // code 밑의 빨간줄은 위의 while문 때문에 뜨는 것이므로 while문 밖에다가 code 를 선언한다
					// 소속 아티스트 등록
					System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");//출력문
					System.out.println("▦▦ 계약할 아티스트 정보를 입력해 주세요.");//출력문
					System.out.print("▦▦ 이름>> "); //출력문
					sc.nextLine(); // 한줄개행 입력한 값을 보여줌
					String aname = sc.nextLine(); 
					System.out.print("▦▦ 분야>> ");
					String major = sc.nextLine();
					System.out.print("▦▦ 그룹유무(y/n)>> ");
					String groupyn = sc.nextLine();
					System.out.print("▦▦ 그룹이름>> ");
					String groupnm = sc.nextLine();
					System.out.print("▦▦ 연봉>> ");
					int sal = sc.nextInt(); // 사용자에게 변수를 입력 받은 것
					
					MemberDTO mDto = new MemberDTO(aname, major, groupyn, groupnm, sal); // 생성자로 객체생성 1회 했따, 
					// 이 값 다섯개를 가지고 생성자로 가!! DTO로 가서 다섯개의 값을 그대로 넣어!
					
					mDao.memInsert(mDto); //mDao로 가서 memInsert값을 실행 해! mDto의 다섯개의 값을 가지고 memInsert로 간다
					
				} else if(code == 2) { //소속 아티스트 수정
					System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
					System.out.println("▦▦ 수정할 아티스트 번호를 입력해 주세요.");
					System.out.print("▦▦ 번호>> ");
					sc.nextLine();
					String ano = sc.nextLine();
					// 이름, 분야, 그룹유무, 그룹이름, 연봉
					System.out.print("▦▦ 이름>> "); //출력문
					String aname = sc.nextLine(); 
					System.out.print("▦▦ 분야>> ");
					String major = sc.nextLine();
					System.out.print("▦▦ 그룹유무(y/n)>> ");
					String groupyn = sc.nextLine();
					System.out.print("▦▦ 그룹이름>> ");
					String groupnm = sc.nextLine();
					System.out.print("▦▦ 연봉>> ");
					int sal = sc.nextInt();
					
					MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal); //mDto에 값을 줬다
							
					
					mDao.memUpdate(mDto);
					
				} else if(code == 3) { // 소속 아티스트 삭제
					System.out.println("▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦▦");
					System.out.println("▦▦ 삭제할 아티스트 번호를 입력해 주세요.");
					System.out.print("▦▦ 번호>> ");
					sc.nextLine();
					String ano = sc.nextLine(); // 어떤 번호로 지울지 입력
					mDao.memDelete(ano); //인풋값
					
				} else if(code == 4) {
					// 조회 => 메서드
					mDao.memSelect();
					
				} else if(code == 5) {
					// 검색 => 메서드
					mDao.memSearch();
					
				} else if(code == 6) {
					System.out.println("<프로그램 종료>");
					System.exit(0);  // 매개변수에 0을 넣는 이유는 0은 즉시종료이다. 
				}		// 회원관련된 DAO
		} // 등록성공하고 첫번째 while문으로 돌아가서 계속 반복하며 보여준다!!
	}
}
