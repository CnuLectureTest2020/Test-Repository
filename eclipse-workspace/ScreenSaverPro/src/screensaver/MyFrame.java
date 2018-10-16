package screensaver;

// repaint 함수 추가하고, run()메소드가 어디에 위치해야할 지 파악.

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MyFrame extends JFrame implements Runnable {
	
	public MyFrame() {
		setTitle("화면보호기 만들기");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyPanel1 p1 = new MyPanel1();
		add(p1);
		//setVisible(true);
		run();
		
		
		MyPanel2 p2 = new MyPanel2();
		add(p2);
		//setVisible(true);
		run();
		
		
		
		MyPanel3 p3 = new MyPanel3();
		add(p3);
		//setVisible(true);
		run();
	
		
		MyPanel4 p4 = new MyPanel4();
		add(p4);
		//setVisible(true);
		run();
	
		
		MyPanel5 p5 = new MyPanel5();
		add(p5);
		//setVisible(true);
		run();
	
		
		MyPanel6 p6 = new MyPanel6();
		add(p6);
		//setVisible(true);
		run();
	
		
		MyPanel7 p7 = new MyPanel7();
		add(p7);
		//setVisible(true);
		run();

		
		MyPanel8 p8 = new MyPanel8();
		add(p8);
		//setVisible(true);
		run();
	
		
		MyPanel9 p9 = new MyPanel9();
		add(p9);
		//setVisible(true);
		run();
	
		
		MyPanel10 p10 = new MyPanel10();
		add(p10);
		//setVisible(true);
		run();
	
		
		repaint();
		
		/*MyPanel0 p0 = new MyPanel0();
		add(p0);
		run(); */
		
		setVisible(true);
	}
	
	/*class MyPanel0 extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			run();
			repaint();
		}
	} */
	

	class MyPanel1 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			for(int i=0;i<1;i++) {
				g2.drawLine(r.nextInt(500),r.nextInt(500),r.nextInt(500),r.nextInt(500));
			}
			repaint();
			
			
		}
	
	}
	
	


	class MyPanel2 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			
			for(int i =0;i<2;i++) {
				g2.drawLine(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
			}
			repaint();
		}
	}
	
	class MyPanel3 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			for(int i =0;i<3;i++) {
				g2.drawLine(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
			}
			repaint();
			
		}
	}
	
	class MyPanel4 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			
			for(int i =0;i<4;i++) {
				g2.drawLine(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
			}
			repaint();
		}
	}
	class MyPanel5 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			
			for(int i =0;i<5;i++) {
				g2.drawLine(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
			}	
			repaint();
		}
	}
	class MyPanel6 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			
			for(int i =0;i<6;i++) {
				g2.drawLine(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
			}
			repaint();
		}
	}
	class MyPanel7 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			
			for(int i =0;i<7;i++) {
				g2.drawLine(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
			}
			repaint();
		}
	}
	class MyPanel8 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			
			for(int i =0;i<8;i++) {
				g2.drawLine(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
			}
			repaint();
		}
	}
	class MyPanel9 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			
			for(int i =0;i<9;i++) {
				g2.drawLine(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
			}
			repaint();
		}
	}
	class MyPanel10 extends JPanel{
		public void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			run();
			Random r = new Random();
			Graphics2D g2 = (Graphics2D)g;
			
			
			for(int i =0;i<10;i++) {
				g2.drawLine(r.nextInt(500), r.nextInt(500), r.nextInt(500), r.nextInt(500));
			}
			repaint();
			
		}
	}
	public void run() {
		try {
			setVisible(true);
			Thread.sleep(1000);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]) {
		
		MyFrame f = new MyFrame();
	
	}
	
}
