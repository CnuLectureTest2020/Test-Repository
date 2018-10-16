package n01;

import java.util.*;

public class N01 {
	public static void main(String[] arg) {
		String string;
		char ch;
		int a=0; int b=0;
		
		Scanner sc = new Scanner(System.in);
		string = sc.nextLine();
		
		for(int i=0; i<string.length(); i++) {
			ch = string.charAt(i);
			if(ch>='A'&&ch<='Z')
				a++;
			else if(ch==' ')
				b++;
		}
		System.out.println("대문자 : "+a+"개");
		System.out.println("공백 : "+b+"개");
	}

}
