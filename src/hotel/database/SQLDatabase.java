package hotel.database;
import java.sql.*;

public class SQLDatabase {
	// usuarios clientes (código único, nome, endereço e telefone) quartos (single double suite)
	private static String url = "Jdbc:mysql://localhost:3306/HotelClients";
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
	  } catch (SQLException e) { return false; }
	}

	public static boolean disconnect() {
	  try {
	    connection.close();
	    return true;
	  } catch (SQLException e) { return false; }
	}


}
