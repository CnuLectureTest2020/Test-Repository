package 오번;

import java.util.Scanner;

public class 오번 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		int []n = new int[10];
		int user;
		int m = 10;
		
		for(int i=0; i<m; i++) {
			user = sc.nextInt();
			if(user<10)
				n[user]++;
		}
	}

}
