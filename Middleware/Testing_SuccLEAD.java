import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Testing_SuccLEAD {

	public static void main(String[] args) throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			throw new Exception("No database");
		}
		
		String url = "jdbc:mysql://localhost/TEST?useSSL=false";
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
	    String sql = "SELECT * FROM PM_Survey WHERE Rotation_Number in (1, 4)";
	    String query = "SELECT AL_Password, AL_FName, AL_LName from AL where AL_SSO=";
	    query = "select program_member.pm_fname, program_member.pm_lname, submits.PM_SSO, rotation_preference.Name_1, rotation_preference.Name_2, rotation_preference.Name_3, rotation_preference.Reasoning\n" + 
	    		"from rotation_preference, submits, program_member\n" + 
	    		"where rotation_preference.Name_1=submits.name_1 and submits.PM_SSO=program_member.PM_SSO and program_member.PM_SSO=";
	    String SSO = "112233489";
	    SSO = "660622449";
	    sql = query + SSO;
	    System.out.println(sql);
	    ResultSet rs = stmt.executeQuery(sql);
	    //System.out.println(rs.next());
	    if(rs.next()) {
	    	String fn = rs.getString("PM_FName");
	    	String ln = rs.getString("PM_LName");
	    	System.out.println(SSO + " is " + fn + " " + ln );
	    }
	    
	    query = "SELECT * from Program_Member where PM_SSO=";
	    SSO = "660622449";
	    sql = query + SSO;
	    rs = stmt.executeQuery(sql);
	    //System.out.println(rs.next());
	    if(rs.next()) {
	    	if(rs.getString("Rotation_4") == null) {
	    		System.out.println("AHHA");
	    	}
	    	String fn = rs.getString("PM_FName");
	    	String ln = rs.getString("PM_LName");
	    	String pswd = rs.getString("PM_Password");
	    	System.out.println(SSO + " is " + fn + " " + ln + " " + pswd);
	    }
	    query = "UPDATE Program_Member SET PM_Password=\"qazaq \"where PM_SSO=" ;
	    sql = query + SSO;
	    stmt.executeUpdate(sql);
	    query = "SELECT PM_Password from Program_Member where PM_SSO=";
	    sql = query + SSO;
	    System.out.println(sql);
	    rs = stmt.executeQuery(sql);
	    //System.out.println(rs.next());
	    if(rs.next()) {
	    	String pswd = rs.getString("PM_Password");
	    	System.out.println(SSO + " " + pswd);
	    }
        rs.close();
	    stmt.close();
	    conn.close();
	}

}
