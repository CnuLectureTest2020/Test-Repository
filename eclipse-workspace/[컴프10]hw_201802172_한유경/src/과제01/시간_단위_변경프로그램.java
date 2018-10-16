package 과제01;

import java.util.Scanner;

public class 시간_단위_변경프로그램 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int s1, s2, m, h;
		Scanner sc = new Scanner(System.in);
		System.out.print("변환할 초 입력 : ");
		s1 = sc.nextInt();
		
		m = s1/60;
		h = m/60;
		s2 = s1-m*60;
		m = m-h*60;
		
		System.out.println(s1+"초는 "+h+"시간 "+m+"분 "+s2+"초입니다.");
	}

}
