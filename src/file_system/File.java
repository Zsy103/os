package file_system;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class File {//�ļ���
	private StringBuffer fileName;//�ļ�����
	private StringBuffer fullPath;//�ļ�����Ŀ¼�����Ŀ¼��ֻҪ��Ŀ¼
	private StringBuffer userName;//�û���                  
	private String modifyTime;//�ļ��޸�ʱ��                 

	Inode fileInode;//�ļ�����
	private int fileSize;//�ļ���С
	private boolean fileFlag;//��־λ
	Inode inode = new Inode();
	DataBlock datablock = new DataBlock();

	public File(StringBuffer fileName,StringBuffer fullPath,StringBuffer userName) {
		this.fileName = fileName;
		this.fullPath = fullPath; 
		this.userName = userName;

		fileSize = 0;
		fileInode = SuperBlock.InodeAllocation();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        modifyTime = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
        fileFlag = true;
		if(fileInode == null) {
			//����
		}
		// TODO �Զ����ɵĹ��캯�����
	}
	void rename(StringBuffer fileName) {//�޸��ļ���
		StringBuffer sb = new StringBuffer();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		sb.append(scanner.next());
		this.fileName = fileName;
		
	}
	//û�еط�������setTime
	private void setTime() {//�����޸�ʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        modifyTime = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
        
	}
	private void deleteFlag() {
		fileSize = 0;
		fileName = null;
		fullPath = null;
		userName = null;
		modifyTime = null;
		fileSize = 0;
		
		// TODO �Զ����ɵķ������
		
	}
	void fileDelete() {
		fileFlag = false;
		deleteFlag();
		inode.delete();
		
	}
	//û�еط�������write
	void write(String fileContent){
		inode.write(fileContent);
		
	}
	StringBuffer getContent() {
		if(inode != null) {
			return inode.getFileContent;
		}
		return null;
	}
	StringBuffer getFileName() {
		return fileName;
	}
	StringBuffer getFullpath() {
		return fullPath;
	}
	StringBuffer getUserName() {
		return userName;
	}
	String getModifyTime() {
		return modifyTime;
	}
	int getFileSize() {
		return fileSize;
	}
	boolean getFileFlag() {
		return fileFlag;
	}
}
