package Object;

import java.util.Vector;

public class Users {
	private Vector users;

	public Users() {
		users = new Vector();
	}

	public Vector getUsers() {
		return users;
	}

	public void addUser(User user) {

		this.users.addElement(user);
	}

	public void removeUser(String nName) {
		nName = nName.trim();
		String temp = "";
		for (int i = 0; i < users.size(); i++) {
			User u = (User) users.elementAt(i);
			temp = u.getnName();
			if (temp.equals(nName)) {
				users.removeElement(u);
			}
		}
	}

	public int getSize() {
		return this.users.size();
	}

	public void users_SetX(int x) {
		for (Object o : users) {
			User u = (User) o;
			u.setX(u.getX() + x);
		}
	}

	public void users_SetY(int y) {
		for (Object o : users) {
			User u = (User) o;
			u.setY(u.getY() + y);
		}
	}

}
