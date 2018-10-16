package hw02;

public class Magazine extends Book{
	//필드 추가
	private String release;
	
	public void setRelease(String release) {
		this.release = release;
	}
	public String getRelease() {
		return release;
	}
	
	//생성자
	public Magazine() {
		System.out.println("Magazine 생성!\n");
		setTitle("코로코로코믹스");
		setWriter("쇼가쿠칸");
		setPage(50);
		setRelease("2018-05");
	}
	
	//출력 메소드 수정
	public void print() {
		System.out.println("***Magazine***");
		System.out.println("Title : "+getTitle());
		System.out.println("Writer : "+getWriter());
		System.out.println("Page : "+getPage());
		System.out.println("Release : "+getRelease());
		System.out.println("**************\n");
	}
}
