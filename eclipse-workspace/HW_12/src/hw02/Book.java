package hw02;

public class Book {
	//필드
	private String title;
	private String writer;
	private int page;
	
	//필드 설정자, 접근자 메소드
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriter() {
		return writer;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	public int getPage() {
		return page;
	}
	
	//생성자
	public Book() {
		System.out.println("Book 생성!");
		setTitle("숨은 돈을 찾아라");
		setWriter("헬렌 윌키");
		setPage(160);
	}
	
	//출력 메소드
	public void print() {
		System.out.println("*****Book*****");
		System.out.println("Title : "+getTitle());
		System.out.println("Writer : "+getWriter());
		System.out.println("Page : "+getPage());
		System.out.println("**************\n");
	}
}
