package 다이아몬드;
import java.util.Scanner;
public class 다이아몬드 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			for(int r = n-i; r>0; r--)
				System.out.print(" ");
			for(int r = 2*i-1; r>0; r--)
				System.out.print("*");
			System.out.println("");}  //여기까지가 그냥 피라미드 밑까지 쓰면 다이아몬드. 단, 층수가 2n-1만 출력됨//
		for(int i = 1; i<n; i++) {
			for(int r = i; r>0; r--)
				System.out.print(" ");
			for(int r =(n-i)*2-1; r>0; r--)
				System.out.print("*");
			System.out.println("");}
	}
}

