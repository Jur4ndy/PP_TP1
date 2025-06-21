package hotel.windows;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import hotel.structures.*;
import hotel.database.*;

/**
 * In this window the price of the reservation is calculated and some things are determined: the start date of the reservation (which
 * when added with its duration also give us the end date) and the ckient's information.
 */
public class PaymentDataWindow extends JFrame {
	
	
	
	public PaymentDataWindow (int people, int days, char roomType) {
		super("Payment");
		ReservationDAO reserveDAO = new ReservationDAO();
		
		
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
        ImageIcon iconCh3 = new ImageIcon(getClass().getResource("flystrawberry.png"));
        JLabel icon = new JLabel(iconCh3);
        icon.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Description label
        JLabel title = new JLabel("Select the day you are checking in");
        title.setForeground(new Color(255, 255, 255));
        title.setFont(new Font("MV Boli", Font.PLAIN, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Xtra info label
        JLabel ref = new JLabel("and other necessary information");
        ref.setForeground(new Color(95, 100, 100));
        ref.setFont(new Font("MV Boli", Font.ITALIC, 20));
        ref.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        String total = "The price for a ";
        if (roomType == 'S') {
        	total += "Single room with " + people + " people for " + days + " days will cost you: $";
        	total += String.format("%.2f", (150.0 + 25*people)*days);
        }
        else if (roomType == 'D') {
        	total += "Double room with " + people + " people for " + days + " days will cost you: $";
        	total += String.format("%.2f", (225.0 + 25*people)*days);
        }
        else {
        	total += "Presidential Suite with " + people + " people for " + days + " days will cost you: $";
        	total += String.format("%.2f", (300.0 + 25*people)*days);
        }
        JLabel price = new JLabel(total);
        price.setForeground(new Color(255, 255, 255));
        price.setFont(new Font("MV Boli", Font.PLAIN, 20));
        price.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        /**
         * These JSpinners will be used to select the day
         * for simplicity's sake, every month will have 30 days
         */
        JSpinner day = new JSpinner(new SpinnerNumberModel(1, 1, 30, 1));  
        day.setSize(getPreferredSize());
        JLabel daylabel = new JLabel("Day");
        daylabel.setForeground(new Color(255, 255, 255));
        daylabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        daylabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JSpinner month = new JSpinner(new SpinnerNumberModel(1, 1, 12, 1));
        month.setSize(getPreferredSize());
        JLabel monthlabel = new JLabel("Month");
        monthlabel.setForeground(new Color(255, 255, 255));
        monthlabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        monthlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JSpinner year = new JSpinner(new SpinnerNumberModel(2025, 2025, 2026, 1));
        year.setSize(getPreferredSize());
        JLabel yearlabel = new JLabel("Year");
        yearlabel.setForeground(new Color(255, 255, 255));
        yearlabel.setFont(new Font("MV Boli", Font.PLAIN, 15));
        yearlabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.LINE_AXIS));
        labelPanel.setOpaque(false);
        labelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(daylabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(monthlabel);
        labelPanel.add(Box.createHorizontalGlue());
        labelPanel.add(yearlabel);
        labelPanel.add(Box.createHorizontalGlue());
        
        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new BoxLayout(spinnerPanel, BoxLayout.LINE_AXIS));
        spinnerPanel.setOpaque(false);
        spinnerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        spinnerPanel.add(Box.createHorizontalGlue());
        spinnerPanel.add(day);
        spinnerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        spinnerPanel.add(month);
        spinnerPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        spinnerPanel.add(year);
        spinnerPanel.add(Box.createHorizontalGlue());
        
        JPanel helperPanel = new JPanel();
        helperPanel.setLayout(new GridLayout(2, 3));
        helperPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        helperPanel.add(new JLabel()); //empty cells
        helperPanel.add(labelPanel);
        helperPanel.add(new JLabel());
        helperPanel.add(new JLabel());
        helperPanel.add(spinnerPanel);
        helperPanel.add(new JLabel());
        helperPanel.setOpaque(false);
        
        /**
         *  These JTextFields will be used to store client info, their cpf shall be used for their unique code
         */
        JTextField name  = new JTextField("Insert your name here...");
        name.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                name.setText("");
            }

            public void focusLost(FocusEvent e) {
            	if (name.getText() == "") {
                	name.setText("Insert your name here...");
                }
            }
        });
       
        JTextField adress  = new JTextField("Insert your email adress here...");
        adress.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                adress.setText("");
            }

            public void focusLost(FocusEvent e) {
            	if (adress.getText() == "") {
                	adress.setText("Insert your email adress here...");
                }
            }
        });
        
        JTextField phoneNumber  = new JTextField("Insert your phone number here...");
        phoneNumber.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                phoneNumber.setText("");
            }

            public void focusLost(FocusEvent e) {
                if (phoneNumber.getText() == "") {
                	phoneNumber.setText("Insert your phone number here...");
                }
            }
        });
        
        JTextField cpf  = new JTextField("Insert your CPF here...");
        cpf.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                cpf.setText("");
            }

            public void focusLost(FocusEvent e) {
            	if (cpf.getText() == "") {
                	cpf.setText("Insert your CPF here...");
                }
            }
        });
        
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setOpaque(false);
        textFieldPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        textFieldPanel.add(name);
        textFieldPanel.add(adress);
        textFieldPanel.add(phoneNumber);
        textFieldPanel.add(cpf);

        /**
         *  These JButtons will be used to either open a new window to continue the booking process or close this one, retuning to
         *  the MainWindow
         */
        JButton proceed = new JButton("Proceed");   
        JButton cancel = new JButton("Cancel");
        
        ClientInfoDAO info = new ClientInfoDAO();
        ReservationDAO reservations = new ReservationDAO();
        proceed.addActionListener((ActionEvent a) -> {
	    			int choice = JOptionPane.showConfirmDialog(null, "Are you sure your info is correct?");
	    			if (choice == JOptionPane.YES_OPTION) {
	    	            try {
	    	            	Hotel hotel = new Hotel();
	    	            	System.out.println(reserveDAO.getReservations(hotel));
	    	            	Date start = new Date((Integer)day.getValue(), (Integer)month.getValue(), (Integer)year.getValue());
	    	            	Reservation r = new Reservation(Integer.parseInt(cpf.getText()), start, start.add(days));
	    	            	System.out.println("Checkpoint 1");
 	    	            	int [] id_index = hotel.checkAvailable(r, roomType);
	    	            	System.out.println("Checkpoint 2");
	    	            	if (id_index[0] != -1) {
		    	            	if (null == info.getClientInfo(Integer.parseInt(cpf.getText()))) {
		    	            		info.addClient(new ClientInfo(name.getText(), Integer.parseInt(cpf.getText()), adress.getText(), 
	 	            					   						  Integer.parseInt(phoneNumber.getText())));
		    	            	}
		    	            	reservations.addReservation(r, id_index[0]);
		    	            	System.out.println("Checkpoint 3");
		    	            	hotel.rooms.get(id_index[0]).reservations.add(id_index[1], r);
	    	            	}
		    	            else  {
		    	            	JOptionPane.showMessageDialog(null, "Unfortunately, there are no Rooms available for this reservation...");
		    	            }
	    	            	this.dispose();
	    	            }
	    	            catch(Exception e) {
	    	            	System.out.println("Error at PaymentDataWindow: " + e);
	    	            	JOptionPane.showMessageDialog(null, "An error has Ocurred, make sure your phone number and"
	    	            	+ "cpf are composed of ONLY numbers."); 
	    	            }
	    			}    	            	    	         
    			    else if (choice == JOptionPane.NO_OPTION) {
	    	            // If the user chose 'No', show a message indicating that changes are not saved
	    	            JOptionPane.showMessageDialog(null, "Please correct your info.");
	    	        } else {
	    	        	
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
        rootPanel.add(Box.createVerticalStrut(10));
        rootPanel.add(price);
        rootPanel.add(Box.createVerticalStrut(20));
        rootPanel.add(Box.createVerticalGlue());
        rootPanel.add(helperPanel);
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
