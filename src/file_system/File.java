package file_system;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class File {//文件类
	StringBuffer fileName;//文件名字
	StringBuffer fileContent;//文件内容

	StringBuffer fullPath;//文件所在目录，相对目录，只要父目录
	StringBuffer userName;//用户名                  
	String modifyTime;//文件修改时间                 

  Inode fileInode;//文件索引
	int fileSize;//文件大小
	boolean fileFlag;//标志位
	Inode inode = new Inode();
	DataBlock datablock = new DataBlock();

	public File(StringBuffer fileName,StringBuffer fullPath,StringBuffer userName) {
		this.fileName = fileName;
		this.fullPath = fullPath; 
		this.userName = userName;

		fileSize = 0;
		fileContent = null;
		fileInode = SuperBlock.InodeAllocation();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        modifyTime = df.format(new Date());// new Date()为获取当前系统时间
        fileFlag = true;
		if(fileInode == null) {
			//报错
		}
		// TODO 自动生成的构造函数存根
	}
	void rename(StringBuffer fileName) {//修改文件名
		StringBuffer sb = new StringBuffer();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		sb.append(scanner.next());
		this.fileName = fileName;
		
	}
	//没有地方调用了setTime
	private void setTime() {//设置修改时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        modifyTime = df.format(new Date());// new Date()为获取当前系统时间
        
	}
	private void deleteFlag() {
		fileSize = 0;
		fileContent = null;
		fileName = null;
		fullPath = null;
		userName = null;
		modifyTime = null;
		fileSize = 0;
		
		// TODO 自动生成的方法存根
		
	}
	void fileDelete() {
		fileFlag = false;
		deleteFlag();
		inode.delete();
		
	}
	//没有地方调用了write
	void write(String fileContent){
		inode.write(fileContent);
		
	}
}
