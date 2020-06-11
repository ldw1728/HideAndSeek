package Object;

import java.util.ArrayList;

public class CreateItems {
	private ArrayList<Item> items;

	public CreateItems() {
		items = new ArrayList<Item>();
		items.add(new Key(289, 406));
		items.add(new Key(378, 463));
		items.add(new Key(371, 405));
	}

	public ArrayList<Item> getItems() {
		return this.items;
	}
}
