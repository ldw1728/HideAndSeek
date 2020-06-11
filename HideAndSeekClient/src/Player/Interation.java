package Player;

import java.util.ArrayList;
import java.util.Iterator;

import Object.Item;

public class Interation implements Action {

	private boolean[] isKeyPressed;
	private Player p;
	private ArrayList<Item> items;

	public Interation(Player p) {

		this.p = p;
		this.isKeyPressed = p.getIKP();

	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	@Override
	public void action() {

		if (p.isItemKey()) {

			System.out.println("----------------------space key\n");

			Iterator<Item> it = items.iterator();
			while (it.hasNext()) {
				Item i = it.next();
				if (isItem(i.getX(), i.getY())) {
					p.getConn().send_Message(p.getNname(), 4);
					p.getConn().setKey();
					System.out.println("----------------------i got a key\n");
					it.remove();
				}
			}
		}
	}

	public boolean isItem(int x, int y) {
		int px = p.getPX() + 10;
		int py = p.getPY() + 24;

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
