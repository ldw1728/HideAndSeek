package Player;

import Connect.Connection;
import Object.User;

public class Slash implements Action {

	private Player p;
	private Connection conn;

	public Slash(Player p, Connection conn) {
		this.p = p;
		this.conn = conn;
	}

	@Override
	public void action() {
		if (p.isSlash()) {
			conn.send_Message(p.getNname(), 8);
			for (Object o : conn.getUsers().getUsers()) {
				User u = (User) o;
				if (!u.isRole()) {
					if (u.getnName().equals(p.getNname()))
						continue;
					if (isUser(u.getX() + 10, u.getY() + 24)) {
						u.setRole(true);
						conn.send_Message(u.getnName(), 7);
					}
				}
			}
		}

	}

	public boolean isUser(int x, int y) {
		int px = p.getPX() + 22;
		int py = p.getPY() + 29;

		boolean i = false;
		if (p.getPlayerWay() == 1) {
			if (x > px - 30 && x < px && y > py - 20 && y < py + 20) {
				i = true;
			}
		} else if (p.getPlayerWay() == 2) {
			if (x < px + 30 && x > px && y > py - 20 && y < py + 20) {
				i = true;
			}
		} else if (p.getPlayerWay() == 3) {
			if (y > py - 30 && y < py && x > px - 20 && x < px + 20) {
				i = true;
			}
		} else if (p.getPlayerWay() == 4) {
			if (y < py + 30 && y > py && x > px - 20 && x < px + 20) {
				i = true;
			}
		}

		return i;

	}

}
