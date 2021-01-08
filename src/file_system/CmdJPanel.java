package file_system;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class CmdJPanel extends JPanel{
	JTextField orderField;
	JTextPane displayPane;
	JButton confirmButton;
	int width=560;
	int height=720;
	int x=1280-width;
	int y=0;
	public CmdJPanel() {
		// TODO �Զ����ɵĹ��캯�����
		super();
		initialAll();
	}
	private void initialAll() {
		// TODO �Զ����ɵķ������
		setVisible(false);
		setBounds(x, y, width, height);
		setLayout(null);
		//setBackground(new Color(0));
		initialDisplayPane();
		initialOrderField();
		//initialConfirmButton();
		setVisible(true);
		repaint();
	}
	
	private void initialConfirmButton() {
		// TODO �Զ����ɵķ������
		confirmButton=new JButton();
		add(confirmButton);
		confirmButton.setBounds(460, 600,60, 40);
		orderField.setFont(new Font(null, Font.PLAIN, 20));
		confirmButton.setText("ȷ��");
		confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String nowString=displayPane.getText()+orderField.getText()+"\n";
            	displayPane.setText(nowString);
            	orderField.setText("���������");
            	orderField.setForeground(Color.GRAY);
            }
        });
	}
	private void initialDisplayPane() {
		// TODO �Զ����ɵķ������
		displayPane=new JTextPane();
		//displayPane.setBackground(new Color(0));
		displayPane.setEditable(false);
		displayPane.setFont(new Font(null, Font.PLAIN, 20));
		//displayPane.setBounds(20, 20, 500, 570);
		JScrollPane jsp = new JScrollPane(displayPane);
        //���þ��δ�С.��������Ϊ(�������ϽǺ�����x,�������Ͻ�������y�����γ��ȣ����ο��)
        jsp.setBounds(20, 20, 500, 585);
        //Ĭ�ϵ������ǳ����ı���Ż���ʾ�����������������ù�����һֱ��ʾ
        jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		displayPane.setText("hello\nworld!\n");
		add(jsp);
	}
	private void initialOrderField() {
		// TODO �Զ����ɵķ������
		orderField=new JTextField();
		orderField.setBounds(20, 620, 500, 40);
		orderField.setFont(new Font(null, Font.PLAIN, 20));
		orderField.addFocusListener(new JTextFieldHintListener(orderField,"���������"));
		orderField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO �Զ����ɵķ������
				if ((char)e.getKeyChar()==KeyEvent.VK_ENTER) {
					String nowString=displayPane.getText()+orderField.getText()+"\n";
	            	displayPane.setText(nowString);
	            	orderField.setText("���������");
	            	orderField.setForeground(Color.GRAY);
				}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO �Զ����ɵķ������
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO �Զ����ɵķ������
				if (orderField.getText().contains("���������")) {
					orderField.setText(null);
					orderField.setForeground(Color.BLACK);
				}
			}
		});
		add(orderField);
	}

}

class JTextFieldHintListener implements FocusListener{
	
	private String hintText;
	private JTextField textField;
	
	public JTextFieldHintListener(JTextField TextField,String hintText) {
		this.textField = TextField;
		this.hintText = hintText;
		TextField.setText(hintText);  //Ĭ��ֱ����ʾ
		TextField.setForeground(Color.GRAY);
	}
 
	@Override
	public void focusGained(FocusEvent e) {
		//��ȡ����ʱ�������ʾ����
		String temp = textField.getText();
		if(temp.equals(hintText)) {
			textField.setText("");
			textField.setForeground(Color.BLACK);
		}
	}
 
	@Override
	public void focusLost(FocusEvent e) {
		//ʧȥ����ʱ��û���������ݣ���ʾ��ʾ����
		String temp = textField.getText();
		if(temp.equals("")) {
			textField.setForeground(Color.GRAY);
			textField.setText(hintText);
		}
	}
 
}
