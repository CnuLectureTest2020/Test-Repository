package hw01;

public class Customer extends Person{
	//필드 추가
	private int c_number;
	private int mileage;
	
	//필드 접근자 설정자 메소드
	public void setC_number(int c_number) {
		this.c_number = c_number;
	}
	public int getC_number() {
		return c_number;
	}
	
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getMileage() {
		return mileage;
	}
	
	//생성자
	public Customer() {
		System.out.println("Customer 생성!\n");
		setName("한유경");
		setAddress("인천광역시");
		setNumber(1027489933);
		setC_number(1);
		setMileage(1000);
	}
	
	//인자를 풀력하는 메소드
	public void print() {
		System.out.println("****Customer****");
		System.out.println("Name : "+getName());
		System.out.println("Address : "+getAddress());
		System.out.println("PhoneNumber : "+getNumber());
		System.out.println("CustomerNum : "+getC_number());
		System.out.println("Mileage : "+getMileage());
		System.out.println("****************\n");
	}
}
