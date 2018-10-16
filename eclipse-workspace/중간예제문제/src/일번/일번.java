package 일번;

import java.util.Scanner;

public class 일번 {
		public static void main(String[] arg) {
			Scanner input = new Scanner(System.in);
			int [] numbers = new int[3];
		
			for(int i = 0; i<3; i++)
			numbers[i] = input.nextInt();
			int max = numbers[0];
			int min = numbers[0];
		
			for(int i = 1; i<3; i++) {
				if(numbers[i]>max)
					max = numbers[i];
				if(numbers[i]<min)
					min = numbers[i];
			}
			System.out.println(max/min);
			System.out.println(max%min);
		}
}
