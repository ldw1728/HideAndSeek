package Object;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import Player.Move;

public class Map {
	private int x, y;
	private Image img;
	private CreateMapObject cmo;
	// private ArrayList<Item> items;

	public Map(int x, int y) {
		cmo = new CreateMapObject();

		this.x = 400 - x;
		this.y = 300 - y;

		img = Toolkit.getDefaultToolkit().getImage("Img/grassMap2.png");
		img = img.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
	}

	public ArrayList<ArrayList<MapObject>> getObject() {
		return this.cmo.getObjects();
	}

	public CreateMapObject getCmo() {
		return this.cmo;
	}

	public Image getImg() {
		return this.img;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}
}
