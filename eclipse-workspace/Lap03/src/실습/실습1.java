package 실습;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class FlowTest extends JFrame{
	public FlowTest() {
		
		setTitle("FlowLayoutTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel;
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		panel.add(new JButton("Button1"));
		panel.add(new JButton("Button2"));
		panel.add(new JButton("Button3"));
		panel.add(new JButton("B4"));
		panel.add(new JButton("Long Button1"));
		add(panel);
		
		pack();
		setVisible(true);
		
	}
}

class BorderTest extends JFrame{
	public BorderTest() {
		setTitle("BorderLayoutTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new BorderLayout());
		
		add(new JButton("Center"), BorderLayout.CENTER);
		add(new JButton("Line Start"), BorderLayout.LINE_START);
		add(new JButton("Line End"), BorderLayout.LINE_END);
		add(new JButton("Page Start"), BorderLayout.NORTH);
		add(new JButton("Page End"), BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
}

class GridTest extends JFrame{
	public GridTest() {
		setTitle("GridLayoutTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(0,3));
		
		add(new JButton("Button1"));
		add(new JButton("Button2"));
		add(new JButton("Button3"));
		add(new JButton("B4"));
		add(new JButton("Long Button5"));
		
		pack();
		setVisible(true);
	}
}

class BoxTest extends JFrame{
	public BoxTest() {
		setTitle("BoxLayoutTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		makeButton(panel, "Button1");
		makeButton(panel, "Button2");
		makeButton(panel, "Button3");
		makeButton(panel, "B4");
		makeButton(panel, "Long Button5");
		add(panel);
		pack();
		setVisible(true);
	}
	
	private void makeButton(JPanel panel, String text) {
		JButton button = new JButton(text);
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(button);
	}
}

class CardTest extends JFrame implements ActionListener{
	JPanel panel;
	Cards cards;
	
	public CardTest() {
		setTitle("CardLayoutTest");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 200);
		panel = new JPanel( new GridLayout(0, 5, 10, 0));
		addButton("<<", panel);
		addButton("<", panel);
		addButton(">", panel);
		addButton(">>", panel);
		addButton("종료", panel);
		add(panel, "North");
		cards = new Cards();
		add(cards, "Center");
		setVisible(true);
	}
	void addButton(String str, Container target) {
		JButton button = new JButton(str);
		button.addActionListener(this);
		target.add(button);
	}
	
	private class Cards extends JPanel{
		CardLayout layout;
		public Cards() {
			layout = new CardLayout();
			setLayout(layout);
			for(int i = 1; i<=10; i++) {
				add(new JButton("현재 카드의 번호는 "+i+"입니다."), "Center");
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("종료")) {
			System.exit(0);
		} else if (e.getActionCommand().equals("<<")) {
			cards.layout.first(cards);
		} else if (e.getActionCommand().equals("<")) {
			cards.layout.previous(cards);
		} else if (e.getActionCommand().equals(">")) {
			cards.layout.next(cards);
		} else if (e.getActionCommand().equals(">>")) {
			cards.layout.last(cards);
		}
	}
}

public class 실습1 {
	public static void main(String argv[]) {
		FlowTest F = new FlowTest();
		BorderTest B = new BorderTest();
		GridTest G = new GridTest();
		BoxTest Box = new BoxTest();
		CardTest C = new CardTest();
	}

}
