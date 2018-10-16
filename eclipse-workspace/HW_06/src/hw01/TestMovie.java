package hw01;

public class TestMovie {
	public static void main(String[] arg) {
		Movie movie = new Movie();
		movie.director = "봉준호";
		movie.title = "괴물";
		movie.rating = 8.61;
		movie.publishDate = "2006년 07월 27일";
		
		movie.print();
	}
}
