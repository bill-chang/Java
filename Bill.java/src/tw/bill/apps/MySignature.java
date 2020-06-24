package tw.bill.apps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MySignature  extends JFrame{
	private MyDrawer mydrawer;
	private JButton saveJPEG,clear,undo,redo,saveObj,loadObj,chcolor;
	public MySignature() {
		super("Signature");
		
		setLayout(new BorderLayout());
		
		mydrawer=new MyDrawer();
		add(mydrawer,BorderLayout.CENTER);
		
		JPanel jp=new JPanel(new FlowLayout());
		
		
		saveJPEG=new JButton("saveJPEG");
		clear=new JButton("clear");
		undo=new JButton("undo");
		redo=new JButton("redo");
		saveObj=new JButton("saveObj");
		loadObj=new JButton("loadObj");
		chcolor=new JButton("chcolor");
		
		saveJPEG.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mydrawer.saveJPEG(new File("dir2/Bill.jpg"));
			}
		});
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mydrawer.clear();
			}
		});
		undo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mydrawer.undo();
				}catch (Exception e2) {
					
				}
			}
		});
		redo.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				mydrawer.redo();
			}
		});
		saveObj.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mydrawer.saveObj(new File("dir2/Bill.drawer"));
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		loadObj.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mydrawer.loadObj(new File("dir2/Bill.drawer"));
				}catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		chcolor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changeColor();
			}
		});
		
		jp.add(saveJPEG);jp.add(clear);jp.add(undo);jp.add(redo);
		jp.add(saveObj);jp.add(loadObj);jp.add(chcolor);
		add(jp,BorderLayout.SOUTH);
		
		
		setVisible(true);
		setSize(800,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void changeColor() {
		Color newColor=JColorChooser.showDialog(this, "change color", mydrawer.getLineColor());
		if(newColor!=null) {
			mydrawer.setLineColor(newColor);
		}
	}
	public static void main(String[] args) {
		
		new MySignature();
	}

}
