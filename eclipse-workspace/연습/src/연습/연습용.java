package 연습;

import java.util.Scanner;

public class 연습용 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = "";
		double a;
		System.out.print("'가나다'라고 입력해주세요. :");
		a = sc.nextLong();
		if(a.equals(6.))
			System.out.println("맞는 표현이군!");
		else
			System.out.println("안되나보네...");
	}
}
