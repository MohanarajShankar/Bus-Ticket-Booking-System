package org.busTicketBooking;
import java.sql.*;


public class DBconnection {
	static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static final String User = "hr";
	static final String Pass  = "0234";
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
        return DriverManager.getConnection(url, User, Pass);
    }
}
