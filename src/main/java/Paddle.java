import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class Paddle {
	private int x;
	private int y;
	int velocity = 0;
	private int speed = 10;
	private int width = 16;
	private int height = 70;
	private Color color;
	private boolean isLeftPaddle;
	
	public Paddle(Color c, boolean left) {
		color = c;
		this.isLeftPaddle = left;
		
		if(left) {
			x=100;
		}
		else {
			x = 500 - width;
		}
		y = 200 - height/2;
	}

	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
		
	}

	public void update(Ball ball) {
		y = Game.ensureRange(y + velocity, 50, 350 - height);
		
		int ballx = ball.getXPosition();
		int bally = ball.getYPosition();
		
		if(isLeftPaddle) {
			if(ballx <= width + 100 && bally + ball.SIZE >= y && bally <= y + height) {
				ball.changeXDirection();
			}
		}
		else {
			if(ballx + ball.SIZE >= 500 - width && bally + ball.SIZE >= y && bally <= y+height) {
				ball.changeXDirection();
			}
		}
	}

	public void switchDirection(int direction) {
		velocity = speed *direction;
		
	}
	
	public void stop() {
		velocity = 0;
	}
}

