package intro_to_file_io;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import javax.swing.JButton;
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
			int re = Integer.parseInt(r);

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
		int filecount = 0;
		if (e.getSource().equals(button3)) {
			filecount += 1;
		
			try {
				FileWriter fw = new FileWriter("file" + filecount + ".txt");

				fw.write(new String(Base64.getEncoder().encode(label.getText().getBytes())));

				fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
