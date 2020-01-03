package Bank;

import java.util.Scanner;

public class BankMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankDAO bDao = new BankDAO();
		BankDTO bDto;
		int code = 0;

		while (true) {
			System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
			System.out.println("▩▩▩ 허쉬 초콜렛 은행");
			System.out.println("▩▩▩ 1. 계좌 개설");
			System.out.println("▩▩▩ 2. 입금");
			System.out.println("▩▩▩ 3. 출금");
			System.out.println("▩▩▩ 4. 고객조회");
			System.out.println("▩▩▩ 5. 계좌조회");
			System.out.println("▩▩▩ 6. 사용자 검색");
			System.out.println("▩▩▩ 7. 계좌 삭제");
			System.out.println("▩▩▩ 8. 프로그램 종료");
			while (true) {
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.print("▩▩▩ 번호 >> ");
				code = sc.nextInt();
				if (code >= 0 && code <= 8) {
					break;
				} else {
					System.out.println("▩▩▩ 1~8번 기능중 선택해주세요 :) ");
				}
			}

			if (code == 1) {
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩ 허쉬 초콜렛은행의 계좌를 개설합니다. ");
				System.out.print("▩▩▩ 계좌주 >> ");
				sc.nextLine();
				String bname = sc.nextLine();
				System.out.print("▩▩▩ 패스워드 >> ");
				String pw = sc.nextLine();
				bDto = new BankDTO(bname, pw);

				bDao.insertBank(bname, pw);

			} else if (code == 2) {
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩ 입금할 금액과 계좌를 입력해주세요. ");
				System.out.print("▩▩▩ 입금액 >> ");
				int money = sc.nextInt();
				System.out.print("▩▩▩ 계좌번호 >> ");
				int bno = sc.nextInt();
				
				bDao.updateBank(money, bno);

			} else if (code == 3) {

				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩ 출금할 계좌와 비밀번호를 입력해주세요. ");
				System.out.print("▩▩▩ 계좌번호 >> ");
				int bno = sc.nextInt();
				System.out.print("▩▩▩ 비밀번호 >> ");
				sc.nextLine();
				String pw = sc.nextLine();

				// db에 있던 정보확인해서 있는지 확인하기
				if(bDao.CheckUser(bno, pw)) {
					int balance = bDao.balanceMoney(bno); //잔액
					System.out.println("▩▩▩ 잔액:" + bDao.balanceMoney(bno)); // 잔액확인
					System.out.println("▩▩▩ 출금하실 금액을 입력해주세요.");
					System.out.println("▩▩▩ 출금액>>");
					int money = sc.nextInt(); // 출금액
					
					if(balance < money) {
						System.out.println("▩▩▩ 잔액이 부족합니다. 확인해주세요.");
					} else {
						System.out.println("▩▩▩ 출금됐습니다.");
						bDao.minusMoney(bno, money);
					}
					
					// 잔액 = 출금액 = 0  			 ==>출금 가능
					// 잔액 > 출금액 = 잔액-출금액   ==>출금 가능
					// 잔액 < 출금액 = 잘못입력 	 ==> 경고메세지를 띄어준다

				} else {
					System.out.println("▩▩▩ 존재하지 않는 계좌번호이거나 암호가 틀렸습니다.");
				}

			} else if (code == 4) { // 고객조회
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩ 허쉬 초콜렛은행 계좌를 조회합니다 ");
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");

				bDao.selectBank();
			} else if (code == 5) {	
				System.out.println("▩▩▩ 계좌를 조회합니다. 계좌번호와 암호를 입력해주세요." );
				System.out.print("▩▩▩ 계좌번호>");
				int bno = sc.nextInt();
				System.out.print("▩▩▩ 패스워드>");
				sc.nextLine();
				String pw = sc.nextLine();
				System.out.println(bno + ", " + pw);
				
				bDao.selectAccount(bno, pw);
				

			} else if (code == 6) {
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩ 예금주로 검색합니다 ");
				System.out.print("▩▩▩ 예금주 >> ");
//				int bno = sc.nextInt();
//				System.out.print("▩▩▩ 비밀번호 >> ");
				sc.nextLine();
//				String pw = sc.nextLine();
				String bname = sc.nextLine();
//				bDto = new BankDTO(bno, pw);
				bDto = new BankDTO(bname);

				bDao.bankSreach(bDto);
		
			} else if (code == 7){ 
				System.out.println("▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩▩");
				System.out.println("▩▩▩ 계좌를 해지합니다 ");
				System.out.print("▩▩▩ 계좌번호 >> ");
				sc.nextLine();
				int bno = sc.nextInt();
				
				bDao.deleteBank(bno);
		
			} else if (code == 8) {
				System.out.println("▩▩▩ 허쉬 초콜렛은행을 이용해주셔서 감사합니다");
				System.out.println("▩▩▩ 다음에도 이용해주세요 X) ");
				System.exit(0);
			}
		}

	}

	// 1. 프로그램 전체반복
	// 2. 1~6번까지 번호만 허용(나머지는 무한반복 다시입력)
	// 3. 계좌개설만들기
	// 4. 계좌조회만들기
	// 5. 사용자검색 만들기 이름으로
	// 6. 프로그램 종료기능 만들기

}
 
