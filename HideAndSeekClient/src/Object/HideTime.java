package Object;

public class HideTime extends Thread {

	private Users users;
	private String name;

	public HideTime(Users users, String name) {
		this.users = users;
		this.name = name;
	}

	@Override
	public void run() {

		try {
			sleep(3000);
			isUsersHide(this.name);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void isUsersHide(String name) {
		for (Object o : users.getUsers()) {
			User u = (User) o;
			if (u.getnName().equals(name)) {
				u.setHiding(false);
			}
		}
	}
}
