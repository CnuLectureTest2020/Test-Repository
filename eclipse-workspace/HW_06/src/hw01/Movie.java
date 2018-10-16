package hw01;

public class Movie {
	//영화 제목 필드 생성, String형
	String title;
	//평점 필드 생성, double형
	double rating;
	//감독 필드 생성, String형
	String director;
	//개봉년도 필드 생성, String형
	String publishDate;
	
	//영화의 모든 정보를 화면에 출력하는 메소드
	public void print() {
		System.out.print("영화의 제목 : "+title+"\n영화의 평점 : "+rating+"\n영화의 감독 : "+director+"\n영화 개봉년도 : "+publishDate);
	}
}
