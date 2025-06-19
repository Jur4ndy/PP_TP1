package hotel.database;

import java.sql.*;


import hotel.structures.ClientInfo;


public class ClientInfoDAO extends SQLDatabase{
	
	public ClientInfo getClientInfo(int cpf) {
	    try {
	      Statement st = connection.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM ClientsInfo WHERE " + 
	                                     "cpf='" + cpf + "'");
	      if (rs.next()) {
	        return new ClientInfo(rs.getString(2), Integer.parseInt(rs.getString(3)), rs.getString(4), Integer.parseInt(rs.getString(5)));
	      }
	      else return null;
	    }
	    catch (SQLException e) { System.out.println(e); return null; }
	  }
	
	public ClientInfo getClientInfo(String name) {
	    try {
	      Statement st = connection.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM ClientsInfo WHERE " + 
	                                     "name='" + name + "'");
	      if (rs.next()) {
	        return new ClientInfo(rs.getString(1), Integer.parseInt(rs.getString(2)), rs.getString(3), Integer.parseInt(rs.getString(4)));
	      }
	      else return null;
	    }
	    catch (SQLException e) { System.out.println(e); return null; }
	  }
	
	public boolean addClient (ClientInfo clientinfo) {
	    try {
	      Statement st = connection.createStatement();
	      ResultSet rs =  st.executeQuery("SELECT * FROM ClientsInfo WHERE " + "cpf='" + clientinfo.cpf + "'");
	      //if theres no client with this cpf.
	      if (!rs.next()){
	              int affected = st.executeUpdate("INSERT INTO ClientsInfo VALUES('" + clientinfo.name + "', " + clientinfo.cpf + 
                          ", '" + clientinfo.adress + "', " + clientinfo.phoneNumber + ")");
	              if (affected > 0) return true  ;
	      }
	      return false;
	    } catch (SQLException e) { System.out.println(e); return false; }
	  }
	
	

}
