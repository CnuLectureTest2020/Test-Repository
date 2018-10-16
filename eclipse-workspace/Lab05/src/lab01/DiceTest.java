package lab01;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

public class DiceTest extends JFrame{
	
	static int size = 500; //화면의 사이즈 결정(이때 화면은 정사각형모양으로 한다.)
	static int dice = 2; //주사위의 개수
	DicePanel d = new DicePanel();
	JButton button = new JButton("주사위 다시 던지기");
	public DiceTest() {
		setSize(size, size);
		setTitle("주사위 던지기 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				d = new DicePanel();
				add(d);
				setVisible(true);
			}
		});
		add(button, BorderLayout.PAGE_END);
		add(d);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DiceTest();
	}
}

class DicePanel extends JPanel{
	private Dice[] d_array;
	private int[][] d_location; //주사위 생성 시 전 주사위의 위치를 확인하기 위한 2차원 배열
	private Color dice_c = Color.WHITE;
	private Color dot_c = Color.BLACK;
	
	public DicePanel() {
		System.out.println("AAA");
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
	private class Dice{
		private int d_size = 50; //주사위 사이즈
		private int x, y; //주사위 위치
		private int num; //주사위 숫자
		
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
