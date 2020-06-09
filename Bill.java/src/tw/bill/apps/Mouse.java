package tw.bill.apps;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Mouse extends JFrame {
	private JTextField mesg;
	public Mouse() {
		super("Mouse");
		
		
		setLayout(new BorderLayout());
		mesg=new JTextField();
		add(mesg,BorderLayout.NORTH);
		
		JPanel content=new JPanel();
		add(content,BorderLayout.CENTER);
		
		content.addMouseListener(new MyMouserListener(this));
		
		setVisible(true);
		setSize(640,480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void setMesg(String info) {
		mesg.setText(info);
	}
	
	public static void main(String[] args) {
		new Mouse();
	}

}
class MyMouserListener extends MouseAdapter {
	private Mouse win;
	public MyMouserListener(Mouse win) {
		this.win=win;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		win.setMesg(e.getX()+","+e.getY());
		
	}
}
