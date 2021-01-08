package file_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class GridJPanel extends JPanel{
	//GridLayout gridLayout=new GridLayout(6, 6, 20, 20);
	int fileNum;
	int dentryNum;
	MyJPopupMenu jPopupMenu;
	JTextField addressField;
	public GridJPanel(Dentry currentDentry, JTextField addressField) {
		// TODO 自动生成的构造函数存根
		super();
		setBackground(Color.white);
		setPreferredSize(new Dimension(600,600));
		setLayout(null);
		fileNum=0;
		dentryNum=0;
		this.addressField=addressField;
		showFile(currentDentry);
	}
	void setAddressTest(Dentry currentDentry){
		addressField.setText(currentDentry.getFullPath().toString());
	}
	void showFile(Dentry currentDentry){
		removeAll();
		jPopupMenu=new MyJPopupMenu(2,currentDentry,this);
		addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e)
			{
				if(e.isPopupTrigger()){
					jPopupMenu.show(e.getComponent(), e.getX(),e.getY());
				}
			}
		});
		int height=600;
		setAddressTest(currentDentry);
		dentryNum=currentDentry.getChildDentryNum();
		fileNum=currentDentry.getFileNum();
		int num=dentryNum+fileNum;
		height=Math.max(height,(1+num/6)*100);
		setPreferredSize(new Dimension(600,height));
		int j=0;
		for (int i=0;i<num;i++) {
			if (i<dentryNum) {
				while (!currentDentry.getChildDentry(j).getFlag())
					j++;
				add(new dentryButton(10+(i%6)*100,10+(i/6)*100,currentDentry.getChildDentry(j),this));
				j++;
			}
			else {
				add(new fileButton(10+(i%6)*100,10+(i/6)*100));
			}
		}
		repaint();
	}
}
