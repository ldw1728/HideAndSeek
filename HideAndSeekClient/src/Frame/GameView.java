package Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

import Connect.Connection;
import Object.CreateItems;
import Object.CreateUserImg;
import Object.HideTime;
import Object.Map;
import Object.User;
import Object.Users;
import Player.Action;
import Player.FootSound;
import Player.Hide;
import Player.Interation;
import Player.KeyEvent;
import Player.Move;
import Player.Player;
import Player.Slash;

public class GameView extends JFrame implements FrameView {

	private Connection conn;
	private Player player;
	private Users users;
	private Thread th;
	private KeyEvent ke;
	private Image buffImg, mapImg, key;
	private Graphics gr, gg;
	private CreateUserImg cui;
	private Map map;
	private int comm = 0;
	public static boolean gameOver = false;
	private AudioInputStream ais;
	private Clip c;

	public GameView(Connection conn, Users users, Player player) {
		try {
			ais = AudioSystem.getAudioInputStream(new File("sound/footSound.wav"));
			try {
				c = AudioSystem.getClip();
				c.open(ais);

			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		startBackgroundMusic();
		cui = new CreateUserImg();
		key = Toolkit.getDefaultToolkit().getImage("Img/key.png");
		this.conn = conn;
		this.conn.setView(this);
		this.users = conn.getUsers();
		this.player = player;

		conn.initUsersXY(users);
		player.initPlayerXY(users);
		player.myRole();

		player.initImg(cui);
		setUsersImg();

		map = new Map(player.getPX(), player.getPY());
		Action slash = new Slash(player, conn);
		Action move = new Move(player, map, conn);
		Action inter = new Interation(player);
		Action hide = new Hide(player, conn, map.getCmo());
		Action footSound = new FootSound(player, users,conn);
		((Interation) inter).setItems(new CreateItems().getItems());
		player.addActions(move);
		player.addActions(inter);
		player.addActions(slash);
		player.addActions(hide);
		player.addActions(footSound);

		ke = new KeyEvent(player, conn);
		create_Frame();
		start_View();
	}

	public void setUsersImg() {
		//CreateUserImg cui = new CreateUserImg();

		for (Object o : users.getUsers()) {
			User u = (User) o;
			if (player.getNname().equals(u.getnName())) {
				continue;
			}
			if (u.isRole()) {
				u.setMoveImg(cui.getSkMoveImg());
				u.setStopImg(cui.getSkStopImg());
				u.setSlashImg(cui.getSkSlashImg());
				u.createArea();
			} else {
				u.setMoveImg(cui.getMoveImg());
				u.setStopImg(cui.getStopImg());

			}
		}
	}

	public void create_Frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setBounds(150, 100, 800, 600);
		setTitle("gameFrame");
		this.addKeyListener(ke);
		setResizable(false);
		setVisible(true);

	}

	public void start_View() {
		th = new Thread(new Runnable() {
			@Override
			public void run() {

				while (true) {
					try {

						player.action();
						repaint();
						Thread.sleep(60);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		th.start();
	}

	@Override
	public void paint(Graphics g) {

		buffImg = createImage(1600, 900);

		gr = buffImg.getGraphics();

		update(g);

	}

	@Override
	public void update(Graphics g) {
		drawImg();

		if (player.role)
			gr.drawImage(player.getBlackView(), player.getPX() - 400, player.getPY() - 300, this);
		if (gameOver)
			drawGameOver(gr);
		g.drawImage(buffImg, map.getX(), map.getY(), this);
		drawKey(conn.getKey(), g);

	}

	public void drawImg() {

		gr.drawImage(map.getImg(), 0, 0, this);
		if (map.getCmo().getED() != null) {
			gr.drawImage(map.getCmo().getED().getImg(), map.getCmo().getED().getX(), map.getCmo().getED().getY(), this);
		}
		drawUsers();
		if (!player.escape) {
			if (!player.isHidding()) {
				gr.drawImage(player.getImg(), player.getPX(), player.getPY(), this);
			}
		}

	}

	public void drawUsers() {
		for (Object o : users.getUsers()) {
			User u = (User) o;
			if (player.getNname().equals(u.getnName())) {
				continue;
			}
			if(!u.escape) {
			if (!u.isHiding())
				gr.drawImage(u.getImg(), u.getX(), u.getY(), this);
			}
		}
	}

	public void drawGameOver(Graphics g) {
		g.setFont(new Font("궁서", Font.BOLD, 30));
		g.setColor(Color.RED);

		if (comm == 10) {

			g.drawString("도망자 win", player.getPX(), player.getPY());
		} else if (comm == 20) {

			g.drawString("살인마 win", player.getPX(), player.getPY());
		}
	}

	public void drawKey(int n, Graphics g) {
		int x = 750;
		int y = 500;
		Graphics gr;
		if (conn.getKey() != 0) {
			for (int i = 0; i < n; i++) {
				Image img = createImage(40, 64);
				gr = img.getGraphics();
				gr.drawImage(key, 0, 0, this);
				g.drawImage(img, x, y, this);
				x -= 50;
			}
		}
	}

	public void startBackgroundMusic() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("sound/bgm2.wav"));
			try {
				Clip c = AudioSystem.getClip();
				c.open(ais);
				c.loop(c.LOOP_CONTINUOUSLY);

				c.start();

				if (gameOver)
					c.stop();

			} catch (LineUnavailableException e) {
				
				e.printStackTrace();
			}

		} catch (UnsupportedAudioFileException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void view(int comm) {
		users = conn.getUsers();
		
		if (comm == 10) {
			this.comm = comm;
			gameOver = true;
		}
		if (comm == 20) {
			this.comm = comm;
			gameOver = true;
		}
		if (comm == 5) {
			System.out.println("문이 생성되었습니다\n");
			map.getCmo().createED();
		}
		if (comm == 7) {
			player.role = conn.role;
			player.initImg(cui);
			setUsersImg();
		}
		if (comm == 9) {
			new HideTime(users, conn.hiddingName).start();
		}
		if(comm == 21) {c.loop(c.LOOP_CONTINUOUSLY); c.start();}
		if(comm ==22) { c.stop();}
			
		

	}
	
	

}
