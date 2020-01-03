package problem.DDBoard;

import java.sql.Date;
import java.util.Scanner;

public class DDBoardMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO mDao = new BoardDAO();
		int code = 0; // 사용자가 선택한 프로그램 번호
		
		while(true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■ 더블디 게시판 ");
			mDao.BoardSelect();
			System.out.println("■■ 1.게시글 등록 ");
			System.out.println("■■ 2.게시글 수정 ");
			System.out.println("■■ 3.게시글 삭제 ");
			System.out.println("■■ 4.게시글 조회 ");
			System.out.println("■■ 5.게시글 검색 ");
			System.out.println("■■ 6.게시글 정렬 ");
			System.out.println("■■ 7.상세 게시글 ");
			System.out.println("■■ 8.만든이 ");
			System.out.println("■■ 9.프로그램 종료 ");	
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			
				while(true) {
				System.out.print("■■ 번호>> ");
				code = sc.nextInt();
				if(code >= 1 && code <= 9) {
					break;
				} else {
					System.out.println("■■ 올바른 값을 입력하세요.");
					continue;			
					}
				}
				
				if(code == 1) {
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■ 등록할 게시글을 입력해주세요.");
					System.out.print("▶▶ 제목>> ");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.print("▶▶ 내용>> ");
					String content = sc.nextLine();
					System.out.print("▶▶ 작성자>> ");
					String writer = sc.nextLine();
					
					BoardDTO mDto = new BoardDTO(title, content, writer);
					mDao.BoardInsert(mDto);
					
				} else if(code == 2) {
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■ 수정할 게시글 번호를 입력해주세요.");
					System.out.print("▶▶ 번호>> ");
					sc.nextLine();
					int bno = sc.nextInt();
					System.out.print("▶▶ 제목>> ");
					sc.nextLine();
				    String title = sc.nextLine();
				    System.out.print("▶▶ 내용>> ");
				    String content = sc.nextLine();
				    System.out.print("▶▶ 작성자>> ");
				    String writer = sc.nextLine();
				    
				    BoardDTO mDto = new BoardDTO(bno, title, content, writer);
					mDao.BoardUpdate(mDto);
					
					
				} else if(code == 3) {
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■ 삭제할 게시글 번호를 입력해주세요.");
					System.out.print("▶▶ 번호>> ");
					sc.nextLine();
					String bno = sc.nextLine();
					mDao.BoardDelete(bno);
					
				} else if(code == 4) {
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■ 게시글을 조회 합니다");
					 mDao.BoardSelect();
					 
				} else if(code == 5) {
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■ 게시글을 검색 합니다");
					System.out.print("▶▶ 제목>> ");
					sc.nextLine();
					String title = sc.nextLine();
					mDao.BoardSearch(title);
					
				} else if(code == 6) {
					
				} else if(code == 7) {
					
				} else if(code == 8) {
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■ Name: DD Board Program");
					System.out.println("■■ Version: 1.7");
					System.out.println("■■ Use: JAVA, ORACLE");
					System.out.println("■■ Date: 2019.12.17");
					System.out.println("■■ Made By Mario-Hee");
					System.out.println("■■ icon94@naver.com");
					
				} else if(code == 9) {
					System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
					System.out.println("■■ [프로그램 종료]");
					System.exit(0);
			}
		}
	}
}
