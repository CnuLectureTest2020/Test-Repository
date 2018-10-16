package hw_03;

public class Plane {
	//필드 생성
	private String brand; //항공사 필드, 편의상을 위해 한글로만 입력한다.
	private String model; //모델 필드, 편의상을 위해 AA0000 형식을 따른다.
	private int max_people; //최대 탑승객 필드
	
	static private int planes = 0;
	
	//필드 접근자, 설정자 메소드
	public void getbrand(String brand){ //항공사 필드 접근자, 설정자
		this.brand = brand;
	}
	public String setbrand() {
		return brand;
	}
	
	public void getmodel(String model) { //모델 필드 접근자, 설정자
		this.model = model;
	}
	public String setmodel() {
		return model;
	}
	
	public void getmax_people(int max_people) { //최대 탑승객 필드 접근자, 설정자
		this.max_people = max_people;
	}
	public int setmax_people() {
		return max_people;
	}
	
	//planes 출력 메소드
	static public int getPlane() {
		return planes;
	}
	
	//생성자
	public Plane() {                 //아무것도 입력 안한 경우
		getbrand("아시아나항공");
		getmodel("OZ8901");
		getmax_people(200);
		planes++;
	}
	public Plane(String string) {    //문자열 하나만 입력한 경우
		if((int)string.charAt(0)>=65&&(int)string.charAt(0)<=90) {
			//앞글자가 영대문자일 경우 문자열은 모델로 취급
			getbrand("아시아나항공");
			getmodel(string);
			getmax_people(200);
		}
		else {
			getbrand(string);
			getmodel("OZ8901");
			getmax_people(200);
		}
		planes++;
	}
	public Plane(int max_people) {    //숫자만 입력받은 경우
		getbrand("아시아나항공");
		getmodel("OZ8901");
		getmax_people(max_people);
		planes++;
	}
	public Plane(String brand, String model) {  //문자열 두개 입력받은 경우
		getbrand(brand);
		getmodel(model);
		getmax_people(200);
		planes++;
	}
	public Plane(String string, int max_people) { //문자열과 숫자 입력받은 경우
		if((int)string.charAt(0)>=65&&(int)string.charAt(0)<=90) {
			//앞글자가 영대문자일 경우 문자열은 모델로 취급
			getbrand("아시아나항공");
			getmodel(string);
			getmax_people(max_people);
		}
		else {
			getbrand(string);
			getmodel("OZ8901");
			getmax_people(max_people);
		}
		planes++;
	}
	public Plane(String brand, String model, int max_people) { //모든 인자 입력받은 경우
		getbrand(brand);
		getmodel(model);
		getmax_people(max_people);
		planes++;
	}
}
