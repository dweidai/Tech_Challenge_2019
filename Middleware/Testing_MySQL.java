import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.json.simple.parser.ParseException;

public class Testing_MySQL {
	public static void main(String[] args) throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			throw new Exception("No database");
		}
		
		String url = "jdbc:mysql://localhost/sys?useSSL=false";
		String user = "root";
		String password = "mypassword";
		System.out.println("Class established");
		System.out.println("Connecting to database...");
		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		Statement stmt = null;
		
	    try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    System.out.println(stmt);
	    String sql;
	    sql = "SELECT id, first, last, age FROM Employees";
	    ResultSet rs = stmt.executeQuery(sql);
	    while(rs.next()){
	        int id  = rs.getInt("id");
	        int age = rs.getInt("age");
	        String first = rs.getString("first");
	        String last = rs.getString("last");
	        System.out.print("\n\tID: " + id );
	        System.out.print(", \tAge: " + age );
	        System.out.print(", \tFirst: " + first);
	        System.out.print(", \tLast: " + last);
	     }
	    rs.close();
	    stmt.close();
	    conn.close();
	    System.out.println("\n Testing Updating\n");
	    
		
		System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		stmt = null;
		
	    try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    System.out.println(stmt);
	    sql = "UPDATE Employees " + "SET Age = 100 where ID in(101, 103)";
	    stmt.executeUpdate(sql);
	    
	    sql = "SELECT id, first, last, age FROM Employees";
	    rs = stmt.executeQuery(sql);
	    while(rs.next()){
	        int id  = rs.getInt("id");
	        int age = rs.getInt("age");
	        String first = rs.getString("first");
	        String last = rs.getString("last");
	        System.out.print("\n\tID: " + id );
	        System.out.print(", \tAge: " + age );
	        System.out.print(", \tFirst: " + first);
	        System.out.print(", \tLast: " + last);
	     }
	    rs.close();
	    stmt.close();
	    conn.close();
	}
}
