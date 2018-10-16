package lab01;

import java.awt.*;
import javax.swing.*;

public class Snowman extends JFrame{
	public Snowman() {
		setSize(280, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("´«»ç¶÷ ¾ó±¼");
		setVisible(true);
		add(new MyPanel());
	}
	
	public static void main(String[] args) {
		Snowman snowman = new Snowman();
	}
}

class MyPanel extends JPanel{
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		g.fillOval(20, 30, 200, 200);
		g.setColor(Color.black);
		g.drawArc(60, 80, 50, 50, 180, -180);
		g.drawArc(150, 80, 50, 50, 180, -180);
		g.drawArc(70, 130, 100, 70, 180, 180);
	}
}
