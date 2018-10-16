package hw02;

import java.awt.*;
import javax.swing.*;

class CP extends JFrame{
	JPanel p, p1, p2; //순서대로 계산결과창, 지우기 버튼, 계산기 입력 버튼을 담을 패널
	
	public CP() { //생성자
		setTitle("계산기 프로그램(Demo)"); //Frame의 타이틀 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10)); //TextField과 타 컴포넌트 간 간격을 만듦
		JTextField t = new JTextField(20);
		p.add(t);
		
		p1 = new JPanel();
		p1.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));
		JButton c = new JButton("    C    "); //버튼의 간격을 설정하기 위해 공백을 추가함(버튼 사이즈는 효과가 없어서...)
		p1.add(c);
		
		p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 4, 5, 5));
		p2.setBorder(BorderFactory.createEmptyBorder(0, 6, 6, 6));		
		
		String [] s = new String[6];
		s[0] = "/"; s[1] = "*";s[2] = "-"; s[3] = "Back "; s[4] = "="; s[5] = "+";
		

		
		for(int i=0; i<4; i++) { //1번째 반복문, 행
			int n = 7-i*3;
			for(int j=0; j<4; j++) { //2번째 반복문, 행에 따라서 열을 만듦
				if(i==3) {
					JButton b0 = new JButton("0");
					p2.add(b0);
					for(int m=3; m<6; m++) {
						JButton b = new JButton(s[m]);
						p2.add(b);
					}
					j = 4; //마지막 줄 반복을 끝내기 위해 2번째 반복문을 종료시킴
				}
				else if(j==3) {
					JButton b = new JButton(s[i]);
					p2.add(b);
				}
				else {
					JButton b = new JButton(""+n); //JButton의 버튼 이름은 String으로만 가능
					p2.add(b);
					n++;
				}
			}
		}
		
		//JFrame은 Layout형식이 BorderLayout이므로 이 형식에 맞추어 각 Panel을 삽입
		add(p, BorderLayout.PAGE_START);
		add(p1, BorderLayout.LINE_START);
		add(p2, BorderLayout.PAGE_END);
		
		pack(); //Frame의 크기를 각 패널에 맞게끔 설정
		setVisible(true); //만든 Frame을 볼 수 있게 설정
		
	}
}

public class CPTest {
	public static void main(String argv[]) {
		CP cp = new CP();
	}
}
