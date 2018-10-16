package hw03;

import java.util.Scanner;

public class hw03 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		String user;
		System.out.print("문자열 입력 : ");
		user = sc.nextLine();
		
		for(int i = 0; i<user.length(); i++) {
			if((int)user.charAt(i)>=65&&(int)user.charAt(i)<=90)
				System.out.print((char)((int)user.charAt(i)+32));
			else if((int)user.charAt(i)>=97&&(int)user.charAt(i)<=122)
				System.out.print((char)((int)user.charAt(i)-32));
			else
				System.out.print(user.charAt(i));
		}
	}

}
