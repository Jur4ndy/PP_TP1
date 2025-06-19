package hotel.database;
import java.sql.*;

/**
 * Class used to connect to the SQL Database, every DAO class extends this one.
 */
public class SQLDatabase {
	// usuarios clientes (código único, nome, endereço e telefone) quartos (single double suite)
	private static String url = "jdbc:mariadb://localhost:3306/HotelClients?allowPublicKeyRetrieval=true&useSSL=false";
	private static String user = "Oshiro";
	private static String pass = "Oshiro1234!@#$";
	protected static Connection connection = null;

	public SQLDatabase() {
	  if (connection == null) connect();
	}

	private static boolean connect() {
	  try {
	    connection = DriverManager.getConnection(url, user, pass);
	    return true;
	  } catch (SQLException e) { System.out.println(e); return false; }
	}

	public static boolean disconnect() {
	  try {
	    connection.close();
	    return true;
	  } catch (SQLException e) {  System.out.println(e); return false; }
	}


}
