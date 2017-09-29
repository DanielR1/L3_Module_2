package intro_to_file_io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class EncryptedFile {
	JFileChooser choose = new JFileChooser();

	void v0id() throws IOException{
		JFrame frame = new JFrame();
		frame.setVisible(true);
		choose.showOpenDialog(frame);
		File file = choose.getSelectedFile();
		BufferedReader read = new BufferedReader(new FileReader(file));
		String line = read.readLine();
		String temp = "";
		while(temp!=null) {
			System.out.println(line);
			
			temp=read.readLine();
			if(temp!=null) {
			line +=temp;}
		}
		byte[] x= Base64.getDecoder().decode(line);
		System.out.println(new String(x));
		for (int i = 0; i < 2; i++) {
			
			
		}
	}
public static void main(String[] args) {
EncryptedFile o = new EncryptedFile();
try {
	o.v0id();
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

     
}
}
