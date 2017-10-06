package intro_to_file_io;

import javax.swing.JOptionPane;

public class InittyComitee {
public static void main(String[] args) {
	String x = JOptionPane.showInputDialog("Enter a number");
	int oof = Integer.parseInt(x);
	int notprime=0;
	for (int i = 2; i < oof-1; i++) {
		if(oof%i==0) {
			notprime++;
			System.out.println(""+oof%i);
		}
	}
	if(notprime==0) {
		
	
	JOptionPane.showMessageDialog(null, ""+oof+" is prime");
	}
	else {
		JOptionPane.showMessageDialog(null, ""+oof+" is not prime and has "+(notprime+2)+" factors");
	}
}
}
//I sexually identify as the sun. Ever since I was a boy I dreamed of slamming hydrogen isotopes into each other to make helium & light and send it throught the galaxy. People say to me that a person being a star is Impossible and I’m fucking retarded but I don’t care, I’m beautiful. I’m having a plastic surgeon inflate me with hydrogen and raise my temperature to over 6000 °C. From now on I want you guys to call me “Sol” and respect my right to give you vitamin D and probably sunburns. If you can’t accept me you’re a fusionphobe and need to check your astral privilege. Thank you for being so understanding.