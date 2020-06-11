package Object;

import java.awt.Rectangle;
import java.util.ArrayList;

public class House2 extends MapObject {

	private ArrayList<Rectangle> houseObj;

	public House2(int x, int y) {
		super(x, y);
		houseObj = new ArrayList<Rectangle>();
		houseObj.add(new Rectangle(809, 3, 332, 68));
		houseObj.add(new Rectangle(1090, 70, 52, 31));
		houseObj.add(new Rectangle(810, 68, 14, 172));
		houseObj.add(new Rectangle(821, 120, 123, 71));

		houseObj.add(new Rectangle(823, 220, 141, 20));
		houseObj.add(new Rectangle(1003, 70, 20, 110));
		houseObj.add(new Rectangle(1025, 120, 23, 58));
		houseObj.add(new Rectangle(1056, 123, 61, 57));
		houseObj.add(new Rectangle(1125, 97, 16, 143));
		houseObj.add(new Rectangle(987, 221, 142, 20));

	}

	public ArrayList<Rectangle> getHouseObj() {
		return this.houseObj;
	}

}
