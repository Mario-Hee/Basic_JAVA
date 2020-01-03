package problem;

public class Parking {
	int[] space = new int[5]; // 주차공간(5대)
	int carCnt = 0; // 현재 주차된 차량수
	
	// 1. 주차타워 현황
	public void ViewParking() {
		System.out.println("============");
		for(int j = 0; j < space.length; j++) { 
			System.out.println("|| " + (j + 1) + "층 :" + space[j] + " ||");
		}
		System.out.println("============");
	}
	
	// 2. 주차타워 입고
	public void inparking(int car) { // void는 return으로 값을 보내지 않겠다는 뜻
		// 현재 주차타워에 빈공간이 없는 경우
		if(carCnt == space.length) {	// 설명하기!!!!!
			      // 실질적인 숫자보다 space.length을 쓰고 위에서 배열의 크기를 입력하는 것이 좋다.
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 공간이 부족합니다. 2번 타워를 이용해주세요.");
			return; // 메서드 실행종료.
		}
		// 주차공간을 순회하면서 비어있는 (입고 할 공간)을 찾음
		for(int i = 0; i < space.length; i++) {
			// 비어있는 공간을 찾음(값이 0이면 비어있음)
			if(space[i] == 0) {
				space[i] = car;
				carCnt += 1; // 차 한대가 입고 됨 
				//carCnt = carCnt + 1;
				System.out.println("▒▒ " + (i + 1 ) + "층 :" + car + "입고완료!");
				ViewParking();
				break;
			}
		}	
	}
	// 3. 주차타워 출고
	public void outparking(int car) {
		// 주차타워에 차량이 0대인 경우
		if(carCnt == 0) {
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 주차 중인 차량이 없습니다. 확인해주세요");
			return;
		}
		for(int i = 0; i < space.length; i++) {
			// 주차된 차량번호와 내가 입력한 차량번호가 같을때
			if(space[i] == car) {
				space[i] = 0; // 출고 => 공간 0
				carCnt -= 1; // 현재 주차차량 -1
				System.out.println("▒▒ " + (i + 1 ) + "층 :" + car + "출고완료!");
				ViewParking();
				return;
			}				
		}
		// 입력한 차량번호가 해당 주차타워에 없음!!
		System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
		System.out.println("▒▒ 없는 차량입니다. 다시 입력해주세요.");		
	}
}
