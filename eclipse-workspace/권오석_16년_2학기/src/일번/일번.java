package 일번;
import java.util.Scanner;
public class 일번 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		String ch = sc.nextLine();
		switch(ch) {
		case "a":
			System.out.println("America");
			break;
		case "b":
			System.out.println("Britain");
			break;
		case "c":
			System.out.println("Canada");
			break;
		case "d":
			System.out.println("Denmark");
			break;
		default:
			System.out.println("Korea");
		}
	}

}
