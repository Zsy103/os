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
	public MyJPopupMenu(int type, Dentry currentDentry, GridJPanel gridJPanel) {
		openItem=new JMenuItem("��");
		deleteItem=new JMenuItem("ɾ��");
		newItem=new JMenuItem("�½�");
		renameItem=new JMenuItem("������");
		// TODO �Զ����ɵĹ��캯�����
		if (type==0) { //�ļ��˵�
			openItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						FileJFrame fileJFrame=new FileJFrame();
					}
				}
			});
			renameItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//rename();
					}
				}
			});
			deleteItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//delete();
					}
				}
			});
			add(openItem);
			add(deleteItem);
			add(renameItem);
		}
		else if (type==1) {//Ŀ¼�˵�
			renameItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//rename();
						StringBuffer dentryName=new StringBuffer(JOptionPane.showInputDialog("������Ŀ¼����"));
						currentDentry.renameDentryName(dentryName);
						gridJPanel.showFile(currentDentry.getParentDentry());
					}
				}
			});
			deleteItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//delete();
						currentDentry.dentryDelete();
						gridJPanel.showFile(currentDentry.getParentDentry());
					}
				}
			});
			openItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//open();
					}
				}
			});
			add(openItem);
			add(deleteItem);
			add(renameItem);
		}
		else if (type==2){//�½��˵�
			add(newItem);
			newItem.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e)
				{
					if (e.getButton()==e.BUTTON1) {
						//new();
						String dentryName=new String(JOptionPane.showInputDialog("������Ŀ¼����"));
						currentDentry.dentryCreate(dentryName, null, currentDentry);
						gridJPanel.showFile(currentDentry);
					}
				}
			});
		}
	}
}
