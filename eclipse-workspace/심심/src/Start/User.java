package Start;

public class User {
	private String ID;
	private String PW;
	private String NickName = "";
	private int Level = 1;
	
	public User(String ID, String PW) {
		SetID(ID);
		SetPW(PW);
	}
	
	public void SetID(String ID) {
		this.ID = ID;
	}
	public String GetID() {
		return ID;
	}
	public void SetPW(String PW) {
		this.PW = PW;
	}
	public String GetPW() {
		return PW;
	}
	public void SetName(String NickName) {
		this.NickName = NickName;
	}
	public String GetName() {
		return NickName;
	}
	public void Levelup() {
		Level++;
	}
	public int GetLevel() {
		return Level;
	}
}
