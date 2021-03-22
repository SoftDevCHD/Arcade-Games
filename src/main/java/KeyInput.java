import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	
	private Paddle p1;
	private boolean isGoingUp1 = false;
	private boolean isGoingDown1 = false;
	private Paddle p2;
	private boolean isGoingUp2 = false;
	private boolean isGoingDown2 = false;
	
	public KeyInput(Paddle paddle1, Paddle paddle2) {
		p1 = paddle1;
		p2 = paddle2;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			p2.switchDirection(-1);
			isGoingUp2 = true;
		}
		if(key == KeyEvent.VK_DOWN) {
			p2.switchDirection(1);
			isGoingDown2 = true;
		}
		
		if(key == KeyEvent.VK_W) {
			p1.switchDirection(-1);
			isGoingUp1 = true;
		}
		if(key == KeyEvent.VK_S) {
			p1.switchDirection(1);
			isGoingDown1 = true;
		}
                else if (key == KeyEvent.VK_SPACE)
                    Ball.gameStarted = true;
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) {
			isGoingUp2 = false;
		}
		if(key == KeyEvent.VK_DOWN) {
			isGoingDown2 = false;
		}
		
		if(key == KeyEvent.VK_W) {
			isGoingUp1 = false;
		}
		if(key == KeyEvent.VK_S) {
			isGoingDown1 = false;
		}
		
		if(!isGoingUp1 && !isGoingDown1) {
			p1.stop();
		}
		if(!isGoingUp2 && !isGoingDown2) {
			p2.stop();
		}
	}
}
