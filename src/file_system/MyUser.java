package file_system;

public class MyUser {
	private String userName;
	private String password;
	private boolean userFlag;
	public MyUser(String userName,String password) {
		this.userName=userName;
		this.password=password;
		userFlag=true;
		// TODO �Զ����ɵĹ��캯�����
		
	}
	boolean checkUser(String userName,String password) {
		return this.userName.equals(userName)&&this.password.equals(password);
	}
	void deleteUser() {
		userFlag=false;
	}
	public boolean getFlag() {
		// TODO �Զ����ɵķ������
		return userFlag;
	}
	public String getUserName() {
		// TODO �Զ����ɵķ������
		return userName;
	}
}
