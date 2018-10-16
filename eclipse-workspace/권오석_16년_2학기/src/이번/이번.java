package 이번;
import java.util.Scanner;
public class 이번 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i =1; i<=n; i++) {
			for(int r = n-i; r>0; r--)
				System.out.print(" ");
			for(int r = 0; r<i; r++)
				System.out.print("*");
			System.out.println("");}
		for(int i = 1; i<n; i++) {
			for(int r=0; r<i; r++)
				System.out.print(" ");
			for(int r=n-i; r>0; r--)
				System.out.print("*");
			System.out.println("");}
	}
}