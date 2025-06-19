package hotel.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hotel.structures.ClientInfo;

public class StaffLoginDAO extends SQLDatabase {
	public boolean login(String user, String password) {
	    try {
	      Statement st = connection.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM StaffLoginInfo WHERE " + 
	                                     "user='" + user + "' and password='" + password + "'");
	      if (rs.next()) return true;      
	      else return false;
	    }
	    catch (SQLException e) { System.out.println(e); return false; }
	}

	public int getRank(String user) {
	    try {
	      Statement st = connection.createStatement();
	      ResultSet rs = st.executeQuery("SELECT * FROM StaffLoginInfo WHERE " + 
	                                     "user='" + user + "'");
	      if (rs.next()) return rs.getInt(3);      
	      else return -1;
	    }
	    catch (SQLException e) { System.out.println(e); return -1; }
	}


	public boolean addLogin(String user, String password) {
		try {
		      Statement st = connection.createStatement();
		      ResultSet rs =  st.executeQuery("SELECT * FROM StaffLoginInfo WHERE " + "user='" + user + "'");
		      //if theres no client with this cpf.
		      if (!rs.next()){
		              int affected = st.executeUpdate("INSERT INTO StaffLoginInfo VALUES('" + user + "', '" + password + "', '" + 1 +"')");
		              if (affected > 0) return true  ;
		      }
		      return false;
		    } catch (SQLException e) { System.out.println(e); return false; }
	}
	
	public boolean fire(String user) {
		try {
		      Statement st = connection.createStatement();
		      ResultSet rs =  st.executeQuery("SELECT * FROM StaffLoginInfo WHERE " + "user='" + user + "'");
		      //if theres no client with this cpf.
		      if (rs.next()){
		              int affected = st.executeUpdate( "DELETE from StaffLoginInfo WHERE user = '" + user  + "'");
		              if (affected > 0) return true  ;
		      }
		      return false;
		    } catch (SQLException e) { System.out.println(e); return false; }
	}
	
	public int getSize() {
		int s = 0;
		try {
			Statement st = connection.createStatement();
		    ResultSet rs =  st.executeQuery("SELECT * FROM StaffLoginInfo");
		    while(rs.next()) {
		    	s++;
		    }
		    return s;
		}
		catch (Exception e) {
			System.out.println(e); 
			return -1;
		}
	}
}