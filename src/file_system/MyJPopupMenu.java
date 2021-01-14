package file_system;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class MyJPopupMenu extends JPopupMenu{
	JMenuItem openItem;
	JMenuItem deleteItem;
	JMenuItem newItem;
	JMenuItem renameItem;
	JMenuItem newFileItem;
	JMenuItem newUserItem;
	JMenuItem logoutItem;
	JMenuItem detailItem;
	public MyJPopupMenu(int type, Dentry currentDentry, GridJPanel gridJPanel) {
		openItem=new JMenuItem("打开");
		deleteItem=new JMenuItem("删除");
		newItem=new JMenuItem("新建目录");
		newFileItem=new JMenuItem("新建文件");
		renameItem=new JMenuItem("重命名");
		newUserItem=new JMenuItem("新建用户");
		logoutItem=new JMenuItem("注销");
		detailItem=new JMenuItem("详细信息");
		// TODO 自动生成的构造函数存根
		if (type==1) {//目录按钮的右键菜单
			if (!currentDentry.getParentDentry().getUserName().equals(currentDentry.getUserName())) {
				deleteItem.setText("删除用户");
			}
			renameItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//重命名目录
						String dentryName=JOptionPane.showInputDialog("请输入目录名：");
						currentDentry.renameDentryName(dentryName);
						gridJPanel.showFile();
					}
				}
			});
			deleteItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//删除目录
						currentDentry.dentryDelete();
						gridJPanel.showFile();
					}
				}
			});
			openItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//i进入目录
						FileSystem.setCurrentDentry(currentDentry);
						gridJPanel.showFile();
					}
				}
			});
			detailItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//显示目录详细信息
						DetailJFrame detailJFrame=new DetailJFrame(currentDentry);
					}
				}
			});
			add(openItem);
			add(deleteItem);
			add(renameItem);
			add(detailItem);
		}
		else if (type==2){//空白处的右键菜单
			add(newItem);
			newItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//新建目录
						String dentryName=JOptionPane.showInputDialog("请输入目录名：");
						if (dentryName!=null) {
							if (currentDentry.dentryCreate(dentryName, currentDentry.getUserName(), currentDentry)) {
								gridJPanel.showFile();
							}
							
						}
					}
				}
			});
			add(newFileItem);
			newFileItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e){
					if (e.getButton()==e.BUTTON1) {
						//新建文件
						String fileName=JOptionPane.showInputDialog("请输入文件名：");
						if (fileName!=null) {
							currentDentry.fileCreate(fileName);
							gridJPanel.showFile();
						}
					}
				}
			});
			if (currentDentry.getDentryName().equals("root")&&FileSystem.checkAdmin(currentDentry.getUserName().toString())){
				add(newUserItem);
				newUserItem.addMouseListener(new MouseAdapter() {
					public void mouseReleased(MouseEvent e){
						if (e.getButton()==e.BUTTON1) {
							//新建用户
							LogonJFrame logonJFrame=new LogonJFrame();
						}
					}
				});
			}
			add(logoutItem);
			logoutItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e){
					if (e.getButton()==e.BUTTON1) {
						//注销
						FileSystem.login();
						FileSystem.getJFrame().dispose();
					}
				}
			});
		}
	}
	public MyJPopupMenu(MyFile file,GridJPanel gridJPanel,Dentry currentDentry) { //文件按钮的右键菜单
		// TODO 自动生成的构造函数存根
		openItem=new JMenuItem("打开");
		deleteItem=new JMenuItem("删除");
		renameItem=new JMenuItem("重命名");
		detailItem=new JMenuItem("详细信息");
		openItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if (e.getButton()==e.BUTTON1) {
					//打开文件
					FileJFrame fileJFrame=new FileJFrame(file);
				}
			}
		});
		renameItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if (e.getButton()==e.BUTTON1) {
					//重命名文件
					String fileName=JOptionPane.showInputDialog("请输入文件名：");
					if (fileName!=null) {
						file.rename(fileName);
						gridJPanel.showFile();
					}
				}
			}
		});
		deleteItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if (e.getButton()==e.BUTTON1) {
					//删除文件
					currentDentry.fileDelete(file.getFileName());
					gridJPanel.showFile();
				}
			}
		});
		detailItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if (e.getButton()==e.BUTTON1) {
					//显示文件详细信息
					DetailJFrame detailJFrame=new DetailJFrame(file);
				}
			}
		});
		add(openItem);
		add(deleteItem);
		add(renameItem);
		add(detailItem);
	}
}
