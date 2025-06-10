package hotel.windows;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * Main Window class, every other class will be used here to create it.
 */

public class MainWindow extends JFrame {
	
	
	//Constructor Method
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
        JLabel title = new JLabel("Welcome the world-renowned Celestial Resort Hotel!");
        title.setFont(new Font("MV Boli", Font.PLAIN, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(new Color(255, 255, 255));

        // Reference label
        JLabel ref = new JLabel("yes, I based my project on Celeste");
        ref.setForeground(new Color(95, 100, 100));
        ref.setFont(new Font("MV Boli", Font.ITALIC, 20));
        ref.setAlignmentX(Component.CENTER_ALIGNMENT);

        /**
         *  These JButtons will be used to open the other windows, one for clients who wish to book their stay. and another for 
         *  the staff to log in and see information that shouldn't be available to clients.
         */
        JButton book = new JButton("Book Now!");
        
        //Open BookWindow when pressed
        book.addActionListener((ActionEvent e) -> {
    		
      	  BookWindow bookWindow = new BookWindow();
      	  bookWindow.setVisible(true);

        });
        
        JButton login = new JButton("Staff Login");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(book);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(login);

        /** 
         * Add components to a JPanel with spacing, the vertical glues will ensure the JButtons are close to the center of the window
         */
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
		//Create the window and set it to visible
		MainWindow window = new MainWindow();
		window.setVisible(true);
	}
}


