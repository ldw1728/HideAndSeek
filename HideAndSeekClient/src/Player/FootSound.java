package Player;

import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Connect.Connection;
import Object.User;
import Object.Users;

public class FootSound implements Action {
	private Player p;
	private Users users;
	//private AudioInputStream ais;
	//private Clip c;
	private Connection conn;

	public FootSound(Player p, Users users, Connection conn) {
		this.p = p;
		this.users = users;
		this.conn = conn;
		
	}

	@Override
	public void action() {
		
		if (!p.role) {
			for (Object o : users.getUsers()) {
				User u = (User) o;
				if (u.isRole()) {
					if (isSk(u)) {
						if (p.isMoving()) {
							conn.send_Message(" ", 21);
						} 
						else conn.send_Message(" ", 22);
					}else conn.send_Message(" ", 22);
				}

			}
		}

	}

	public boolean isSk(User u) {
		boolean i = false;
		
		Rectangle rect = new Rectangle(u.getX() + 8 - 200, u.getY() + 35 - 200, 400, 400);

		if (p.getArea().intersects(rect))
			i = true;

		return i;
	}

}
