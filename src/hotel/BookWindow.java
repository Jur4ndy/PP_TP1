package hotel;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class BookWindow extends JFrame {
	
	
	
	public BookWindow () {
		super("Booking");
		
		// Window icon
        ImageIcon mainIcon = new ImageIcon(getClass().getResource("homeicon.png"));
        Image img = mainIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        mainIcon = new ImageIcon(img);
        this.setIconImage(mainIcon.getImage());

        // Root panel with BoxLayout
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.PAGE_AXIS));
        rootPanel.setBackground(new Color(47, 32, 30)); // Set Background Color
        rootPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // house icon
        ImageIcon iconCh3 = new ImageIcon(getClass().getResource("homeicon.png"));
        JLabel icon = new JLabel(iconCh3);
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Description label
        JLabel title = new JLabel("Select the days and amount of people you wish to book");
        title.setForeground(new Color(100, 100, 100));
        title.setFont(new Font("MV Boli", Font.PLAIN, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Xtra info label
        JLabel ref = new JLabel("the price will change depending on that information");
        ref.setForeground(new Color(95, 100, 100));
        ref.setFont(new Font("MV Boli", Font.ITALIC, 20));
        ref.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        /**
         * These JSpinners will be used to select the amount of people and days the person wishes to book
         */
        JSpinner days = new JSpinner(new SpinnerNumberModel(1, 1, 8, 1));  
        days.setSize(getPreferredSize());
        JSpinner people = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));
        people.setSize(getPreferredSize());
        
        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new BoxLayout(spinnerPanel, BoxLayout.LINE_AXIS));
        spinnerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        spinnerPanel.add(days);
        spinnerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        spinnerPanel.add(people);
        spinnerPanel.add(Box.createRigidArea(new Dimension(10, 0)));

        /**
         *  These JButtons will be used to either open a new window to continue the booking process or close this one, retuning to
         *  the MainWindow
         */
        JButton book = new JButton("Proceed");       
        JButton loginStaff = new JButton("Cancel");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(book);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(loginStaff);

        /** 
         * Add components to a JPanel with spacing, the vertical glues will ensure the JButtons are close to the center of the window
         */
        rootPanel.add(Box.createVerticalStrut(30));
        rootPanel.add(icon);
        rootPanel.add(Box.createVerticalStrut(20));
        rootPanel.add(title);
        rootPanel.add(Box.createVerticalStrut(10));
        rootPanel.add(ref);
        rootPanel.add(Box.createVerticalStrut(20));
        rootPanel.add(Box.createVerticalGlue());
        rootPanel.add(spinnerPanel);
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
}
