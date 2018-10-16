package hw_01;

public class CheckArray {
	public boolean solution(int array[]) { //참 거짓 판단 메소드
		
		boolean answer = false;
		int every = 0;           //1부터 array.length까지의 숫자 중 배열에 존재하는 숫자의 개수 
		
		for(int i=1; i<=array.length; i++) {    //i는 1~array.length까지의 수
			
			boolean find = false; //각 숫자를 찾았는지 확인
			
			for(int j=0; j<array.length&&find==false; j++) {  //j는 배열의 위치
				if(array[j]==i) {             //j위치의 수가 i와 일치하는가?
					find = true;      //i가 존재. 다음 i를 찾는 작업 실행을 위해 현 찾기 작업을 멈춤
					every++;          //i가 존재하므로 더함
				}
			}
		}
		if(every==array.length)       //1부터 length까지의 숫자가 모두 존재하는가?
			answer = true;
		
		return answer;           //참 거짓 결과를 리턴
	}
	
	public void print(int array[]) {  //받은 배열의 원소들과 참거짓을 출력하는 메소드
		System.out.print("array : ");
		for(int i=0; i<array.length; i++)  //배열의 원소들 출력
			System.out.print(array[i]+" ");
		System.out.println(solution(array));  //참 거짓 판단 메소드 이용하여 출력
	}
	
	public static void main(String args[]) {
		
		CheckArray ca = new CheckArray();   //정적 메소드(static)에서 정적 메소드가 아닌 메소드를 사용하기 위해 class 호출
		
		int array[] = {4, 1, 3, 2};
		int array2[] = {4, 1, 3};
		int array3[] = {5, 4, 1, 2, 3};
		int array4[] = {2, 4, 1, 1, 4};
		int array5[] = {3, 4, 2, 6, 1, 5};
		int array6[] = {4, 2, 5, 1, 3, 7};
		
		ca.print(array);
		ca.print(array2);
		ca.print(array3);
		ca.print(array4);
		ca.print(array5);
		ca.print(array6);
	}
}
