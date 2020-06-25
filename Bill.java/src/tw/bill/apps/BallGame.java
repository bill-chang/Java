package tw.bill.apps;

import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

//import tw.bill.apps.BallGame.MyPanel.BallTask;

public class BallGame extends JFrame {
	private MyPanel mp;
	public BallGame() {
		super("ballgame");
		setLayout(new BorderLayout());
		
		
		mp=new MyPanel();
		add(mp,BorderLayout.CENTER);
		
		setVisible(true);
		setSize(1600,900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class MyPanel extends JPanel{
		private int ballX,ballY,windowWidth,windowHeight,ballH,ballW;
		private Timer timer;
		private BufferedImage ballImg;
		private LinkedList<BallTask> balls = new LinkedList<>();
		
		public MyPanel() {
			
			addMouseListener(new MyMouseAdapter());
			timer=new Timer();
			timer.schedule(new RefreshImgTask(), 0, 16);
			
			
			
			try {
				ballImg =ImageIO.read(new File("dir2/vball-png.png"));
				ballH=ballImg.getHeight();
				ballW=ballImg.getWidth();
				
			}catch (Exception e) {
				
			}
		}
		
		
		private class BallTask extends TimerTask{
			private int dx,dy;
			int ballX,ballY;
			BallTask(int ballX,int ballY) {
				dx=dy=4;
				this.ballX=ballX;this.ballY=ballY;
			}
			@Override
			public void run() {
				if(ballX<0||ballX+ballW>windowWidth) {
					dx *=-1;
				}
				if(ballY<0||ballY+ballH>windowHeight) {
					dy *=-1;
				}
				ballX +=dx;
				ballY +=dy;
				
			}
		}
	
		private class RefreshImgTask extends TimerTask{
			@Override
			public void run() {
				repaint();
			}
		}
		
		private class MyMouseAdapter extends MouseAdapter{
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				BallTask ball=new BallTask(e.getX()-ballW/2, e.getY()-ballW/2);
				timer.schedule(ball, 1000,30);
				balls.add(ball);
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			windowHeight=getHeight();windowWidth=getWidth();
			Graphics2D g2d=(Graphics2D)g;
			for(BallTask ball:balls) {
				g2d.drawImage(ballImg, ball.ballX, ball.ballY, null);
			}
			
		}
		
		
}
	

	

	public static void main(String[] args) {
		new BallGame();
	}

}
