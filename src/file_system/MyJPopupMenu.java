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
		openItem=new JMenuItem("��");
		deleteItem=new JMenuItem("ɾ��");
		newItem=new JMenuItem("�½�Ŀ¼");
		newFileItem=new JMenuItem("�½��ļ�");
		renameItem=new JMenuItem("������");
		newUserItem=new JMenuItem("�½��û�");
		logoutItem=new JMenuItem("ע��");
		detailItem=new JMenuItem("��ϸ��Ϣ");
		// TODO �Զ����ɵĹ��캯�����
		if (type==1) {//Ŀ¼��ť���Ҽ��˵�
			if (!currentDentry.getParentDentry().getUserName().equals(currentDentry.getUserName())) {
				deleteItem.setText("ɾ���û�");
			}
			renameItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//������Ŀ¼
						String dentryName=JOptionPane.showInputDialog("������Ŀ¼����");
						currentDentry.renameDentryName(dentryName);
						gridJPanel.showFile();
					}
				}
			});
			deleteItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//ɾ��Ŀ¼
						currentDentry.dentryDelete();
						gridJPanel.showFile();
					}
				}
			});
			openItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//i����Ŀ¼
						FileSystem.setCurrentDentry(currentDentry);
						gridJPanel.showFile();
					}
				}
			});
			detailItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//��ʾĿ¼��ϸ��Ϣ
						DetailJFrame detailJFrame=new DetailJFrame(currentDentry);
					}
				}
			});
			add(openItem);
			add(deleteItem);
			add(renameItem);
			add(detailItem);
		}
		else if (type==2){//�հ״����Ҽ��˵�
			add(newItem);
			newItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//�½�Ŀ¼
						String dentryName=JOptionPane.showInputDialog("������Ŀ¼����");
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
						//�½��ļ�
						String fileName=JOptionPane.showInputDialog("�������ļ�����");
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
							//�½��û�
							LogonJFrame logonJFrame=new LogonJFrame();
						}
					}
				});
			}
			add(logoutItem);
			logoutItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e){
					if (e.getButton()==e.BUTTON1) {
						//ע��
						FileSystem.login();
						FileSystem.getJFrame().dispose();
					}
				}
			});
		}
	}
	public MyJPopupMenu(MyFile file,GridJPanel gridJPanel,Dentry currentDentry) { //�ļ���ť���Ҽ��˵�
		// TODO �Զ����ɵĹ��캯�����
		openItem=new JMenuItem("��");
		deleteItem=new JMenuItem("ɾ��");
		renameItem=new JMenuItem("������");
		detailItem=new JMenuItem("��ϸ��Ϣ");
		openItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if (e.getButton()==e.BUTTON1) {
					//���ļ�
					FileJFrame fileJFrame=new FileJFrame(file);
				}
			}
		});
		renameItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if (e.getButton()==e.BUTTON1) {
					//�������ļ�
					String fileName=JOptionPane.showInputDialog("�������ļ�����");
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
					//ɾ���ļ�
					currentDentry.fileDelete(file.getFileName());
					gridJPanel.showFile();
				}
			}
		});
		detailItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if (e.getButton()==e.BUTTON1) {
					//��ʾ�ļ���ϸ��Ϣ
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
