import java.awt.*;
import javax.swing.*;

public class 도히 extends JFrame{
	   public 도히() {
		      setSize(500, 500);
		      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		      setTitle("DiceTest");
		      setVisible(true);
		      add(new MyPanel());
		   }
		   
	   public static void main(String args[]) {
		   도히 s = new 도히();}
}


class MyPanel extends JPanel {
   //public int centerX, centerY;
   
   /*public void Dice(int centerX, int centerY) {
      centerX = this.centerX;
      centerY = this.centerY;
   }*/
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      
      for(int i=0; i<2; i++) {
         int centerX = (int)(Math.random() * 440);
         int centerY = (int)(Math.random() * 440);
      
         
      g.setColor(Color.WHITE);
      g.fillRoundRect(centerX, centerY, 60, 60, 20, 20);
         
      int num = (int)(Math.random()*5);
      g.setColor(Color.BLACK);
      
      if(num==0)
         g.fillOval(centerX+25, centerY+25, 10, 10);
      if(num==1) {
         g.fillOval(centerX+15, centerY+15, 10, 10);
         g.fillOval(centerX+35, centerY+35, 10, 10);}
      if(num==2) {
         g.fillOval(centerX+40, centerY+40, 10, 10);
         g.fillOval(centerX+10, centerY+10, 10, 10);
         g.fillOval(centerX+25, centerY+25, 10, 10);}
      if(num==3) {
         g.fillOval(centerX+40, centerY+40, 10, 10);
         g.fillOval(centerX+10, centerY+10, 10, 10);
         g.fillOval(centerX+40, centerY+10, 10, 10);
         g.fillOval(centerX+10, centerY+40, 10, 10);}
      if(num==4) {
         g.fillOval(centerX+40, centerY+40, 10, 10);
         g.fillOval(centerX+10, centerY+10, 10, 10);
         g.fillOval(centerX+40, centerY+10, 10, 10);
         g.fillOval(centerX+10, centerY+40, 10, 10);
         g.fillOval(centerX+25, centerY+25, 10, 10);
      }
      if(num==5) {
         g.fillOval(centerX+25, centerY+40, 10, 10);
         g.fillOval(centerX+25, centerY+10, 10, 10);
         g.fillOval(centerX+40, centerY+40, 10, 10);
         g.fillOval(centerX+10, centerY+10, 10, 10);
         g.fillOval(centerX+40, centerY+10, 10, 10);
         g.fillOval(centerX+10, centerY+40, 10, 10);
      }
      }
   }
}