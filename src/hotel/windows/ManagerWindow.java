package hotel.windows;

import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

import javax.swing.*;

import hotel.structures.*;
import hotel.database.*;

/**
 * This Window is for the Manager, in this case, Oshiro (username Oshiro, password Farewell)
 * Here you can do everything you can on the Staff Window and more! 
 * Most notably Oshiro can add new Staff into the system by setting their username and password.
 */
public class ManagerWindow extends JFrame {

	private JFrame frame;
	//Constructor Method
		public ManagerWindow () {
			super("Welcome Mr Oshiro!");
			
			//some variables for
			StaffLoginDAO staffdao = new StaffLoginDAO();
			ReservationDAO rsdao = new ReservationDAO();
			ClientInfoDAO cdao = new ClientInfoDAO();
			
	        // Window icon
	        ImageIcon mainIcon = new ImageIcon(getClass().getResource("Kevin.png"));
	        Image img = mainIcon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
	        mainIcon = new ImageIcon(img);
	        this.setIconImage(mainIcon.getImage());

	        // Root panel with BoxLayout
	        JPanel rootPanel = new JPanel();
	        rootPanel.setOpaque(true);
	        rootPanel.setBackground(new Color(29, 22, 26));
	        rootPanel.setLayout(new BoxLayout(rootPanel, BoxLayout.PAGE_AXIS));
	        rootPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

	        // Logo
	        ImageIcon iconCh3 = new ImageIcon(getClass().getResource("moonberry.png"));
	        JLabel logo = new JLabel(iconCh3);
	        logo.setAlignmentX(Component.CENTER_ALIGNMENT);

	        // Title label
	        JLabel title = new JLabel("Welcome to the Manager Screen!");
	        title.setFont(new Font("MV Boli", Font.PLAIN, 40));
	        title.setAlignmentX(Component.CENTER_ALIGNMENT);
	        title.setForeground(new Color(255, 255, 255));

	        // Reference label
	        JLabel ref = new JLabel("What would you like to check?");
	        ref.setForeground(new Color(95, 100, 100));
	        ref.setFont(new Font("MV Boli", Font.ITALIC, 20));
	        ref.setAlignmentX(Component.CENTER_ALIGNMENT);


	        JButton hotelR = new JButton("Hotel Report");
	        
	        //Shows how many rooms there are and how many reservations they have
	        hotelR.addActionListener((ActionEvent e) -> {
	        	Hotel hotel = new Hotel();
	    		System.out.println(rsdao.getReservations(hotel));
	        	String message = "";
	        	int id = 0;
	        	boolean broke = false;
	        	for(Integer s : hotel.getOccupied()) {
	        		message += "Room "+id+" has "+s+" reservations\n";
	        		if (id%5 == 4 && id < Hotel.size - 1) {
       				 int cont = JOptionPane.showConfirmDialog(null, message + "would you like to see the next 5?");
       				 if (cont == JOptionPane.NO_OPTION) {
       					 broke = true;
       					 break;
       				 }
       				 message = "";
	        		 }
	        		id++;
	        	}
	        	if (!broke) JOptionPane.showConfirmDialog(null, message);

	        });
	        
	        JButton staffR = new JButton("Staff Report");
	        
	        //Shows how many staff there are
	        staffR.addActionListener((ActionEvent e) -> {
	        	JOptionPane.showMessageDialog(null, "The Hotel has: " + staffdao.getSize() + " staff");

	          });
	        
	        JButton check = new JButton("Get Client's Reservations");
	        //Tries to frie staff by their username
	        check.addActionListener((ActionEvent e) -> {
	    		try {
	    			Hotel hotel = new Hotel();
		    		System.out.println(rsdao.getReservations(hotel));
	    			LinkedList<Reservation> rs = new LinkedList<Reservation>();
	    			int size = 0;
	    			int i = 0;
	    			String message = "";
		        	String cpf = JOptionPane.showInputDialog("Enter the CPF and check any reservations associated with it:");
		        	rs = rsdao.getReservation(Integer.parseInt(cpf));
		        	size = rs.size();
		        	boolean broke = false;
		        	if (size == 0) { 
		        		JOptionPane.showMessageDialog(null, "It seems that CPF has no reservations attached to it.");
		        	}
		        	else {
			        	for (Reservation r : rs) {
			        		message += r.toString() + "\n"; 
			        		 if (i%5 == 4 && i < size-1) {
		        				 int cont = JOptionPane.showConfirmDialog(null, message + "would you like to see the next 5?");
		        				 if (cont == JOptionPane.NO_OPTION) {
		        					 broke = true;
		        					 break;
		        				 }
		        				 message = "";
			        		 }
			        		 i++;
			        	 }
			        	if(!broke) JOptionPane.showMessageDialog(null, message);
		    		}
	    		}
	    		catch(Exception er) {System.out.println(er); JOptionPane.showMessageDialog(null, "Something went wrong, make sure the CPF is composed of only numbers.");};

	          });
	        
	        JButton login = new JButton("Add new Staff Login");
	        
	        //Adds staff to the table StaffLoginInfo
	        login.addActionListener((ActionEvent e) -> {    		
	        	  String newUser = JOptionPane.showInputDialog("Enter your new Staff Username:");
	        	  String newPassword = JOptionPane.showInputDialog("Enter your new Staff Password:");
	        	  if(staffdao.addLogin(newUser, newPassword) == true) {
	        		  JOptionPane.showMessageDialog(null, newUser + " was successfully added to the database");
	        	  }
	        	  else JOptionPane.showMessageDialog(null, "Something went wrong, keep in mind the character limit of 50");
	        	  
	          });
	        
	        JButton fire = new JButton("Fire staff!");
	        
	        //Tries to frie staff by their username
	        fire.addActionListener((ActionEvent e) -> {
	    		
	        	String firedUser = JOptionPane.showInputDialog("Enter the Username of the Staff you wish to fire:");
	        	  if(staffdao.fire(firedUser) == true) {
	        		  JOptionPane.showMessageDialog(null, firedUser + " was successfully fired to the database");
	        	  }
	        	  else JOptionPane.showMessageDialog(null, "Something went wrong, make sure this person has been hired in the first place!");
	        	  

	          });
	        
	        JButton getClient = new JButton("Get Client's Info");
	        
	        //Gets a client's info by their cpf.
	        getClient.addActionListener((ActionEvent a) -> {
	    		try {
	        	String cpf = JOptionPane.showInputDialog("Enter the CPF of the Client whose info you'd like to get: ");
	        	ClientInfo info = cdao.getClientInfo(Integer.parseInt(cpf));
	        	  if(info != null) {
	        		  JOptionPane.showMessageDialog(null, "The CPF: " +cpf+ " is associated with the following information:\n" + 
	        		  "Name: " +info.name + "\nAdress: " +info.adress+ "\nPhone Number: " +info.phoneNumber);
	        	  }
	        	  else JOptionPane.showMessageDialog(null, "This cpf is not registered anywhere on the database.");
	    		}
	        	catch(Exception e) {System.out.println(e); JOptionPane.showMessageDialog(null, "Something went wrong, make sure the cpf is composed of only numbers"); }
	        	 

	          });
	        
	        JButton getRoom = new JButton("Get Room's Info");
	        
	        //Gets a client's info by their cpf.
	        getRoom.addActionListener((ActionEvent a) -> {
	    		try {
	        	int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the RoomID of the Room whose info you'd like to get: "));
	        	Hotel hotel = new Hotel();
	        	rsdao.getReservations(hotel);
	        	  if (id > -1 && id < Hotel.size) {
	        		  boolean broke = false;
	        		  Room room = hotel.rooms.get(id);
	        		  String message = "Room " +id+ " is a ";
	        		  if (room.type == 'S') message += "Single";
	        		  else if (room.type == 'D') message += "Double";
	        		  else message += "Presidential Suite";
	        		  if (room.reservations.isEmpty()) {
	        			  message += " with no reservations.";
	        			  JOptionPane.showMessageDialog(null, message);
	        			  broke = true;
	        		  }
	        		  else message += "with the following reservations: ";
	        		  int count = 0;
	        		  int size = room.reservations.size();
	        		  for (Reservation r : room.reservations) {
	        			  message += "\n" + r.toString();
	        			  if (count%5 == 4 && count < size-1) {
		        				 int cont = JOptionPane.showConfirmDialog(null, message + "\nwould you like to see the next 5?");
		        				 if (cont == JOptionPane.NO_OPTION) {
		        					 broke = true;
		        					 break;
		        				 }
		        				 message = "";
			        		 }
	        			  count++;
	        		  }
	        		  if(!broke) JOptionPane.showMessageDialog(null, message);
	        	  }
	        	  else JOptionPane.showMessageDialog(null, "Invalid RoomID, remember that number only goes from 0 to 39");
	    		}
	        	catch(Exception e) {System.out.println(e); JOptionPane.showMessageDialog(null, "Something went wrong, make sure the cpf is composed of only numbers"); }
	        	 

	          });
	        
	        

	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
	        buttonPanel.setOpaque(false);
	        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
	        buttonPanel.add(hotelR);
	        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
	        buttonPanel.add(check);
	        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
	        buttonPanel.add(getClient);
	        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
	        buttonPanel.add(getRoom);
	        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
	        buttonPanel.add(login);
	        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
	        buttonPanel.add(staffR);
	        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
	        buttonPanel.add(fire);

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
	        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        this.setLocationRelativeTo(null); // center on screen
		}
		
		public static void main(String args[]) {
			//Create the window and set it to visible
			MainWindow window = new MainWindow();
			window.setVisible(true);
		}

}
