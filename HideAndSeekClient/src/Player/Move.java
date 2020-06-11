package Player;

import java.awt.Rectangle;
import java.util.ArrayList;

import Connect.Connection;
import Object.House1;
import Object.House2;
import Object.Map;
import Object.MapObject;
import Object.User;
import Object.Users;

public class Move implements Action {

	private int x, y;
	private int mapX, mapY;
	private Player p;
	private Users users;
	private Map map;
	private boolean[] isKeyPressed;
	private Connection conn;

	public Move(Player p, Map map, Connection conn) {
		this.conn = conn;
		this.p = p;
		this.map = map;
		this.users = conn.getUsers();
		mapX = map.getX();
		mapY = map.getY();
		x = p.getPX();
		y = p.getPY();
		isKeyPressed = p.getIKP();
	}

	public void up() {
		if (p.role) {
			y -= 6;
			mapY += 6;
		} else {
			y -= 5;
			mapY += 5;
		}

	}

	public void down() {
		if (p.role) {
			y += 6;
			mapY -= 6;
		} else {
			y += 5;
			mapY -= 5;
		}
	}

	public void left() {
		if (p.role) {
			mapX += 6;
			x -= 6;
		} else {
			mapX += 5;
			x -= 5;
		}

	}

	public void right() {
		if (p.role) {
			mapX -= 6;
			x += 6;
		} else {
			mapX -= 5;
			x += 5;
		}
	}

	public boolean[] getIKP() {
		return this.isKeyPressed;
	}

	@Override
	public void action() {
		isIntersects();

		if (isKeyPressed[37]) {
			if (!(p.getPX() <= 5)) {
				left();
				map.setX(this.mapX);
				p.setPX(this.x);
				p.setPlayerWay(1);
				conn.send_Message(p.getNname() + " " + p.getPX() + "," + p.getPY(), 37);
			}

		} else if (isKeyPressed[38]) {
			if (!(p.getPY() <= 5)) {
				up();
				map.setY(this.mapY);
				p.setPY(this.y);
				p.setPlayerWay(3);
				conn.send_Message(p.getNname() + " " + p.getPX() + "," + p.getPY(), 37);
			}
		} else if (isKeyPressed[39]) {
			if (!(p.getArea().x + p.getArea().getWidth() >= 1580)) {
				right();
				map.setX(this.mapX);
				p.setPX(this.x);
				p.setPlayerWay(2);
				conn.send_Message(p.getNname() + " " + p.getPX() + "," + p.getPY(), 37);
			}
		} else if (isKeyPressed[40]) {
			if (!(p.getArea().y + p.getArea().getHeight() >= 880)) {
				down();
				map.setY(this.mapY);
				p.setPY(this.y);
				p.setPlayerWay(4);
				conn.send_Message(p.getNname() + " " + p.getPX() + "," + p.getPY(), 37);
			}
		}
	}

	public void isIntersects() {
		Rectangle pArea = p.getArea();
		for (Object o : users.getUsers()) {
			User u = (User) o;
			if (u.getnName().equals(p.getNname()))
				continue;

			if (pArea.intersects(u.getArea())) {
				setFalseIKP(p.getPlayerWay());
			}
		}

		for (ArrayList<MapObject> t : map.getObject()) {
			for (MapObject m : t) {
				if (p.getArea().intersects(m.getArea()))
					setFalseIKP(p.getPlayerWay());
			}
		}
		House1 h1 = map.getCmo().getH1();
		House2 h2 = map.getCmo().getH2();
		for (Rectangle r : h1.getHouseObj()) {
			if (p.getArea().intersects(r))
				setFalseIKP(p.getPlayerWay());
		}
		for (Rectangle r : h2.getHouseObj()) {
			if (p.getArea().intersects(r))
				setFalseIKP(p.getPlayerWay());
		}
		if (map.getCmo().getED() != null) {
			if (p.getArea().intersects(map.getCmo().getED().getArea())) {
				for (Object o : users.getUsers()) {
					User u = (User) o;
					if (u.getnName().equals(p.getNname())) {
						if(!u.escape) {
						if (!u.isRole()) {
							u.escape = true;
							p.escape = true;
							conn.send_Message(p.getNname(), 6);
							}
						}
					}
				}
			}
		}

	}

	public void setFalseIKP(int way) {
		if (way == 1 && isKeyPressed[37] == true) {
			isKeyPressed[37] = false;
		} else if (way == 2 && isKeyPressed[39] == true) {
			isKeyPressed[39] = false;
		}

		else if (way == 3 && isKeyPressed[38] == true) {
			isKeyPressed[38] = false;
		} else if (way == 4 && isKeyPressed[40] == true) {
			isKeyPressed[40] = false;
		}
	}

}
