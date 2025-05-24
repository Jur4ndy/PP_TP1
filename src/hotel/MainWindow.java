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

        // Window icon
        ImageIcon mainIcon = new ImageIcon(getClass().getResource("Kevin.png"));
        Image img = mainIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
        mainIcon = new ImageIcon(img);
        this.setIconImage(mainIcon.getImage());

        // Root panel with BoxLayout
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.PAGE_AXIS));
        rootPanel.setBackground(new Color(29, 22, 26)); // Match background
        rootPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Logo
        ImageIcon iconCh3 = new ImageIcon(getClass().getResource("chapter3icon.png"));
        JLabel logo = new JLabel(iconCh3);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Title label
        JLabel title = new JLabel("Welcome to the world-renowned Celestial Resort Hotel!");
        title.setForeground(new Color(100, 100, 100));
        title.setFont(new Font("MV Boli", Font.PLAIN, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Reference label
        JLabel ref = new JLabel("yes, this is a Celeste reference");
        ref.setForeground(new Color(95, 100, 100));
        ref.setFont(new Font("MV Boli", Font.ITALIC, 20));
        ref.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Buttons
        JButton book = new JButton("Book Now!");
        JButton loginStaff = new JButton("Staff Login");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(book);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(loginStaff);

        // Add components with spacing
        rootPanel.add(Box.createVerticalStrut(30));
        rootPanel.add(logo);
        rootPanel.add(Box.createVerticalStrut(20));
        rootPanel.add(title);
        rootPanel.add(Box.createVerticalStrut(10));
        rootPanel.add(ref);
        rootPanel.add(Box.createVerticalGlue());
        rootPanel.add(buttonPanel);
        rootPanel.add(Box.createVerticalStrut(30));
        rootPanel.add(Box.createVerticalGlue());

        // Add rootPanel to frame
        this.setContentPane(rootPanel);
        this.setSize(1660, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null); // center on screen
	}
	
	public static void main(String args[]) {
		MainWindow window = new MainWindow();
		window.setVisible(true);
	}
}


