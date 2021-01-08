package file_system;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class File {//�ļ���
	StringBuffer fileName;//�ļ�����
	StringBuffer fileContent;//�ļ�����
	StringBuffer fileList;//�ļ�����Ŀ¼�����Ŀ¼��ֻҪ��Ŀ¼
	StringBuffer fileUid;//�û�ID
	String modifyTime;//�ļ��޸�ʱ��
	Inode fileInode;//�ļ�����
	int fileSize;//�ļ���С
	boolean fileFlag;//��־λ
	Inode inode = new Inode();
	DataBlock datablock = new DataBlock();
	public File(StringBuffer fileNamea) {
		fileSize = 0;
		fileContent = null;
		fileName = fileNamea;
		fileList = null; //���ﲻӦ��Ϊ��
		fileInode = SuperBlock.InodeAllocation();
		if(fileInode == null) {
			//����
		}
		// TODO �Զ����ɵĹ��캯�����
	}
	void rename(StringBuffer f_namea) {//�޸��ļ���
		StringBuffer sb = new StringBuffer();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		sb.append(scanner.next());
		fileName = f_namea;
		
	}
	//û�еط�������setTime
	private void setTime() {//�����޸�ʱ��
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
        modifyTime = df.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ��
        
	}
	private void deleteFlag() {
		fileSize = 0;
		fileContent = null;
		fileName = null;
		fileList = null;
		fileUid = null;
		modifyTime = null;
		fileSize = 0;
		
		// TODO �Զ����ɵķ������
		
	}
	void fileDelete() {
		fileFlag = false;
		deleteFlag();
		inode.delete();
		
	}
	//û�еط�������write  hhh
	void write(String f_contenta){
		inode.write(f_contenta);
		
	}
}
