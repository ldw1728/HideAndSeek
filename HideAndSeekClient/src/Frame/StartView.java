package Frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Connect.Connection;

public class StartView extends JFrame {

	private JTextField tf_ID;

	public StartView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 800, 600);
		setTitle("ID입력창");

		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("아이디를 입력해주세요");
		lblId.setBounds(300, 200, 200, 50);
		contentPane.add(lblId);

		tf_ID = new JTextField();
		tf_ID.setBounds(250, 300, 230, 50);
		contentPane.add(tf_ID);

		JButton btn = new JButton("접       속");
		btn.setBounds(500, 300, 100, 50);
		contentPane.add(btn);

		Action action = new Action();
		btn.addActionListener(action);

		setVisible(true);
	}

	class Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String _id = tf_ID.getText().trim();
			ReadyView readyView = new ReadyView(tf_ID.getText().toString());
			setVisible(false);
		}
	}

}
