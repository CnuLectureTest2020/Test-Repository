package hw04;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/* *주사위 점*
 * 주사위의 점이 찍혀있는 모양을 고려했을 때, 점이 찍힐 수 있는 위치는 총 7개이다.
 * 점의 위치의 규칙성을 살펴보았을 때, 홀수일 때마다 가운데에 점을 생성한다.
 * 가운데 점을 빼고 생각한다면, 숫자가 2증가할 때마다 점 2개가 서로 극 방향에 추가로 생성된다. 또한 6일 경우에는 일자로 생성된다. 
 * 이를 구현하기 위해 switch문을 이용하도록 하겠다.
 * 
 * *주사위 위치*
 * 겹치지 않게 하기 위해서는 먼저 그린 주사위(혹은 들)의 위치를 고려해야 한다.
 * 랜덤으로 좌표를 설정하고 이전에 생성된 주사위의 위치를 비교하면서 다시 위치를 설정할지를 결정한다.
 * 도형이 그려지는 함수를 참고했을 때 도형의 좌표는 그 도형이 딱 들어가는 사각형 왼쪽에서 가장 윗 부분 모서리의 위치를 뜻한다.
 * 때문에 주사위가 겹쳐지지 않으려면 x좌표는 (다른 주사위의 x좌표)+(주사위 크기)보다 크거나 (다른 주사위의 x좌표)-(주사위 크기)보다 작아야한다.
 * y좌표 또한 이와 동일하다.
 * 이점을 유의하여 프로그래밍 하도록 하자.
 */

public class DiceTest extends JFrame{
	
	static int size = 1000; //화면의 사이즈 결정(이때 화면은 정사각형모양으로 한다.)
	static int dice; //주사위의 개수
	
	public DiceTest() {
		setSize(size, size);
		setTitle("주사위 던지기 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new DicePanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("만들 주사위 개수를 입력하시오. :");	//이벤트 처리를 아직 잘 몰라서ㅜㅜ 시스템에서 주사위 개수를 결정하자
		dice = sc.nextInt();
		new DiceTest();
	}
}

class DicePanel extends JPanel{
	Dice[] d_array;
	int[][] d_location; //주사위 생성 시 전 주사위의 위치를 확인하기 위한 2차원 배열
	Color dice_c = Color.WHITE;
	Color dot_c = Color.BLACK;
	
	public DicePanel() {
		d_array = new Dice[DiceTest.dice];
		d_location = new int[DiceTest.dice-1][2]; //마지막 주사위의 위치는 저장할 필요가 없으므로 -1
		for(int i=0; i<DiceTest.dice; i++) {
			if(i==0) d_array[i] = new Dice();
			else {
				d_location[i-1][0] = d_array[i-1].x; //크기 오류를 막기 위해 else에 삽입함
				d_location[i-1][1] = d_array[i-1].y;
				d_array[i] = new Dice(i,d_location);
			}
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(Color.PINK);
		for(int i=0; i<DiceTest.dice; i++) {
			g.setColor(dice_c);
			g.fillRoundRect(d_array[i].x, d_array[i].y, d_array[i].d_size, d_array[i].d_size, 10, 10); //주사위
			g.setColor(dot_c);
			g.drawRoundRect(d_array[i].x, d_array[i].y, d_array[i].d_size, d_array[i].d_size, 10, 10); //주사위 테두리
			if(d_array[i].num%2==1)  //주사위 가운데 점이 있는 경우 = 숫자가 홀수일 때를 의미. 숫자 1를 완성시킴
				g.fillOval(d_array[i].x+20, d_array[i].y+20, 10, 10);	//정가운데 점
			
			switch(d_array[i].num-1) {
			case 5:	//숫자 6. 점 6개 그림
				g.fillOval(d_array[i].x+5, d_array[i].y+20, 10, 10);	//좌측 2번째 점
				g.fillOval(d_array[i].x+35, d_array[i].y+20, 10, 10);	//우측 2번째 점
			case 4:	//숫자 5. 위에서 점 1개를 더했으므로 앞으로 4개 점 그림
			case 3:	//숫자 4. 점 4개 그림
				g.fillOval(d_array[i].x+5, d_array[i].y+35, 10, 10);	//좌측 3번째 점
				g.fillOval(d_array[i].x+35, d_array[i].y+5, 10, 10);	//우측 1번째 점
			case 2:	//숫자 3. 위에서 점 1개를 더했으므로 앞으로 3개 점 그림
			case 1: //숫자 2. 점 2개 그림
				g.fillOval(d_array[i].x+5, d_array[i].y+5, 10, 10);		//좌측 1번째 점
				g.fillOval(d_array[i].x+35, d_array[i].y+35, 10, 10);	//우측 3번째 점
			}
		}
	}	
	class Dice{
		int d_size = 50; //주사위 사이즈
		int x, y; //주사위 위치
		int num; //주사위 숫자
		
		public Dice() {  //첫 번재 주사위 생성 시 사용하는 생성자
			num = Random(6, 1);
			x = Random(DiceTest.size-2*d_size, 0);	//보기 좋은 위치에 있도록 값 최대값을 조절함
			y = Random(DiceTest.size-2*d_size, 0);	//보기 좋은 위치에 있도록 값 최대값을 조절함
		}
		
		public Dice(int n, int[][] location) { //이후 주사위 생성 시 사용하는 생성자로, 2차원 배열의 인자를 통해 타 주사위의 위치를 인식
			this.num = Random(6, 1);
			boolean f_result = true;		//do while문 탈출여부
			do {
				x = Random(DiceTest.size-2*d_size, 0);	//보기 좋은 위치에 있도록 값 최대값을 조절함
				y = Random(DiceTest.size-2*d_size, 0);	//보기 좋은 위치에 있도록 값 최대값을 조절함
				
				boolean result = false;		//겹치는 자리인가? 일단 아니라고 두자.
				for(int i=0; i<n; i++) {
					if(x>=location[i][0]-d_size&&x<=location[i][0]+d_size&&y>=location[i][1]-d_size&&y<=location[i][1]+d_size)
						result = true;		//겹친다
				}
				if(result==false) f_result=false; //다 안겹치면 do while문 탈출
			}while(f_result);
		}
		
		int Random(int max, int min) {  //랜덤을 더 깔끔하게 쓰기위해서 추가한 메소드
			Random rand = new Random();
			int n = rand.nextInt(max-min+1)+min;
			return n;
		}
	}
}
