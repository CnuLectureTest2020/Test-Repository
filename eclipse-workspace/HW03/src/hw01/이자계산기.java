package hw01;

import java.awt.*;
import javax.swing.*;

class CC extends JFrame{
	JPanel p;
	public CC() {
		setTitle("이자 계산기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //Frame에 기본 간격을 만듦
		JPanel p1, p2;
		p1 = new JPanel();
		p2 = new JPanel();
		p1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //Panel간 간격 생성
		p2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); //Panel간 간격 생성
		p1.setLayout(new GridLayout(2, 2));
		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		
		JLabel l1 = new JLabel("원금을 입력하시오. 	");
		JLabel l2 = new JLabel("이율을 입력하시오. 	");
		JTextField t1 = new JTextField(10);
		JTextField t2 = new JTextField(10);
		JTextField t3 = new JTextField(30);
		JButton b = new JButton("변환");
		b.setAlignmentX(Component.CENTER_ALIGNMENT); //b 버튼을 가운데에 배치
		
		p1.add(l1);
		p1.add(t1);
		p1.add(l2);
		p1.add(t2);
		p2.add(t3);
		
		p.add(p1);
		p.add(b);
		p.add(p2);
		add(p);
		
		pack(); //Frame의 크기를 각 패널에 맞게끔 설정
		setVisible(true); //만든 Frame을 볼 수 있게 설정
		
	}
}

public class 이자계산기 {
	public static void main(String args[]) {
		CC c = new CC();
	}

}
