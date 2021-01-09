package file_system;

import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileSystem {
	private static Dentry currentDentry;
	private static Dentry rootDentry;
	private static MyUser [] users=new MyUser[100];
	private static String currentUser;
	private static MyJFrame myJFrame;
	private static String currentPath;
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		users[0]=new MyUser("admin", "123");
		login();
		
	}
	static void setCurrentDentry(Dentry currentDentry) {
		FileSystem.currentDentry=currentDentry;
	}
	static Dentry getCurrentDentry() {
		return currentDentry;
	}
	static void cdOrder(String currentPath) {
		//currentPath=myJFrame.getCurrentPath().toString();
		currentDentry=rootDentry;
		boolean flag=true;
		while (!currentPath.equals(currentDentry.getFullPath().toString())){
			int maxChildDentryNum=currentDentry.getMaxChildDentryNum();
			for (int i=0;i<maxChildDentryNum;i++) {
				Dentry tempDentry=currentDentry.getChildDentry(i);
				if (tempDentry!=null&&tempDentry.getFlag()&&currentPath.indexOf(tempDentry.getFullPath().toString())!=-1) {
					currentDentry=tempDentry;
					flag=false;
					break;
				}
			}
			if (flag)
				break;
		}
		if (flag){
			if (currentPath.equals("root")) {
				JOptionPane.showMessageDialog(null, "û��Ȩ�޷���ϵͳ��Ŀ¼", "Error", JOptionPane.ERROR_MESSAGE); 
			}
			else {
				JOptionPane.showMessageDialog(null, "����ĵ�ַ��Ϣ", "Error", JOptionPane.ERROR_MESSAGE); 
			}
		}
		else
			myJFrame.repaintDetailPanel();
	}
	static void initPanel(String userName) {
		if (checkAdmin(userName)) {
			rootDentry=new Dentry(userName);
			currentDentry=rootDentry;
			myJFrame=new MyJFrame();
		}
		else {
			rootDentry=getDentry(userName);
			myJFrame=new MyJFrame();
		}
		//rootDentry=new Dentry();
		//currentDentry=rootDentry;
		//myJFrame=new MyJFrame();
	}
	private static Dentry getDentry(String userName) {
		// TODO �Զ����ɵķ������
		return rootDentry.getChildDentry(userName);
	}
	public static String checkUser(String userName, String password) {
		for (int i=0;i<100;i++) {
			if (users[i]!=null&&users[i].getFlag()&&users[i].checkUser(userName, password)) {
				return users[i].getUserName();
			}
		}
		return null;
		// TODO �Զ����ɵķ������
		
	}
	public static boolean checkAdmin(String userName) {
		return users[0].getUserName().equals(userName);
		
	}
	public static boolean checkUserName(String userName) {
		// TODO �Զ����ɵķ������
		for (int i=0;i<100;i++) {
			if (users[i]!=null&&users[i].getFlag()&&users[i].getUserName().equals(userName)) {
				return false;
			}
		}
		return true;
	}
	public static void createUser(String userName, String password) {
		// TODO �Զ����ɵķ������
		for (int i=0;i<100;i++) {
			if (users[i]==null||!users[i].getFlag()) {
				users[i]=new MyUser(userName, password);
				rootDentry.dentryCreate(userName, userName, rootDentry);
				myJFrame.repaintDetailPanel();
				break;
			}
		}
		
	}
	public static MyJFrame getJFrame() {
		// TODO �Զ����ɵķ������
		return myJFrame;
	}
	public static void login() {
		LoginJFrame loginJFrame=new LoginJFrame();
	}
}
