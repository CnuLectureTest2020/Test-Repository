package N02;

import java.util.*;

public class TestBook {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		Book[] book = new Book[2];
		
		for(int i=0; i<book.length; i++) {
			book[i] = new Book();
			System.out.print(i+1+"번째 책 이름 : ");
			String t= sc.next();
			book[i].setT(t);
			System.out.print(i+1+"번째 책 가격 : ");
			int p = sc.nextInt();
			book[i].setP(p);
		}
		System.out.println("\n-----------------");
		for(int i=0;i<book.length;i++)
			System.out.println(i+1+"번째 책 : "+book[i].getT()+"-"
		+book[i].getP()+"원");
	}
}
