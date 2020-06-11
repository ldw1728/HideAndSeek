package Object;

public class CornField extends MapObject {

	public CornField(int x, int y) {
		super(x, y);
		createRect(x, y, 88, 88);
	}

	public CornField(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

}
