package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MessageToFile {
public static void main(String[] args) {
	String oof = JOptionPane.showInputDialog("Say something for the file");

	try {
		FileWriter fw = new FileWriter("src/intro_to_file_io/test2.txt");
		
		
		
		fw.write("\n"+oof);
			
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
}