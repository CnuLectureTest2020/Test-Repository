package bankProgram;

public class BankAccount {
	//필드값 생성
	int accountNumber; //계좌번호
	String owner; //예금주
	int balance; //잔액표시
	int password; //계좌 비밀번호
	
	public BankAccount(int num, String name, int money, int pw) {
		accountNumber = num;
		owner = name;
		balance = money;
		password = pw;
	}
	public void deposit(int amount) {  //저금 기능 메소드
		balance += amount;
	}
	public void withdraw(int amount) {  //인출 기능 메소드
		balance -= amount;
	}
	public int sendAccount(int amount, BankAccount otherAccount) {  //계좌이체 기능 메소드
		withdraw(amount);
		otherAccount.deposit(amount);
		return balance;
	}
}
