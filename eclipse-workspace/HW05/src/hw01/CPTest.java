package hw01;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CPTest extends JFrame {
	public CPTest() {
		setTitle("계산기 프로그램"); // Frame의 타이틀 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new CP());
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		new CPTest();
	}
}

class CP extends JPanel {
	private JPanel p, p1, p2; // 순서대로 계산결과창, 지우기 버튼, 계산기 입력 버튼을 담을 패널
	private String num1 = "0"; // 계산할 첫번째 숫자
	private String num2 = "0"; // 계산할 두번째 숫자
	private double result; // 계산 결과값
	private boolean noNumber = true; // 계산버튼이 연속으로 눌리는 것을 방지
	private boolean operate = false; // 앞에 먼저 계산해야하는 것이 존재하는가?
	private int f_operate = 0; // 사칙연산. 0일 때는 아무 계산도 하지 않는다.
	private JTextField t = new JTextField(20); // 계산 결과를 나타내는 창
	private JButton c = new JButton("    C    "); // 초기화 버튼
	private JButton[] numbers = new JButton[10]; // 숫자 버튼
	private JButton[] oper = new JButton[6]; // 기호 버튼

	public CP() {
		MyListener l = new MyListener(); // 이벤트를 수행하기 위해 추가
		setLayout(new BorderLayout());

		// 패널 간격 설정 및 생성
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10)); // TextField과 타 컴포넌트 간 간격을 만듦

		p1 = new JPanel();
		p1.setBorder(BorderFactory.createEmptyBorder(0, 1, 0, 0));

		p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 4, 5, 5));
		p2.setBorder(BorderFactory.createEmptyBorder(0, 6, 6, 6));

		// 버튼 이벤트 작성 및 각 패널에 추가
		p.add(t);
		c.addActionListener(l);
		p1.add(c);
		for (int i = 0; i < 10; i++) {
			numbers[i] = new JButton("" + i);
			numbers[i].addActionListener(l);
		}
		oper[0] = new JButton("/");
		oper[0].addActionListener(l);
		oper[1] = new JButton("*");
		oper[1].addActionListener(l);
		oper[2] = new JButton("-");
		oper[2].addActionListener(l);
		oper[3] = new JButton(" Back");
		oper[3].addActionListener(l);
		oper[4] = new JButton("=");
		oper[4].addActionListener(l);
		oper[5] = new JButton("+");
		oper[5].addActionListener(l);

		for (int i = 0; i < 4; i++) { // 1번째 반복문, 행
			int n = 7 - i * 3;
			for (int j = 0; j < 4; j++) { // 2번째 반복문, 행에 따라서 열을 만듦
				if (i == 3) {
					p2.add(numbers[0]);
					for (int m = 3; m < 6; m++) {
						p2.add(oper[m]);
					}
					j = 4; // 마지막 줄 반복 종료
				} else if (j == 3) {
					p2.add(oper[i]);
				} else {
					p2.add(numbers[n]);
				}
				n++;
			}
		}

		// 패널에 추가
		add(p, BorderLayout.PAGE_START);
		add(p1, BorderLayout.LINE_START);
		add(p2, BorderLayout.PAGE_END);
	}

	private double Compute(int i) { // 계산을 하는 메소드
		if (i == 1) { // 나누기
			result = result / Integer.parseInt(num2); // result는 실수형이므로 이때 오류가 발생하지 않는다. 따라서 정수형으로 변경하여 오류를 잡아보겠다.
			try {
				int zero = (int) result / Integer.parseInt(num2); // 임의의 정수형 데이터에 계산을 넣어본다.
			} catch (Exception e) { // 0을 나누려고 한 경우
				f_operate = 5;
				Compute(f_operate); // 자체적으로 한 번 더 Compute 메소드 실행
			}
		} else if (i == 2) { // 곱하기
			result = result * Integer.parseInt(num2);
		} else if (i == 3) { // 빼기
			result = result - Integer.parseInt(num2);
		} else if (i == 4) { // 더하기
			result = result + Integer.parseInt(num2);
		} else if (i == 5) { // 0을 나눈 경우
			num1 = "0으로 나눌 수 없습니다.";
			t.setText(num1);
		} else {
			result = Integer.parseInt(num1);
		}
		return result;
	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == c) { // 초기화 버튼. 모든 값을 초기화 시킨다.
				num1 = "0";
				num2 = "0";
				operate = false;
				f_operate = 0;
				t.setText("");
			} else if (f_operate != 5) {// 0을 나눈 경우 초기화만 작동하도록 만든다.
				if (e.getSource() == numbers[0]) { // 각 숫자를 받아서 저장. 아직은 result에 넣지않는다. (Back 이용을 위해)
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 0);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 0);
						t.setText(num1 + num2);
					}
				} else if (e.getSource() == numbers[1]) {
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 1);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 1);
						t.setText(num1 + num2);
					}
				} else if (e.getSource() == numbers[2]) {
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 2);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 2);
						t.setText(num1 + num2);
					}
				} else if (e.getSource() == numbers[3]) {
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 3);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 3);
						t.setText(num1 + num2);
					}
				} else if (e.getSource() == numbers[4]) {
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 4);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 4);
						t.setText(num1 + num2);
					}
				} else if (e.getSource() == numbers[5]) {
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 5);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 5);
						t.setText(num1 + num2);
					}
				} else if (e.getSource() == numbers[6]) {
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 6);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 6);
						t.setText(num1 + num2);
					}
				} else if (e.getSource() == numbers[7]) {
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 7);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 7);
						t.setText(num1 + num2);
					}
				} else if (e.getSource() == numbers[8]) {
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 8);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 8);
						t.setText(num1 + num2);
					}
				} else if (e.getSource() == numbers[9]) {
					noNumber = false;
					if (operate == false) {
						num1 = "" + Integer.parseInt(num1 + 9);
						t.setText(num1);
					} else {
						num2 = "" + Integer.parseInt(num2 + 9);
						t.setText(num1 + num2);
					}
				} else if (noNumber == false) {
					if (e.getSource() == oper[0]) { // 나누기
						if (operate == false) {
							result = Integer.parseInt(num1);
							num1 = num1 + "/";
							t.setText(num1);
							f_operate = 1;
							operate = true;
						} else {
							result = Compute(f_operate);
							num1 = num1 + num2 + "/";
							num2 = "0";
							t.setText(num1);
							f_operate = 1;
						}
						noNumber = true;
					} else if (e.getSource() == oper[1]) { // 곱하기
						if (operate == false) {
							result = Integer.parseInt(num1);
							num1 = num1 + "*";
							t.setText(num1);
							f_operate = 2;
							operate = true;
						} else {
							result = Compute(f_operate);
							num1 = num1 + num2 + "*";
							num2 = "0";
							t.setText(num1);
							f_operate = 2;
						}
						noNumber = true;
					} else if (e.getSource() == oper[2]) { // 빼기
						if (operate == false) {
							result = Integer.parseInt(num1);
							num1 = num1 + "-";
							t.setText(num1);
							f_operate = 3;
							operate = true;
						} else {
							result = Compute(f_operate);
							num1 = num1 + num2 + "-";
							num2 = "0";
							t.setText(num1);
							f_operate = 3;
						}
						noNumber = true;
					} else if (e.getSource() == oper[3]) { // 뒤로. 숫자를 다시 입력할 수 있다.
						if (operate == false) {
							num1 = "0";
							t.setText("");
						} else {
							num2 = "0";
							t.setText(num1);
						}
						noNumber = true;
					} else if (e.getSource() == oper[4]) { // 결과. 전에 입력한 사칙연산을 이용한 마지막 계산을 한 후 결과값을 출력한다.
						result = Compute(f_operate);
						if (f_operate != 5) {
							operate = false;
							f_operate = 0;
							num2 = "0";
							if (result == (int) result)
								num1 = "" + (int) (result);
							else
								num1 = "" + result;
							t.setText(num1);
							result = 0; // 다음 계산이 필요한 경우를 위해 리셋
						}
					} else if (e.getSource() == oper[5]) { // 더하기
						if (operate == false) {
							result = Integer.parseInt(num1);
							num1 = num1 + "+";
							t.setText(num1);
							f_operate = 4;
							operate = true;
						} else {
							result = Compute(f_operate);
							num1 = num1 + num2 + "+";
							num2 = "0";
							t.setText(num1);
							f_operate = 4;
						}
						noNumber = true;
					}
				}
			}
		}
	}
}