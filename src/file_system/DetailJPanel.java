package file_system;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class DetailJPanel extends JPanel{
	JTextField addressField;
	GridJPanel gridJPanel;
	public DetailJPanel() {
		// TODO �Զ����ɵĹ��캯�����
		super();
		initialAll();
		
	}
	void initialAll() {
		setLayout(null);
		setBounds(0, 0, 700, 700);
		initialGridJPanel();
		initialJTextField();
		setVisible(true);
	}
	private void initialJTextField() {
		// TODO �Զ����ɵķ������
		addressField=new JTextField();
		addressField.setBounds(50, 20, 620, 40);
		addressField.setText("��ַ��");
		addressField.setFont(new Font(null, Font.PLAIN, 20));
		add(addressField);
		
	}
	void initialGridJPanel() {
		
		gridJPanel=new GridJPanel();
		JScrollPane jsp = new JScrollPane(gridJPanel);
        jsp.setBounds(50, 65, 620, 600);
        jsp.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.repaint();
		add(jsp);
		
	}

}
