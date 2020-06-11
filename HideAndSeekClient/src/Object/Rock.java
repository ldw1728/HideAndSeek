package Object;

public class Rock extends MapObject {

	public Rock(int x, int y) {
		super(x, y);
		createRect(x, y, 58, 68);
	}

	public Rock(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

}
