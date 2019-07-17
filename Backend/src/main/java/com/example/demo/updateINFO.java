package com.example.demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class updateINFO {
	
	static String url = "jdbc:mysql://localhost/TEST?useSSL=false";
	static String user = "root";
	static String login = "mypassword";
	
	public static void update_PM(Member pm) throws Exception {
		//establish connection to the JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			throw new Exception("No database");
		}
			
		Connection conn = DriverManager.getConnection(url, user, login);
		//gained access to database
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String SSO = pm.getSSO();
		String password = pm.getPassword();
		String firstname = pm.getFirstname();
		String lastname = pm.getLastname();
		String track = pm.getTrack();
		String email = pm.getEmail();
		String university = pm.getUniversity();
		String major = pm.getMajor();
		String hiredate = pm.getHiredate();
		String todolist = "";
		for (String s : pm.getTodolist())
		    todolist += s + " ";
		String action = "";
		for (String s : pm.getAction())
			action += s + " ";
		String intend = "";
		for (String s : pm.getIntend())
			intend += s + " ";
		String deadline = "";
		for (String s : pm.getDeadline())
			deadline += s + " ";
		String bpm = pm.getBPM_SSO();
		String rotation1 = null;
		String rotation2 = null;
		String rotation3 = null;
		String rotation4 = null;
		int size = pm.getJobs().size();
		if (size == 1 ) {
			rotation1 = pm.getJobs().get(0);
			String query = "UPDATE Program_Member SET Rotation_1=\'" + 
			rotation1 +"\' where PM_SSO=" + SSO;
			stmt.executeUpdate(query);

		}
		if (size == 2) {
			rotation1 = pm.getJobs().get(0);
			rotation2 = pm.getJobs().get(1);
			String query = "UPDATE Program_Member SET Rotation_1=\'" + rotation1 +"\', "
					+ "Rotation_2=\'" + rotation2 +"\' where PM_SSO=" + SSO;
			stmt.executeUpdate(query);
		}
		if (size == 3) {
			rotation1 = pm.getJobs().get(0);
			rotation2 = pm.getJobs().get(1);
			rotation3 = pm.getJobs().get(2);
			String query = "UPDATE Program_Member SET Rotation_1=\'" + rotation1 +"\', "
					+ "Rotation_2=\'" + rotation2 +"\', "
					+ "Rotation_3=\'" + rotation3 +"\' where PM_SSO=" + SSO;
			stmt.executeUpdate(query);
		}
		if (size == 4) {
			rotation1 = pm.getJobs().get(0);
			rotation2 = pm.getJobs().get(1);
			rotation3 = pm.getJobs().get(2);
			rotation4 = pm.getJobs().get(3);
			String query = "UPDATE Program_Member SET Rotation_1=\'" + rotation1 +"\', "
					+ "Rotation_2=\'" + rotation2 +"\', "
					+ "Rotation_3=\'" + rotation3 +"\', "
					+ "Rotation_4=\'" + rotation4 +"\' where PM_SSO=" + SSO;
			stmt.executeUpdate(query);
		}
		String query = "UPDATE Program_Member SET "
				+ "PM_Password=\'" + password +"\', "
				+ "PM_FName = \'" + firstname + "\', "
				+ "PM_LName = \'" + lastname + "\', "
				+ "Track = \'" + track + "\', "
				+ "Major = \'" + major + "\', "
				+ "University = \'" + university + "\', "
				+ "Email = \'" + email + "\', "
				+ "Hire_Date = \'" + hiredate + "\', "
				+ "BPM_SSO = \'" + bpm + "\', "
				+ "University = \'" + university + "\', "
				+ "where PM_SSO=" + SSO;
		stmt.executeUpdate(query);
		
		// working with the submits and Rotation Preference table
		Preference prefer = pm.getPrefer();
		//it needs to first reach back to the database to locate the Rotation Preference Table
		String sql = "SELECT * from Submits where PM_SSO=" + SSO;
		ResultSet rs = stmt.executeQuery(sql);
		String name_1 = "";
		if(rs.next())
			 name_1 = rs.getString("Name_1");
		query = "UPDATE Submits SET Name_1=\"" + prefer.getJob1().getRid() +"\" where PM_SSO=" + SSO;
		stmt.executeUpdate(query);
		query = "UPDATE Rotation_Preference SET "
				+ "Name_1=\"" + prefer.getJob1().getRid() +"\", "
				+ "Name_2=\"" + prefer.getJob2().getRid() +"\", "
				+ "Name_3=\"" + prefer.getJob3().getRid() +"\", "
				+ "Notes=\"" + prefer.getNotes() +"\", "
				+ "Reasoning=\""+ prefer.getReason() +"\" where Name_1=\"" + name_1 + "\"";
		stmt.executeUpdate(query);
		
		sql = "SELECT * from Program_Member where PM_SSO=" + SSO;
		rs = stmt.executeQuery(sql);
		String Action_Name = "";
		if (rs.next())
		  Action_Name = rs.getString("Action_Name");
		// not going to update the member survey because it's set in stone
		sql = "SELECT * from todo WHERE Action_Name=\"" + Action_Name + "\"";
		rs = stmt.executeQuery(sql);
		if(rs.next())
			 Action_Name = rs.getString("Action_Name");
		query = "UPDATE todo SET Action_Name =\"" + todolist + "\" ,"
				+ "Action_Status=\"" + action + "\" ,"
				+ "Intended_For=\"" + intend + "\", "
				+ "Deadline=\"" + deadline +"\" ";
		
	}
	public static void main(String[] args) {
		//check if the user login makes sense or not
		String SSO = "660622449"; // PM
		String pswd = "yDjAZrxr";
		SSO = "112233489"; // AL
		pswd = "zUsFLwjM";
		//SSO = "998877665"; //BPM
		//pswd = "VkX543WQ";
		
		AL al = null; // this is the global user
		BPM bpm = null;
		Member pm = null;
		Preference prefer = null;
		Member_Survey ms = null;

	}

}
