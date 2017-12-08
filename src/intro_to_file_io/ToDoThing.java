package intro_to_file_io;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class ToDoThing implements ActionListener {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JLabel label = new JLabel();
	String filename;
	JFileChooser choose;
	ArrayList<String> list = new ArrayList<String>();

	public void setup() {

		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		frame.setVisible(true);
		button1.setText("Add Task");
		button2.setText("Remove Task");
		button3.setText("Save Text");
		button4.setText("Load Task");
		label.setText("<html>");
		panel.add(label);
		frame.setSize(500, 900);
		lastFile();
	}

	public static void main(String[] args) {

		ToDoThing oof = new ToDoThing();
		oof.setup();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(button1)) {
			String task = JOptionPane.showInputDialog("Enter a task to add");
			list.add(task);
			String temp = "";
			temp = label.getText();
			temp += "<br/>" + task;
			label.setText(temp);

		}
		if (e.getSource().equals(button2)) {
			String r = JOptionPane.showInputDialog("Enter the task number you would like to remove");
			int re = Integer.parseInt(r)-1;

			String v = list.get(re);
			list.remove(re);
			String temp = label.getText();
			String ss;
			// for (int i = 0; i < re-1 ; i++) {
			// ss = temp.substring(0,list.get(re-1).length ());
			// }
			// String s2 = temp.substring(list.get(re+1).length());
			String oof = temp.replaceAll("<br/>" + v, "");
			label.setText(oof);
		}

		if (e.getSource().equals(button3)) {
			 filename = JOptionPane.showInputDialog("Insert File Name");
		
			try {
				FileWriter fw = new FileWriter(""+filename + ".txt");

				//fw.write(new String(Base64.getEncoder().encode(label.getText().getBytes())));
				for (int i = 0; i < list.size(); i++) {
					fw.write(""+list.get(i)+"\n");
				}
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			try {
				FileWriter fw2 = new FileWriter("lastfile.txt");

				//fw.write(new String(Base64.getEncoder().encode(label.getText().getBytes())));
				fw2.write(filename);
				fw2.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		if (e.getSource().equals(button4)) {
			list.clear();
			label.setText("<html>");
			 choose=new JFileChooser();
			 choose.showOpenDialog(frame);
			 File chosen = choose.getSelectedFile();
			 BufferedReader reader;
			 try {
				reader = new BufferedReader(new FileReader(chosen));
				list.clear();
				 String line = reader.readLine();
				 String temp = "";
				 list.add(line);
				 int i=0;
				 String temp2 = "";
				 
					temp2 = label.getText();
					temp2 += "<br/>" + line;
					label.setText(temp2);
				 while(temp!=null) {
					 i++;
					
						System.out.println(line);
						
						temp=reader.readLine();
					
						if(temp!=null) {
							list.add(temp);
							
							temp2 = label.getText();
							temp2 += "<br/>" + temp;
							label.setText(temp2);
						line +=temp;}
					}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		
			try {
				FileWriter fw = new FileWriter(""+filename + ".txt");
			

				//fw.write(new String(Base64.getEncoder().encode(label.getText().getBytes())));
				for (int i = 0; i < list.size(); i++) {
					fw.write(""+list.get(i)+"\n");
				}
				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
	}
	public void lastFile() {
		 
		 
		 File file1 = new File("lastfile.txt");
		 BufferedReader reader2;
		 BufferedReader reader;
		 
		 String f;
		try {
			reader2 = new BufferedReader(new FileReader(file1));
			f = reader2.readLine();
			 File file2 = new File(""+f+".txt");
			 try {
				reader = new BufferedReader(new FileReader(file2));
				list.clear();
				 String line = reader.readLine();
				 String temp = "";
				 list.add(line);
				 int i=0;
				 String temp2 = "";
				 
					temp2 = label.getText();
					temp2 += "<br/>" + line;
					label.setText(temp2);
				 while(temp!=null) {
					 i++;
					
						System.out.println(line);
						
						temp=reader.readLine();
					
						if(temp!=null) {
							list.add(temp);
							
							temp2 = label.getText();
							temp2 += "<br/>" + temp;
							label.setText(temp2);
						line +=temp;}
					}
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		try {
			FileWriter fw = new FileWriter(""+filename + ".txt");

			//fw.write(new String(Base64.getEncoder().encode(label.getText().getBytes())));
			for (int i = 0; i < list.size(); i++) {
				fw.write(""+list.get(i)+"\n");
			}
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
