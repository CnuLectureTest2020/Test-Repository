package hw01;

public class Person {
	//필드 생성
	private String name;
	private String address;
	private int number;
	
	//필드에 대한 접근자와 설정자 메소드
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	public String getNumber() {
		return "0"+number;
	}
	
	//생성자
	public Person() {
		System.out.println("Person 생성!");
		setName("한유경");
		setAddress("인천광역시");
		setNumber(1027489933);
	}
	
	//인자를 풀력하는 메소드
	public void print() {
		System.out.println("*****Person*****");
		System.out.println("Name : "+getName());
		System.out.println("Address : "+getAddress());
		System.out.println("PhoneNumber : "+getNumber());
		System.out.println("****************\n");
	}
}
