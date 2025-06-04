package hotel;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class RoomSelectWindow extends JFrame{
	
	int people;
	
	public RoomSelectWindow(int p, int d) {
		
		people = p;
		
		// Window icon
        ImageIcon mainIcon = new ImageIcon(getClass().getResource("Kevin.png"));
        Image img = mainIcon.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        mainIcon = new ImageIcon(img);
        this.setIconImage(mainIcon.getImage());

        // Root panel with BoxLayout
        JPanel rootPanel = new JPanel();
        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.PAGE_AXIS));
        rootPanel.setBackground(new Color(47, 32, 30)); // Set Background Color
        rootPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // house icon
        ImageIcon iconCh3 = new ImageIcon(getClass().getResource("chapter9icon.png"));
        JLabel icon = new JLabel(iconCh3);
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Description label
        JLabel title = new JLabel("Select the room type");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("MV Boli", Font.PLAIN, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Xtra info label
        JLabel ref = new JLabel("some room types might not be avaible depending on the amount of people you are booking for");
        ref.setForeground(new Color(95, 100, 100));
        ref.setFont(new Font("MV Boli", Font.ITALIC, 20));
        ref.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        
        /**
         *  These JButtons will be used to either open a new window to continue the booking process or close this one, retuning to
         *  the MainWindow
         */
        JButton single = new JButton("Single");   
        JButton doubl = new JButton("Double");
        JButton suite = new JButton("Presidential Suite");
        
        single.addActionListener((ActionEvent e) -> {
        	if (p < 4) {
	    		PaymentDataWindow pay = new PaymentDataWindow(p, d, 'S');
	    		pay.setVisible(true);
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "That room type is only avaible for 3 or less people.");
        	}

          });
        doubl.addActionListener((ActionEvent e) -> {
        	if (p < 6) {
	    		PaymentDataWindow pay = new PaymentDataWindow(p, d, 'D');
	    		pay.setVisible(true);
        	}
        	else {
        		JOptionPane.showMessageDialog(null, "That room type is only avaible for 5 or less people.");
        	}

        });
        suite.addActionListener((ActionEvent e) -> {
    		PaymentDataWindow pay = new PaymentDataWindow(p, d, 'P');
    		pay.setVisible(true);

        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(single);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(doubl);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(suite);

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
