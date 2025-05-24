package hotel;
import java.awt.*;
import javax.swing.*;

/**
 * Main Window class 
 */

public class test extends JFrame {
	
	
	//Baseado no capítulo 3 de Celeste
	public test () {
		super("Celestial Resort Hotel");
		
		this.setLayout(null);
		this.setSize(1080, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//this.setResizable(false);
		
		ImageIcon  mainIcon = new ImageIcon("Kevin.jpeg");	//Main window icon
		this.setIconImage(mainIcon.getImage());
		this.getContentPane().setBackground(new Color(29, 22, 26));
		this.setLayout(new BorderLayout());
		
		JLabel logo = new JLabel();
		logo.setIcon(mainIcon);
		logo.setSize(800, 800);
	    logo.setHorizontalAlignment(SwingConstants.CENTER);
	    this.add(logo);
		
		JLabel title = new JLabel("Welcome to the world-renowed Celestial Resort Hotel");
		title.setSize(800, 800);
	    title.setHorizontalAlignment(SwingConstants.CENTER);
	    this.add(title);
	    
	    JLabel ref = new JLabel("yes, this is a Celeste reference");
		ref.setBounds(300, 40, 200, 80);
	    ref.setHorizontalAlignment(SwingConstants.CENTER);
	    this.add(ref);
	
	}
	
	public static void main(String args[]) {
		test window = new test();
		window.setVisible(true);
	}
}


