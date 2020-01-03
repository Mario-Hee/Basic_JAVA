package chapter10;

// 자바의 모든 클래스는 오브젝트 클래스를 상속 받고 있다.
public class ToyMain {
	public static void main(String[] args) {
		IToy mazinger = new MazingerToyImpl(); 
		IToy pooh = new PoohToyImpl();
		IToy bb = new BarbieDoll();
		
	}

}
