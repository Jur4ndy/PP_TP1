package hotel.windows;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

public class StaffLoginWindow extends JFrame {
	
	
	
	public StaffLoginWindow (int people, int days, char roomType) {
		super("Staff Login");
	
		
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
        ImageIcon iconCh3 = new ImageIcon(getClass().getResource("chapter8icon.png"));
        JLabel icon = new JLabel(iconCh3);
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Description label
        JLabel title = new JLabel("Please insert your username and password");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("MV Boli", Font.PLAIN, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Xtra info label
        JLabel ref = new JLabel("Customers shouldnt be accessing this window, please leave.");
        ref.setForeground(new Color(95, 100, 100));
        ref.setFont(new Font("MV Boli", Font.ITALIC, 20));
        ref.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        /**
         *  These JTextFields will be used for the login.
         */
        JTextField user  = new JTextField("Insert your username here...");
        user.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                user.setText("");
            }

            public void focusLost(FocusEvent e) {
            	if (user.getText() == "") {
                	user.setText("Insert your username here...");
                }
            }
        });
       
        JTextField password  = new JTextField("Insert your password here...");
        password.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                password.setText("");
            }

            public void focusLost(FocusEvent e) {
            	if (password.getText() == "") {
                	password.setText("Insert your password here...");
                }
            }
        });
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setOpaque(false);
        textFieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        textFieldPanel.add(user);
        textFieldPanel.add(password);

        /**
         *  These JButtons will be used to either open a new window to the staff's functions or go back to the MainWindow
         */
        JButton proceed = new JButton("Proceed");   
        JButton cancel = new JButton("Cancel");
        proceed.addActionListener((ActionEvent e) -> {
        		/**
        		 * Check if the username exists and if that user's password matches the inserted password.
        		 */
    			if(true) {
	    			int choice = JOptionPane.showConfirmDialog(null, "Are you sure your info is correct?");
	    			if (choice == JOptionPane.YES_OPTION) {
	    	            // If the user chose 'Yes', show a message indicating that changes are saved
	    				// Open staff window
	    	            this.dispose();
	    	        } else if (choice == JOptionPane.NO_OPTION) {
	    	            // If the user chose 'No', show a message indicating that changes are not saved
	    	            JOptionPane.showMessageDialog(null, "Please correct your info.");
	    	        } else {
	    	        	
	    	     }
    			}
    			else {
    				JOptionPane.showMessageDialog(null, "Invalid phone number and/or CPF.");
    			}
        });
        cancel.addActionListener((ActionEvent e) -> {
    		
        	  this.dispose();

          });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(proceed);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(cancel);

        /** 
         * Add components to a JPanel with spacing, the vertical glues will ensure the JButtons are close to the center of the window
         */
        rootPanel.add(Box.createVerticalStrut(30));
        rootPanel.add(icon);
        rootPanel.add(Box.createVerticalStrut(20));
        rootPanel.add(title);
        rootPanel.add(Box.createVerticalStrut(10));
        rootPanel.add(ref);
        rootPanel.add(Box.createVerticalGlue());
        rootPanel.add(textFieldPanel);
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
