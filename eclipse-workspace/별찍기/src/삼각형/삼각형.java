package »ï°¢Çü;
import java.util.Scanner;
public class »ï°¢Çü {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i<=n; i++) {
			for(int r=0; r<i; r++)
				System.out.print("*");
			System.out.println("");}
		
		for(int i = 0; i<n; i++) {
			for(int r= n-i; r>0; r--)
				System.out.print("*");
			System.out.println("");}
		
		for(int i=1; i<=n; i++) {
			for(int r =n-i; r>0; r--)
				System.out.print(" ");
			for(int r = i; r>0; r--)
				System.out.print("*");
			System.out.println("");}
		
		for(int i=0; i<n; i++) {
			for(int r=i; r>0; r--)
				System.out.print(" ");
			for(int r=n-i; r>0; r--)
				System.out.print("*");
			System.out.println("");}
	}
}
