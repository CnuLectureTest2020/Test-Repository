package hw01;

public class Fish extends Animal implements Pet{
	private String name; //물고기의 이름 저장
	
	public Fish() {
		super(0);
	}
	
	//메소드
	public void eat() {
		System.out.println("물고기는 먹이를 먹습니다.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void play() {
		System.out.println("물고기가 헤엄치며 놉니다.");
	}
}
