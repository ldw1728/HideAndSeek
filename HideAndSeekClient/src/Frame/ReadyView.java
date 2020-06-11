package Frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connect.Connection;
import Object.User;
import Object.Users;
import Player.Player;

public class ReadyView extends JFrame implements FrameView {

	private Connection conn;
	private Users users;
	private JPanel contentPane;
	private JButton b;
	private User me;

	public ReadyView(String nName) {

		conn = new Connection(nName);
		conn.setView(this);
		users = conn.getUsers();
		me = new User(nName);
		conn.send_Message(nName, 1);
		init();

	}

	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 100, 400, 400);
		setTitle("대기화면");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		b = new JButton("시작");
		b.setBackground(Color.LIGHT_GRAY);
		b.setBounds(20, 200, 100, 100);
		b.addActionListener(new Action());
		print_Component();
		setVisible(true);
	}

	@Override
	public void view(int comm) {
		users = conn.getUsers();
		if (contentPane != null)
			contentPane.removeAll();
		print_Component();
		contentPane.repaint();

	}

	public void print_Component() {
		Vector vUsers = users.getUsers();
		for (int i = 0; i < users.getSize(); i++) {
			User u = (User) vUsers.elementAt(i);
			JLabel jl = new JLabel(u.getnName());
			jl.setBounds(20, 30 * (i + 1), 100, 50);
			if (jl != null)
				contentPane.add(jl);
		}
		if (b != null)
			contentPane.add(b);
	}

	public void StartGame() {
		GameView gv = new GameView(conn, users, new Player(me.getnName(), conn));
		setVisible(false);

	}

	class Action implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			StartGame();
		}
	}
}
