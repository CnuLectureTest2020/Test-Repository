package hw_04;

import java.util.Scanner;

public class Convert {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int intger; //사용자로부터 입력받은 프로그램 실행횟수를 저장할 변수
		String user; //변환할 16진수
		
		System.out.print("Test Case 개수를 입력하시오 : "); //사용자로부터 반복 횟수를 입력받는다.
		intger = sc.nextInt();
		for(int i=0; i<intger; i++) {  //반복횟수만큼 연산 실행
			System.out.print("16진수 입력 : ");
			user = sc.next();  //사용자로부터 변환할 16진수 값을 받는다.
			
			for(int r=0; r<user.length(); r++) { //각 문자열 하나하나를 2진수로 변환한다. 받은 길이만큼 변환작업 실행 
				if((int)user.charAt(r)>=65&&(int)user.charAt(r)<=70) { //A~F일 경우
					System.out.print(user.charAt(r)+", "+(10+(int)user.charAt(r)-65)+", "); //문자의 경우 10을 더함
					
					int converting = (int)user.charAt(r)-55; //문자열의 값에 65-10한 값을 임시로 저장한다.
					
					for(int n=3; n>=0; n--) { //총 4개의 2진수 출력함
						int two = 1; //2의 제곱을 저장할 임시 변수 생성
						for(int m = n; m>0; m--) //n+1번째 자리의 값으로 two를 만들어준다.
							two = two*2;
						if(converting>=two) { //비교를 통해 converting이 더 클 경우
							System.out.print(1); //1출력
							converting=converting-two; //이후 다음 자리수를 비교하기 위해 two를 뺀다.
						}
						else
							System.out.print(0);} //작을 경우 0 출력
				}
				else if((int)user.charAt(r)>=48&&(int)user.charAt(r)<=57) { //숫자일 경우
					System.out.print(user.charAt(r)+", "+((int)user.charAt(r)-48)+", ");
					
					int converting = (int)user.charAt(r)-48; //숫자는 변환하면 48만 빼주면 원래 값이 된다.
					
					for(int n=3; n>=0; n--) { //문자열 변환과 동일
						int two = 1;
						for(int m = n; m>0; m--)
							two = two*2;
						if(converting>=two) {
							System.out.print(1);
							converting=converting-two;
						}
						else
							System.out.print(0);}
				}
				System.out.println(); //다음 문자열 자리 출력을 위해 한줄을 띈다.
			}
		}
		sc.close();
	}
}
