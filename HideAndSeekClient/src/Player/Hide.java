package Player;

import java.util.ArrayList;
import java.util.Iterator;

import Connect.Connection;
import Object.CreateMapObject;
import Object.MapObject;

public class Hide extends Thread implements Action {

	private Player p;
	private Connection conn;
	private CreateMapObject cmo;
	private Thread th;
	private ArrayList<MapObject> hideObject;
	private boolean[] ikp;

	public Hide(Player p, Connection conn, CreateMapObject cmo) {
		this.p = p;
		this.conn = conn;
		this.cmo = cmo;
		this.ikp = p.getIKP();
		hideObject = new ArrayList<MapObject>();
		init();
	}

	public void init() {
		int i = 0;
		for (i = 0; i < cmo.getTrees().size(); i++) {
			hideObject.add(cmo.getTrees().get(i));
		}

		for (i = 0; i < cmo.getMoai().size(); i++) {
			hideObject.add(cmo.getMoai().get(i));
		}

		for (i = 0; i < cmo.getPools().size(); i++) {
			hideObject.add(cmo.getPools().get(i));
		}

		for (i = 0; i < cmo.getRock().size(); i++) {
			hideObject.add(cmo.getRock().get(i));
		}
		for (i = 0; i < cmo.getCornField().size(); i++) {
			hideObject.add(cmo.getCornField().get(i));
		}

		for (i = 0; i < cmo.getEtc().size(); i++) {
			hideObject.add(cmo.getEtc().get(i));
		}

	}

	@Override
	public void action() {
		if (ikp[17]) {

			for (MapObject o : hideObject) {
				if (isHideObject(o)) {
					p.setHidding(true);

					conn.send_Message(p.getNname(), 9);
					th = new Thread(new Runnable() {

						@Override
						public void run() {
							try {

								Thread.sleep(5000);
								p.setHidding(false);

							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}

					});
					th.start();
				}
			}
		}
	}

	public boolean isHideObject(MapObject o) {
		boolean i = false;
		if (p.getArea().intersects(o.getArea())) {
			i = true;
		}
		return i;
	}
}
