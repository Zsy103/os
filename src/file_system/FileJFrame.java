package file_system;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

class FileJFrame extends JFrame{
	static int frameHeight=600;
	static int frameWidth=800;
	JTextPane displayPane;
	String text="hello world";
	public FileJFrame() {
		// TODO 自动生成的构造函数存根
		super();
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(frameWidth,frameHeight);
		setLocationRelativeTo(null);
		setLayout(null);
		displayPane=new JTextPane();
		displayPane.setText(text);
		displayPane.setSize(frameWidth, frameHeight);
		displayPane.setFont(new Font(null, Font.PLAIN, 20));
		add(displayPane);
		setVisible(true);
		repaint();
		addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e){
	        	  int n=JOptionPane.showConfirmDialog(null, "是否保存文件修改结果？", "",JOptionPane.YES_NO_OPTION);
	        	  if (n==0) {
	        		  //save
	        	  }
	          }
	      });
	}

}
