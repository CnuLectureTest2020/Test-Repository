package Start;

import java.util.*;

public class Login {
	Scanner sc = new Scanner(System.in);
	
	private ArrayList<User> Users= new ArrayList<User>();
	
	public Login() {
		System.out.println("액션본능! 사이퍼즈에 오신 것을 환영합니다.");
		System.out.println(">>로그인/회원가입/종료");
		String you = sc.next();
		
		if(you.equals("로그인")) {
			System.out.println("ID : ");
			String ID = sc.next();
			System.out.println("PW : ");
			String PW = sc.next();
			if(LoginGame(ID, PW)==true);
				//온라인
			else;
		}
		else if(you.equals("회원가입"))
			AddUser();
		else if(you.equals("종료"));
			//종료
		else
			System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
	}
	
	private boolean LoginGame(String ID, String PW) {
		int num = 0;
		boolean searchID = false;
		while(searchID==false&&num<=Users.size()){
			if(ID.equals(Users.get(num).GetID()))
				searchID=true;
			else num++;
		}
		if(searchID==true)
			if(PW.equals(Users.get(num).GetPW()))
				return true;
			else {
				System.out.println("비밀번호가 올바르지 않습니다.");
				return false;
			}
		else {
			System.out.println("올바르지 않거나 존재하지 않는 아이디입니다.");
			return false;
		}
	}
	
	private void AddUser() {
		System.out.print("사용하고자하는 아이디를 입력해주세요. : ");
		String ID = sc.next();
		int num = 0;
		boolean searchID = true;
		while(searchID==true&&num<=Users.size()){
			if(ID.equals(Users.get(num).GetID()))
				searchID=false;
			else num++;
		}
		if(searchID==false) {
			System.out.print("사용가능한 아이디입니다.\n비밀번호를 입력해주세요. : ");
			String PW = sc.next();
			Users.add(new User(ID, PW));
		}
		else {
			System.out.println("이미 존재하는 아이디입니다.");
			AddUser();
		}
	}
}
