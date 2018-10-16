package bankProgram;

import java.util.Scanner;
import java.util.ArrayList;

public class TestBankAccount {
	public static void main(String[] arg) {

		Scanner sc = new Scanner(System.in);

		int end = 0; // Bank 프로그램 반복여부 판단
		String user, string; // 기능 선택, 예금주 및 입력받을 시의 계좌번호
		int a, m, p; // 계좌번호, 금액, 비밀번호
		ArrayList<BankAccount> array = new ArrayList<BankAccount>();

		while (end == 0) {
			System.out.println("충남대 은행에 오신 것을 환영합니다.\n[1]계좌생성  [2]계좌조회  [3]계좌송금  [4]종료");
			user = sc.next();

			if ((int) user.charAt(0) >= 49 && (int) user.charAt(0) <= 52 && user.length() == 1) {
				if ((int) user.charAt(0) == 49) { // 계좌생성
					
					int n = 0;
					
					System.out.println("계좌번호 입력 :");
					string = sc.next();
					if (string.length() == 7 && string.charAt(3) == '-') {
						string = string.replaceAll("[^01234456789]", "");
						a = Integer.parseInt(string);
							
						for(int i = 0; i<array.size(); i++)
							if(array.get(i).accountNumber == a) {
								n++;
							}
						if(n==0) {
							a = Integer.parseInt(string);
							System.out.println("예금주 :");
							string = sc.next();
							System.out.println("초기 잔액 설정 :");
							m = sc.nextInt();
							System.out.println("계좌 비밀번호 설정(4자리):");
							p = sc.nextInt();
							if(p<=9999&&p>=0)
								array.add(new BankAccount(a, string, m, p)); // array에 입력한 기록 저장!
							else
								System.out.println("비밀번호는 4자리 숫자로만 생성해주세요.");
						}
						else
							System.out.println("이미 존재하는 계좌번호입니다. 다른 번호를 입력해주세요.");
					}
					else
						System.out.println("잘못된 형식의 계좌번호입니다. 000-000 형식으로 입력해주세요.\n프로그램이 재실행됩니다.");
					System.out.println("작업을 종료합니다. 프로그램이 재작동합니다.\n\n");
				}
				if ((int) user.charAt(0) == 50) { // 계좌조회
					System.out.println("조회할 계좌번호를 입력하세요.");
					string = sc.next();
					if (string.length() == 7 && string.charAt(3) == '-') {
						string = string.replaceAll("[^01234456789]", "");
						a = Integer.parseInt(string);

						int n = 0; // 계좌 존재 여부를 판단하는 변수 추가

						for (int i = 0; i < array.size(); i++) {
							if (array.get(i).accountNumber == a) { // 존재 여부 판단 및 출력
								System.out.println("계좌 번호 : " + string);
								System.out.println("예금주 : " + array.get(i).owner);
								System.out.println("잔액 : " + array.get(i).balance);
								n++; // 계좌 존재하므로 n함수값 변경
							}
						}
						if (n == 0) { // 존재하지 않을 시 실행
							System.out.println("현재 입력한 계좌번호는 존재하지 않습니다.");
							System.out.println("번호를 다시 확인하고 재시도해주세요.");
						}
					} else
						System.out.print("잘못된 형식의 계좌번호입니다. 000-000 형식으로 입력해주세요.\n프로그램이 재실행됩니다.");
					System.out.println("작업을 종료합니다. 프로그램이 재작동합니다.\n\n");
				}
				if ((int) user.charAt(0) == 51) { // 계좌송금
					System.out.println("본인의 계좌를 입력하여 주십시오.");
					string = sc.next();
					if (string.length() == 7 && string.charAt(3) == '-') {
						string = string.replaceAll("[^0123456789]", "");
						a = Integer.parseInt(string);

						int n = 0; // 계좌 존재 여부를 판단하는 변수 추가

						for (int i = 0; i < array.size(); i++) {
							if (array.get(i).accountNumber == a&&n==0) { // 존재 여부 판단 및 출력
								System.out.println("본인 비밀번호를 입력하여 주십시오.");
								p = sc.nextInt();
								if (array.get(i).password == p) {
									System.out.println("계좌확인 완료. 송금할 계좌를 입력하세요.");
									string = sc.next();
									string = string.replaceAll("[^0123456789]", "");
									a = Integer.parseInt(string);

									int n2 = 0; // 계좌 존재 여부를 판단하는 변수 추가

									for (int r = 0; r < array.size(); r++) {
										if (array.get(r).accountNumber == a) { // 존재 여부 판단 및 출력
											System.out.println("송금할 금액을 입력해주세요.");
											m = sc.nextInt();
											if(m<0)
												System.out.println("알맞은 금액을 입력해주세요.");
											else {
												if (array.get(i).balance >= m) {
													System.out.println("송금 완료!");
													System.out.println("잔여 금액 : "+array.get(i).sendAccount(m, array.get(r)));
												}
												else {
													System.out.println("한도 초과의 금액을 입력하였습니다.");
													System.out.println("보유 금액  내의 금액을 입력해주세요.");
												}
											}
											n2++;
										}
									}
									if (n2 == 0) { // 존재하지 않을 시 실행
										System.out.println("현재 입력한 계좌번호는 존재하지 않습니다.");
										System.out.println("번호를 다시 확인하고 재시도해주세요.");
									}
								} else
									System.out.println("잘못된 비밀번호입니다. 다시 시도해주세요.");
								n++; // 계좌 존재하므로 n함수값 변경
							}
						}
						if (n == 0) { // 존재하지 않을 시 실행
							System.out.println("현재 입력한 계좌번호는 존재하지 않습니다.");
							System.out.println("번호를 다시 확인하고 재시도해주세요.");
						}
					} else
						System.out.println("잘못된 형식의 계좌번호입니다. 000-000 형식으로 입력해주세요.");
					System.out.println("작업을 종료합니다. 프로그램이 재작동합니다.\n\n");
				}
				if ((int) user.charAt(0) == 52) { // 종료
					System.out.println("Bank Program을 종료합니다.");
					end++;
				}
			} else { // 1~4까지의 숫자가 아닌 입력을 받은 경우 재시작
				System.out.println(" 잘못된 입력입니다.\n원하는 작업의 번호(1~4)를 입력해주세요.");
				System.out.println("프로그램이 재작동합니다.\n\n");
			}
		}
	sc.close();
	}
}
