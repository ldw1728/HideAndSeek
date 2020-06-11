package Object;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

public class EscapeDoor extends MapObject {
	private Image img;

	public EscapeDoor(int x, int y) {
		super(x, y);
		createRect(x + 7, y + 22, 34, 39);

		img = Toolkit.getDefaultToolkit().getImage("Img/escapeDoor.png");
	}

	public Image getImg() {
		return this.img;
	}

}
