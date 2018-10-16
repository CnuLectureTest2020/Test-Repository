package hw01;

public abstract class Animal {
	//필드
	protected int legs; //동물의 다리 수 저장
	
	//생성자
	public Animal(int leg) { //Legs를 초기화하는 생성자를 정의
		this.legs = leg;
	}
	
	//메소드
	public abstract void eat(); //추상메소드
	public void walk() {
		if(legs>0)
			System.out.println("이 동물은 "+legs+"개의 다리로 걷습니다.");
		else
			System.out.println("이 동물은 헤엄칩니다.");
	}
}
