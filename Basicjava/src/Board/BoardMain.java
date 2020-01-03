package Board;
//1.등록 => Login유무 => Login등록(작성자 = 로그인 유지)
//		 => Login을 하셔야만 글을 등록할 수 있습니다. ==> 로그인으로 이동
//Session = YES or NO
//    (Login OK or Login X)
//userid = "Login 유저 ID"
import java.util.Scanner;

import Bank.BankDTO;
import DDBoard.DDBoardMain;

public class BoardMain {
	// static은 공용 개념으로 전역변수에 써야한다.
	static String session = "NO"; // 로그인 유무
	static String userid="";
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO bDao = new BoardDAO();
		MemberDAO mDao = new MemberDAO();
		BoardDTO bDto;
		int code = 0;
		
		while(true) {
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			System.out.println("▣▣▣▣ 레드벨벳 게시판");
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			System.out.println("▣▣▣▣ 0.로그인 유무 ");
			System.out.println("▣▣▣▣ 1.게시글 등록 ");
			System.out.println("▣▣▣▣ 2.게시글 수정 ");
			System.out.println("▣▣▣▣ 3.게시글 삭제 ");
			System.out.println("▣▣▣▣ 4.게시글 조회 ");
			System.out.println("▣▣▣▣ 5.게시글 검색 ");
			System.out.println("▣▣▣▣ 6.게시글 정렬 ");
			System.out.println("▣▣▣▣ 7.상세 게시글");
			System.out.println("▣▣▣▣ 8.만든이");
			System.out.println("▣▣▣▣ 9.프로그램 종료");	
			System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
			if(BoardMain.session.equals("YES")) {
				System.out.println("▣▣▣▣ " + BoardMain.userid + "님 재방문을 환영합니다.");
			}
			while(true) {
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.print("▣▣▣▣ 번호>>>>");
				code = sc.nextInt();
				if(code >= 0 && code <= 9 ) {
					break;
				} else {
					System.out.println("▣▣▣▣ 1 부터 9번 기능 중에서 고르세요 ▣▣▣▣");
				}
		    }
			if(code == 0) {
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣ 로그인 할 ID 와 PW를 입력해주세요.");
				System.out.print("▶▶ ID>>>>");
				sc.nextLine();
				String id = sc.nextLine();
				System.out.print("▶▶ PW>>>>");
				String pw = sc.nextLine();
				
				mDao.login(id, pw);
			} else if(code == 1) {
				if(BoardMain.session.equals("NO")) {
					System.out.println(" 로그인이 필요한 기능입니다. ");
					continue;
				}
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣ 등록할 게시글을 입력해주세요.");
				System.out.print("▶▶ 제목>>>> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("▶▶ 내용>>>> ");
				String content = sc.nextLine();
				System.out.print("▶▶ 작성자>>>> ");
				String writer = BoardMain.userid;// 로그인한 유저 ID = 작성자
				
				bDto = new BoardDTO(title, content, writer);
				System.out.println(bDto.toString());
				bDao.insertboard(bDto);
				
			} else if(code == 2) {
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣ 수정할 게시글 번호를 입력해주세요.");
				System.out.print("▶▶ 번호>>>> ");
				sc.nextLine();
				int bno = sc.nextInt();
				System.out.print("▶▶ 제목>>>> ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.print("▶▶ 내용>>>");
				String content = sc.nextLine();
				bDto = new BoardDTO(bno, title, content);
				bDao.updateboard(bno, title, content);
				
			} else if(code == 3) {
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣ 삭제할 게시글 번호를 입력해주세요.");
				System.out.print("▶▶ 번호>>>> ");
				sc.nextLine();
				int bno = sc.nextInt();
				bDao.deleteboard(bno);
				
			} else if(code == 4) {
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣ 게시글을 조회합니다.");
				bDao.selectboard();
				
			} else if(code == 5) {
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣ 게시글을 검색합니다.");
				System.out.print("▶▶ 제목>>>> ");
				sc.nextLine();
				String Keyword = sc.nextLine();
				bDao.searchboard(Keyword);
				
			} else if(code == 6) {
				bDao.sortboard();
				
			} else if(code == 7) {
				bDao.viewboard();
				
			} else if(code == 8) {
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣ Name: Board Program");
				System.out.println("▣▣▣▣ Version: 1.7");
				System.out.println("▣▣▣▣ Use: JAVA, ORACLE");
				System.out.println("▣▣▣▣ Date: 2020.01.02");
				System.out.println("▣▣▣▣ Made By Mario-Hee");
				System.out.println("▣▣▣▣ icon94@naver.com");
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				
			
			} else if(code == 9) {
				System.out.println("▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣▣");
				System.out.println("▣▣▣▣ 프로그램 종료");
				System.exit(0);
			}
			
		}
	}
}
