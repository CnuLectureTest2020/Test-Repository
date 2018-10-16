package 사번;

import java.util.Scanner;

public class 사번 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		
		int n = 2;
		int result = 0;
		int []k = new int[n];
		int []e = new int[n];
		int []m = new int[n];
		
		for(int i=0; i<n; i++) {
			k[i] = sc.nextInt();
			e[i] = sc.nextInt();
			m[i] = sc.nextInt();
		}
		for(int i=0; i<n; i++) {
			if(k[i]>=e[i])
				result=k[i];
			else if(e[i]>=m[i])
				result=e[i];
			else
				result=m[i];
		}
		System.out.println(result);
	}

}
