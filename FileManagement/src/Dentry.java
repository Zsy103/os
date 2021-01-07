import java.util.*;

public class Dentry {
	private StringBuffer dentryName;//Ŀ¼����
	private StringBuffer userName;//�������û�����
    private Dentry[] childDentry = new Dentry[20];//��Ŀ¼
	private Dentry parentDentry;//��Ŀ¼
	private boolean flag=false;//�Ƿ񱻽���
	private StringBuffer createTime;//����ʱ��
	private File[] file = new File[20];//�ļ�
	private StringBuffer fullPath;//����·��
	private int fileNum = 0;//�ļ�����
	private int childDentryNum = 0;//��Ŀ¼���� 
	
	Dentry(String dentryName,StringBuffer userName,Dentry parentDentry){//���캯�� 
		fullPath = new StringBuffer();
		createTime = new StringBuffer();
		this.dentryName = new StringBuffer();
		this.userName = new StringBuffer();
		this.dentryName.append(dentryName);
		this.userName.append(userName);
		flag = true;
		createTime.append(getDate());
		this.parentDentry = parentDentry; 
		fullPath.append(parentDentry.getFullPath());
		fullPath.append("/");
		fullPath.append(parentDentry.getDentryName());
	} 
	
	Dentry(String dentryName,String userName){//���캯��
		this.dentryName = new StringBuffer();
		createTime = new StringBuffer();
		this.userName = new StringBuffer();
		this.dentryName.append(dentryName);
		this.userName.append(userName);
		flag = true; 
		createTime.append(getDate()); 
		fullPath = new StringBuffer("FileManagement");  
	}
	
	String getDate() {//��ȡ������ʱ�� 
		String time;
		Date nowTime = new Date();
		time = String.format("%tY��%<tm��%<td��%tHʱ%tM��",nowTime,nowTime,nowTime,nowTime,nowTime);
		return time;
	}
	
	void dentryCreate(String dentryName,StringBuffer userName,Dentry parentDentry) {//������Ŀ¼
		childDentry[childDentryNum] = new Dentry(dentryName,userName,parentDentry);   
		childDentryNum++; 
	}
	
	void dentryDelete(){//ɾ��Ŀ¼
		flag = false;
	}
	
	void fileCreate(StringBuffer fileName) {//�����ļ�
		file[fileNum] = new File(fileName);
		fileNum++;
	}
	
	void fileDelete(StringBuffer fileName) {//ɾ���ļ�
		for(int i=0;i<fileNum;i++)
			if(file[i].fileName.equals(fileName)) {
				file[i].fileDelete();
				break;
			}
	}
	
	StringBuffer getDentryName() {//���Ŀ¼����
		return dentryName;
	}
	
	StringBuffer getFullPath() {//���·��
		return fullPath;
	}
	
	StringBuffer getUserName() {//����û�����
		return userName;
	}
	
    Dentry getChildDentry(int childDentryNum) {//����Ӷ���
    	return childDentry[childDentryNum];
    }
    
    Dentry getParentDentry() {//��ø�����
    	return parentDentry;
    }
    
    StringBuffer getCreateTime()//��ô���ʱ��
    {
    	return createTime;
    }
    
	File getFile(int fileNUM) {//����ļ�
		return file[fileNum];
	} 
	
	int getFileNum() {//����ļ�����
		return fileNum;
	}
	
	int getChildDentryNum() {//�����Ŀ¼����
		return childDentryNum; 
	}
}
