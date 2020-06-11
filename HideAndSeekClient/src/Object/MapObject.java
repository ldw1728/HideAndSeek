package Object;

import java.awt.Image;
import java.awt.Rectangle;

public class MapObject {
	private int x, y;
	private Rectangle oArea;
	// private Image image;

	public MapObject(int x, int y) {

		this.x = x;
		this.y = y;

	}

	public MapObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		createRect(x, y, width, height);
	}

	public void createRect(int x, int y, int width, int height) {
		this.oArea = new Rectangle(x, y, width, height);
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

	public Rectangle getArea() {
		return this.oArea;
	}
}
