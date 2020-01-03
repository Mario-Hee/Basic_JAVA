package chapter08;

// 자식클래스
// : JAVA는 단일상속만 가능!
public class DmbCellPhone extends CellPhone {  //DmbCellPhone 자식클래스, 단일 상속밖에 안됨
	int channel;
	
	//생성자가 하나도 없는 경우 자바가 만들어줌, 매개변수가 하나 있으면 자바가 안 만들어줌.
	
	public DmbCellPhone(String model, String color, int channel) {
		// super(); => 부모생성자 호출(부모 객체 생성)
		// 부모객체 먼저 생성 후 자식객체가 생성됨!!!
		// super를 가장 위에 써야하고 생략이 가능하다. 
		// 자식객체 위에 써야한다.
		super(); // <= 생략가능 == CellPhone();
		this.model = model;
		this.color = color;
		this.channel = channel; 
	}

	public void turnOnDmb() {
		System.out.println("채널" + channel + "번 DMB 방송 수신을 시작합니다.");
	}
	public void ChangeChannelDmb(int channel) {
		this.channel = channel;
		System.out.println("채널" + channel + "번으로 변경합니다.");
	}
	public void turnOffDmb() {
		System.out.println("DMB 방송 수신을 멈춥니다.");
	}
}
