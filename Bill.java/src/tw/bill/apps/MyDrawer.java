package tw.bill.apps;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MyDrawer extends JPanel {
	private Color color;
	private LinkedList<LinkedList<HashMap<String, Integer>>> lines,recycle;
	
	public MyDrawer() {
		setBackground(Color.YELLOW);
		
		lines=new LinkedList<>();
		recycle=new LinkedList<>();
		color=Color.BLUE;
		
		MyMouseListener listener=new MyMouseListener();
		addMouseListener(listener);
		addMouseMotionListener(listener);
		
	}
	
	public MyDrawer(File newFile) {
		this();
		try {
			loadObj(newFile);
		}catch (Exception e) {
			
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d=(Graphics2D)g;
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(4));
		
		for(LinkedList<HashMap<String, Integer>> line: lines) {
			for(int i=1;i<line.size();i++) {//第一個資料是顏色 所以i=1
				HashMap<String, Integer> p0=line.get(i-1);
				HashMap<String, Integer> p1=line.get(i);
				g2d.drawLine(p0.get("x"),p0.get("y"),p1.get("x"),p1.get("y"));
			}
		}
	}
	

	
	
	public void setLineColor(Color newcolor) {
		color=newcolor;
		repaint();
	}
	
	public Color getLineColor() {return color;}
	
	public void clear() {
		lines.clear();
		repaint();
	}
	
	public void undo() throws Exception {
		if(lines.size()>0) {
			recycle.add(lines.removeLast());
			repaint();
		}else {
			throw new Exception();
		}
	}
	
	public void redo() {
		if(recycle.size()>0) {
			lines.add(recycle.removeLast());
			repaint();
		}
	}
	
	public void saveJPEG(File file)  {
		BufferedImage img=new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_RGB);
		Graphics g=img.getGraphics();
		print(g);
		try {
			ImageIO.write(img, "jpg",file);
		}catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public void saveObj(File file) throws Exception{
		ObjectOutputStream oout=new ObjectOutputStream(new FileOutputStream(file)); 
		oout.writeObject(lines);
		oout.flush();
		oout.close();
		
		
	}
	
	public void loadObj(File file) throws Exception {
		ObjectInputStream oin=new ObjectInputStream(new FileInputStream(file));
		Object obj=oin.readObject();
		if(obj instanceof LinkedList) {
			lines=(LinkedList<LinkedList<HashMap<String,Integer>>>)obj;
			repaint();
		}else {
			throw new Exception();
		}
		oin.close();
	}



	private class MyMouseListener extends MouseAdapter{
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				recycle.clear();
				LinkedList<HashMap<String, Integer>> line=new LinkedList<HashMap<String,Integer>>();
				lines.add(line);
				
				HashMap<String, Integer> point =new HashMap<String, Integer>();
				point.put("x", e.getX());
				point.put("y", e.getY());
				line.add(point);
			
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				HashMap<String, Integer> point =new HashMap<String, Integer>();
				point.put("x", e.getX());
				point.put("y", e.getY());
				lines.getLast().add(point);
				repaint();
				
				
			}
		}

	private class Point{
		private  int x,y;
		void setXY() {
			this.x=x;
			this.y=y;
		}
			int getX() {return x;}
			int getY() {return y;}
		}
	}
