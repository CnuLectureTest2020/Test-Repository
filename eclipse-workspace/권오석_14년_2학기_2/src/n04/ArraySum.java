package n04;

import java.util.*;

public class ArraySum {
	public static void ReadArray(double array[][]) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<array.length;i++)
			for(int j=0;j<array[i].length;j++) {
				System.out.print(i+1+"행 ");
				System.out.print(j+1+"열 : ");
				array[i][j] = sc.nextDouble();
			}
	}
	public static double SumArray(double array[][]) {
		double sum = 0;
		for(int i=0;i<array.length;i++)
			for(int j=0;j<array[i].length;j++)
				sum+=array[i][j];
		return sum;
	}
	public static void main(String[] arg) {
		double[][] array = new double[2][2];
		System.out.println("20행 10열 2차원 배열 입력");
		ReadArray(array);
		System.out.println("2차원 배열의 합 : "+SumArray(array));
	}
}
