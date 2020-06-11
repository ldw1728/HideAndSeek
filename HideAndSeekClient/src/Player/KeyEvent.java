package Player;

import java.awt.event.KeyListener;

import Connect.Connection;
import Frame.GameView;

public class KeyEvent implements KeyListener {

	private boolean[] isKeyPressed;

	private Player p;
	private Connection conn;

	public KeyEvent(Player p, Connection conn) {
		this.conn = conn;
		this.p = p;
		isKeyPressed = p.getIKP();
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent e) {
		if (!GameView.gameOver) {
			if (!p.escape) {
				if (!p.isHidding()) {
					isKeyPressed[e.getKeyCode()] = true;
					if (e.getKeyCode() == 32) {
						if (p.role)
							p.setSlash(true);

						else
							p.setItemKey(true);
					} else if (e.getKeyCode() >= 37 && e.getKeyCode() <= 40)
						p.setMoving(true);
				}
			}
		}

	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent e) {

		isKeyPressed[e.getKeyCode()] = false;
		p.setMoving(false);
		p.setSlash(false);
		p.setItemKey(false);

		conn.send_Message(p.getNname() + " " + p.getPX() + "," + p.getPY(), 38);

	}

	@Override
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
