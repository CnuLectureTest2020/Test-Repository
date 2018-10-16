package hw01;

public class Cat extends Animal implements Pet{
	//필드
	private String name; //고양이의 이름 저장
	
	//생성자
	public Cat() {
		super(4);
	}
	public Cat(String name) {
		super(4);
		setName(name);
	}
	
	//메소드
	public void eat() {
		System.out.println("고양이는 생선을 잘 먹습니다.");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void play() {
		System.out.println("고양이가 공을 가지고 놉니다.");
	}
}
