package »ï¹ø;

import java.util.Scanner;

public class »ï¹ø {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n>0) {
			int m=n;
			for(int i=1; i<n; i++) {
				m=m*n;
			}			
			System.out.println(m);
		}

		else if(n==0)
			System.out.println(n);
		else
			System.out.println(n*-1);
		
	}

}
