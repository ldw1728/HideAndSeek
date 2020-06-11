package Object;

import java.awt.Rectangle;
import java.util.ArrayList;

public class House1 extends MapObject {

	private ArrayList<Rectangle> houseObj;

	public House1(int x, int y) {
		super(x, y);
		houseObj = new ArrayList<Rectangle>();
		houseObj.add(new Rectangle(578, 570, 138, 12));
		houseObj.add(new Rectangle(579, 450, 10, 127));
		houseObj.add(new Rectangle(589, 449, 225, 8));
		houseObj.add(new Rectangle(807, 459, 9, 123));
		houseObj.add(new Rectangle(747, 572, 61, 8));
		houseObj.add(new Rectangle(589, 459, 31, 45));
		houseObj.add(new Rectangle(757, 523, 46, 20));
		houseObj.add(new Rectangle(757, 478, 47, 27));

	}

	public ArrayList<Rectangle> getHouseObj() {
		return this.houseObj;
	}

}
