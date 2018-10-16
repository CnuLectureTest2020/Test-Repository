package hw04;

import java.util.ArrayList;
import java.util.Random;

/*
원 그림을 포함하는 J패널을 J프레임에 붙여서 만들 것임

1. 원의 개수 : 임의로 정함
2. 원의 색 : 랜덤 함수 이용 ( 참고 : Lab04 )
3. 원의 위치 및 크기 : 랜덤 함수 이용 ( 참고 : lab04 )
*/

import java.awt.*;
import javax.swing.*;

public class CircleTest extends JFrame{ //메인 클래스
	
	static int size = 600;        //화면 사이즈 함수. 원 생성 시 크기와 생성위치를 결정해줌;
	
	public CircleTest() {
		setSize(size, size);
		setTitle("원 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new CirclePanel());
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CircleTest();
	}
}

class CirclePanel extends JPanel{        //원을 그릴 패널 클래스
	int circleNum = 10;                   //만들 원의 개수
	Circle[] c = new Circle[circleNum];   //원 클래스의 배열
	public CirclePanel() {
		for(int i=0; i<circleNum; i++) {
			c[i] = new Circle();
		}
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int i=0; i<circleNum; i++) {
			g.setColor(new Color(c[i].colorR, c[i].colorG, c[i].colorB));
			g.fillOval(c[i].x, c[i].y, c[i].c_size, c[i].c_size);
		}
		
	}
	
	class Circle{                    //원의 정보를 담고 있는 내부 클래스
		int x, y;
		int c_size;
		int colorR, colorG, colorB;
		public Circle() {
			c_size = Random(CircleTest.size/2, CircleTest.size/5);  //원의 최대크기 : 화면크기/2, 최소크기 : 화면크기/5로 지정
			x = Random(CircleTest.size-c_size/2, -CircleTest.size/10); //실험 예시를 참고하여 상하좌우 면에 원이 가려지는 경우도 생각하여 위치지정
			y = Random(CircleTest.size-c_size/2, -CircleTest.size/10);
			
			colorR = Random(255, 0);
			colorG = Random(255, 0);
			colorB = Random(255, 0);
		}
		
		int Random(int max, int min) {  //랜덤을 더 깔끔하게 쓰기위해서 추가한 메소드
			Random rand = new Random();
			int n = rand.nextInt(max-min+1)+min;
			return n;
		}
	}
}