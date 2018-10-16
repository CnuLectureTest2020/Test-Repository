package 이번;

import java.util.Scanner;

public class 이번 {
	public static void main(String[] arg) {
		Scanner sc = new Scanner(System.in);
		String operator;
		double n1, n2, result;
		int n = 0;
		
		while(n==0) {
			operator = sc.next();
			switch(operator) {
			case "+":
				n1 = sc.nextDouble();
				n2 = sc.nextDouble();
				result = n1+n2;
				System.out.println(result);
				break;
			case "-":
				n1 = sc.nextDouble();
				n2 = sc.nextDouble();
				result = n1-n2;
				System.out.println(result);
				break;
			case "*":
				n1 = sc.nextDouble();
				n2 = sc.nextDouble();
				result = n1*n2;
				System.out.println(result);
				break;
			case "/":
				n1 = sc.nextDouble();
				n2 = sc.nextDouble();
				result = n1/n2;
				System.out.println(result);
				break;
			default:
				n++;
			}
		}
	}
}
