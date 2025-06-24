package hotel.database;

import java.sql.*;


import hotel.structures.ClientInfo;

/**
 * This class accesses the ClientsInfo SQL Table.
 */
public class ClientInfoDAO extends SQLDatabase{
	
	/**
	 * returns the ClientInfo corresponded to a cpf if the cpf is in the table, returns null otherwise.
	 * @param cpf
	 * @return
	 */
	public ClientInfo getClientInfo(int cpf) {
	    try {
	      Statement st = connection.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM ClientsInfo WHERE " + 
	                                     "cpf='" + cpf + "'");
	      if (rs.next()) {
	        return new ClientInfo(rs.getString(2), Integer.parseInt(rs.getString(4)), rs.getString(3), Integer.parseInt(rs.getString(5)));
	      }
	      else return null;
	    }
	    catch (SQLException e) { System.out.println(e); return null; }
	  }
	
	/**
	 * returns the ClientInfo corresponded to a name if the name is in the table, returns null otherwise.
	 * DO NOTE that this wont function quite well if there are two people with the same name, however, this function isnt ever used.
	 * @param cpf
	 * @return
	 */
	public ClientInfo getClientInfo(String name) {
	    try {
	      Statement st = connection.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM ClientsInfo WHERE " + 
	                                     "name='" + name + "'");
	      if (rs.next()) {
	        return new ClientInfo(rs.getString(2), Integer.parseInt(rs.getString(4)), rs.getString(3), Integer.parseInt(rs.getString(5)));
	      }
	      else return null;
	    }
	    catch (SQLException e) { System.out.println(e); return null; }
	  }
	
	/**
	 * Adds a client to the table if their cpf isnt already registered.
	 * @param clientinfo
	 * @return
	 */
	public boolean addClient (ClientInfo clientinfo) {
	    try {
	      Statement st = connection.createStatement();
	      ResultSet rs =  st.executeQuery("SELECT * FROM ClientsInfo WHERE " + "cpf='" + clientinfo.cpf + "'");
	      //if theres no client with this cpf.
	      if (!rs.next()){
	              int affected = st.executeUpdate("INSERT INTO ClientsInfo VALUES(NULL, '" + clientinfo.name + "', '" + clientinfo.adress + 
                          "', " + clientinfo.cpf + ", " + clientinfo.phoneNumber + ")");
	              if (affected > 0) return true  ;
	      }
	      return false;
	    } catch (SQLException e) { System.out.println(e + " at ClientInfoDAO addClient()"); return false; }
	  }
	
	

}
