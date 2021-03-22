import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class Game extends Canvas implements Runnable {
	
        private BufferedImage pic = null;
	private static final long serialVersionUID = -5353067798179900783L;
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;
	
	static int score1 = 0;
	static int score2 = 0;
	
	public boolean running = false;
	private Thread gameThread;
	
	private Ball ball;
	private Paddle paddle1;
	private Paddle paddle2;
        
        private int score1Past, score2Past = 0;
	
	public Game(){
		
		canvasSetup();
		init();
		
		new Pong("Pong", this);
		
		this.addKeyListener(new KeyInput(paddle1, paddle2));
		this.setFocusable(true);
		
	}
	
	public static void addScore1 (int score) {
		score1 += score;
	}
	
	public static void addScore2 (int score) {
		score2 += score;
	}

	private void canvasSetup() {
		this.setPreferredSize(new Dimension( 600, 400));
		this.setMaximumSize(new Dimension( 600, 400));
		this.setMinimumSize(new Dimension( 600, 400));
		
	}
	
	private void init() {
		ball = new Ball();
		
		paddle1 = new Paddle(Color.white, true);
		paddle2 = new Paddle(Color.white, false);
                
	}

	public void run() {
		this.requestFocus();
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		double timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
                        if(score1 == 100){
                            JOptionPane.showMessageDialog(null, "Player 1 Wins!","Congratulations!", JOptionPane.PLAIN_MESSAGE);
                            running = false;
                        }
                        else if (score2 == 100){
                            JOptionPane.showMessageDialog(null, "Player 2 Wins!", "Congratulations!", JOptionPane.PLAIN_MESSAGE);
                            running = false;
                        }
               
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >=1 && score1 != 100 && score2 != 100) {
				update();
				delta--;
			}
			if(running) {
				draw();
			}
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
			}
		}
		stop();	
	}
	
	private void draw() {
		BufferStrategy buffer = this.getBufferStrategy();
		
		if(buffer == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = buffer.getDrawGraphics();
		drawBackground(g);
		
		ball.draw(g);
		
		paddle1.draw(g);
		paddle2.draw(g);
		
		g.dispose();
		buffer.show();
		
	}
	
	private void drawBackground(Graphics g) {
                try{
                    pic = ImageIO.read(new File("src\\test.jpg"));  //Background image
                }catch(IOException e){}
                g.drawImage(pic, 0, 0, 601, 401, this);
		g.setColor(Color.BLACK);
		g.fillRect(100, 50, WIDTH, HEIGHT);
	}
		
	private void update() {
		ball.update(paddle1, paddle2);
		paddle1.update(ball);
		paddle2.update(ball);
	}

	public void start() {
		gameThread = new Thread(this);
		gameThread.start();
                running = true;
	}
	
	public void stop(){
                score1 = 0;
                score2 = 0;
		try {
			gameThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int initialBallDirection(double d) {
		if(d <= 0) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
	public static int ensureRange(int value, int min, int max) {
		return Math.min(Math.max(value, min), max);
	}
	
	public static void main(String[] args) {
		new Game();
	}
        
        public static void scoreReset() {
            score1 = 0;
            score2 = 0;
        }
}
