import java.sql.*;
import javax.swing.*;
public class sqliteconnection {
	Connection con = null;
	public static Connection dbConnector() {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/codinator/employeedb"); 
		//	JOptionPane.showMessageDialog(null,"con success");
			return conn;
		} 
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,e);
			return null;
		}
		
	}
}
