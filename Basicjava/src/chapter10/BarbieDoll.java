package chapter10;

public class BarbieDoll implements IMoveArmLeg {

	public BarbieDoll() {
		System.out.println("나는 바비야");
		canMoveArmLeg();
		
		
	}
	@Override
	public void canMoveArmLeg() {
		System.out.println("사뿐사뿐 걷는다.");
		
	}
	

}
