import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Ball {
	public static final int SIZE = 10;
        public static Boolean gameStarted = false;
	private int x;
	private int y;
	private int xVelocity;
	private int yVelocity;
	private int speed = 5;
	
	public Ball() {
		reset();
	}
	
	private void reset() {
		x = 600/2 - SIZE/2;
		y = 400/2 - SIZE/2;
		
		xVelocity = Game.initialBallDirection(Math.random() * 2 - 1);
		yVelocity = Game.initialBallDirection(Math.random() * 2 - 1);
                gameStarted = false;
	}
	
	public void changeYDirection() {
		yVelocity *= -1;
	}
	
	public void changeXDirection() {
		xVelocity *= -1;
	}

	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, SIZE, SIZE);
	}

	public void update(Paddle paddle1, Paddle paddle2) {
            if(gameStarted)  {
		x += xVelocity * speed;
		y += yVelocity * speed;
                
		if(y + SIZE >= 350 || y <= 50) {
			changeYDirection();
		}
		
		if(x + SIZE >= 500){
			Game.addScore1(10);
			reset();
		}
		if(x <= 100){
			Game.addScore2(10);
			reset();
		}
            }
	}

	public int getXPosition() {
		return x;
	}
	
	public int getYPosition() {
		return y;
	}
}
