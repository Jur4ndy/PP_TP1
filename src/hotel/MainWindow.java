package hotel;
import java.awt.*;
import javax.swing.*;

/**
 * Main Window class 
 */

public class MainWindow extends JFrame {
	
	
	//Baseado no capítulo 3 de Celeste
	public MainWindow () {
		super("Celestial Resort Hotel");
		
		ImageIcon  mainIcon = new ImageIcon(getClass().getResource("Kevin.png"));	//Main window icon
		Image img = mainIcon.getImage(); // transform it 
		img = img.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
		mainIcon = new ImageIcon(img);
		this.setIconImage(mainIcon.getImage());
		this.getContentPane().setBackground(new Color(29, 22, 26));
		setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		JLabel logo = new JLabel();
		logo.setIcon(mainIcon);
		logo.setBounds(0, 10, 2800, 100);
		
		JLabel title = new JLabel("Welcome to the world-renowed Celestial Resort Hotel!");
		title.setBounds(0, 10, 2800, 200);
	    title.setForeground(new Color(100, 100, 100));
	    title.setFont(new Font("MV Boli", Font.PLAIN, 50)); 
		
	    JLabel ref = new JLabel("yes, this is a Celeste reference");
		ref.setBounds(400, 40, 280, 100);
	    ref.setHorizontalAlignment(SwingConstants.CENTER);
	    ref.setForeground(new Color(95, 100, 100));
	    ref.setFont(new Font("MV Boli", Font.ITALIC, 20));
	    
	    JButton 
	    
	    JPanel buttonPanel = new JPanel();
	    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
	    
	    
		this.setSize(1660, 720);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(logo);
		this.add(title);
		this.add(ref);
		this.add(Box.createVerticalGlue());

		//this.setResizable(false);
	
	}
	
	public static void main(String args[]) {
		MainWindow window = new MainWindow();
		window.setVisible(true);
	}
}


