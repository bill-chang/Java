package tw.bill.apps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyEditor extends JFrame {
	private JButton open,save,saveas,chageColor;
	private JTextArea jta;
	
	public MyEditor() {
		super("MyEditor");
		
		setLayout(new BorderLayout());
		JPanel topline=new JPanel(new FlowLayout());
		open=new JButton("open");save=new JButton("save");saveas=new JButton("saveas");
		chageColor=new JButton("changeColor");
		topline.add(open);
		topline.add(save);
		topline.add(saveas);
		topline.add(chageColor);
		add(topline,BorderLayout.NORTH);
		
		jta=new JTextArea();
		jta.setForeground(nowColor);
		jta.setFont(new Font("", Font.BOLD+Font.ITALIC, 24));
		JScrollPane jsp=new JScrollPane(jta);
		
		
		add(jsp,BorderLayout.CENTER);
		
		setSize(640,480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		initEvent();
	}
	
	private void initEvent() {
		open.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				openFile();
				
			}
		});
		save.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				saveFile();
			}
		});
		saveas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				saveasFile();
			}
		});
		chageColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自動產生的方法 Stub
				changeColor();
			}
		});
	}
	private Color nowColor=Color.BLUE;
	private void changeColor() {
		nowColor=JColorChooser.showDialog(this, "change Color", nowColor);
		jta.setForeground(nowColor);
	}
	
	private File openFile;
	
	private void openFile() {
		JFileChooser jfc=new JFileChooser(new File("."));
		
		if(jfc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
			openFile=jfc.getSelectedFile();
			readFile();
			
		}
	}
	
	private void readFile() {
		if(openFile==null)return;
		try {
			BufferedReader reader=new BufferedReader(new FileReader(openFile));
			jta.setText("");String line;
			while((line=reader.readLine())!=null) {
				jta.append(line+"\n");
			}
			reader.close(); 
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	private void saveFile() {
		if(openFile==null) {
			saveasFile();
		}else {
			writeFile();
		}
	}
	private void saveasFile() {
		JFileChooser jfc=new JFileChooser(new File("."));
		if(jfc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
			openFile =jfc.getSelectedFile();
			writeFile();
			
		}
	}
	
	private void writeFile() {
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(openFile));
			
			writer.write(jta.getText());
			
			writer.flush();
			writer.close();
			JOptionPane.showMessageDialog(this, "save ok!");
		}catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void main(String[] args) {
		new MyEditor();

	}

}
