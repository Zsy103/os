package file_system;

public class MyUser {
	private String userName;
	private String password;
	private boolean userFlag;
	public MyUser(String userName,String password) {
		this.userName=userName;
		this.password=password;
		//System.out.println(userName+"@");
		userFlag=true;
		// TODO �Զ����ɵĹ��캯�����
		
	}
	int checkUser(String userName,String password) {
		//System.out.println(userName+"!");
		if (this.userName.equals(userName)&&this.password.equals(password))
			return 0;
		else if (this.userName.equals(userName))
			return 1;
		else {
			return 2;
		}
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
