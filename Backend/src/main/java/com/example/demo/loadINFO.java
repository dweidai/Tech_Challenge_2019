package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class loadINFO {
	//some global variable to keep track 
	static String AL = "al";
	static String BPM = "bpm";
	static String PM = "pm";
	//connect to the database
	static String url = "jdbc:mysql://localhost/TEST?useSSL=false";
	static String user = "root";
	static String login = "mypassword";
	
	public static String type = "pm"; //global variable to track the user type
	
	
	/*
	 * This is created to load the information from the Rotation_Submission table
	 * into the Rotation Java object
	 */
	public static Rotation load_Rotation_Submission(String RID) throws Exception{
		Rotation rotation = new Rotation();
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
		String sql = "SELECT * from Rotation_Submission where RID=" + RID;
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			rotation.setRolename(rs.getString("Name"));
			rotation.setRolelocation(rs.getString("Location"));
			rotation.setRoledepartment(rs.getString("Department"));
			rotation.setPast_experience(rs.getString("Past_Experience"));
			rotation.setMentor(rs.getString("Mentor_Name"));
			rotation.setColeader(rs.getString("Coleader"));
			rotation.setTravel(rs.getString("Travel_Amount"));
			ArrayList<String> sub_areas = new ArrayList<String>();
			sub_areas.add(rs.getString("Sub_Functional_Areas"));
			rotation.setSub_areas(sub_areas);
			rotation.setRoledescription(rs.getString("Description"));
			rotation.setAdditional(rs.getString("Additional_Learning"));
			ArrayList<String> capability = new ArrayList<String>();
			capability.add(rs.getString("Functional_Capabilities"));
			rotation.setCapabilities(capability);
			rotation.setOutcome(rs.getString("Outcomes"));
			rotation.setStatus(rs.getString("Approval_Status"));
			rotation.setAL_sso(rs.getString("AL_SSO"));
			rotation.setBPM_sso(rs.getString("BPM_SSO"));
			rotation.setRID(RID);
		}
		return rotation;
	}
	
	/*
	 * This is used to load the rotation information regarding all the PMs
	 */
	public static Job load_PM_Job(String RID) throws Exception{
		Job job = new Job();
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
		String sql = "SELECT * from Rotation where RID=" + RID;
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			job.setRid(Integer.toString(rs.getInt("RID")));
			job.setStartdate(rs.getString("Start_Date"));
			job.setEnddate(rs.getString("End_Date"));
			job.setRoledescription(rs.getString("Description"));
			job.setRolename(rs.getString("Name"));
			job.setUpdatefield(rs.getString("Updates"));
			job.setRolelocation(rs.getString("Location"));
			job.setStatus(rs.getString("Status"));
			job.setAL_feedback(rs.getString("AL_Feedback"));
			job.setAL_sso(rs.getString("AL_SSO"));
		}
		return job;
	}
	
	
	/*
	 * This is used to check if the login with SSO and password is matched to the database
	 */
	public static Boolean login_check(String SSO, String pswd) throws Exception{
		Boolean toReturn = false; //to return this
		//establish connection to the JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			throw new Exception("No database");
		}
		//connect to the database
		String url = "jdbc:mysql://localhost/TEST?useSSL=false";
		String user = "root";
		String password = "mypassword";
		Connection conn = DriverManager.getConnection(url, user, password);
		//gained access to database
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String checkAL = "SELECT AL_Password from AL where AL_SSO=" + SSO;
		String checkBPM = "SELECT BPM_Password from BPM where BPM_SSO="+ SSO;
		String checkPM = "SELECT PM_Password from Program_Member where PM_SSO=" + SSO;
		//check if the info is from
		ResultSet rs = stmt.executeQuery(checkAL);
		if(rs.next())
			if(rs.getString("AL_Password").equals(pswd)) {
				type = AL;
				toReturn = true;
			}
		rs = stmt.executeQuery(checkBPM);
		if(rs.next()) 
			if(rs.getString("BPM_Password").equals(pswd)) {
				type = BPM;
				toReturn = true;
			}
		rs = stmt.executeQuery(checkPM);
		if(rs.next()) 
			if(rs.getString("PM_Password").equals(pswd)) {
				type = PM;
				toReturn =  true;
			}
		rs.close();
	    stmt.close();
	    conn.close();
		return toReturn;
		
	}
	
	/*
	 * This is used to declare the member variable and load the information from the database
	 */
	public static Member load_PM(String SSO) throws Exception {
		//establish connection to the JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			throw new Exception("No database");
		}
		//connect to the database
		String url = "jdbc:mysql://localhost/TEST?useSSL=false";
		String user = "root";
		String login = "mypassword";
		Connection conn = DriverManager.getConnection(url, user, login);
		//gained access to database
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		//case Program Member;
		Member pm = new Member();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");   // for date configuration
		
		//getting all the information from the MySQL Database
		//loading the Program_Member table
		String sql = "SELECT * from Program_Member where PM_SSO=" + SSO;
		pm.setSSO(SSO);
		String Action_Name = null;
		String deadline_name = "";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			String password = rs.getString("PM_Password");
			pm.setPassword(password);
			String firstname = rs.getString("PM_FName");
			pm.setFirstname(firstname);
			String lastname = rs.getString("PM_LName");
			pm.setLastname(lastname);
			String major = rs.getString("Major");
			pm.setMajor(major);
			String track = rs.getString("Track");
			pm.setTrack(track);
			String email = rs.getString("Email");
			pm.setEmail(email);
			String university = rs.getString("University");
			pm.setUniversity(university);
			String hiredate = rs.getString("Hire_Date"); 
			pm.setHiredate(hiredate);
			ArrayList<String> pastjobs = new ArrayList<String>();
			// need to check if it's null, then we do not add it
			if(rs.getString("Rotation_1") != null) {
				String j = (rs.getString("Rotation_1"));
				pastjobs.add(j);
			}
			if(rs.getString("Rotation_2") != null) {
				String j =  (rs.getString("Rotation_2"));
				pastjobs.add(j);
			}
			if(rs.getString("Rotation_3") != null) {
				String j =  (rs.getString("Rotation_3"));
				pastjobs.add(j);
			}
			if(rs.getString("Rotation_4") != null) {
				String j = (rs.getString("Rotation_4"));
				pastjobs.add(j);
			}
			pm.setPastjobs(pastjobs);
			String bpm = Integer.toString(rs.getInt("BPM_SSO"));
			pm.setBPM_SSO(bpm);
			Action_Name = rs.getString("Action_Name");
			deadline_name = rs.getString("Deadline_Name");
		}
		
		sql = "SELECT * from todo WHERE Action_Name=\"" + Action_Name + "\"";
		rs = stmt.executeQuery(sql);
		ArrayList<String> todolist = new ArrayList<String>();
		ArrayList<String> actionlist = new ArrayList<String>();
		ArrayList<String> intend = new ArrayList<String>();
		if(rs.next()) {
			todolist.add(rs.getString("Action_Name"));
			actionlist.add(rs.getString("Action_Status"));
			intend.add(rs.getString("Intended_For"));
		}
		pm.setTodolist(todolist);
		pm.setAction(actionlist);
		pm.setIntend(intend);
		
		
		// now we need to manipulate the timeline
		sql = "SELECT * from Timeline WHERE Deadline_Name=\"" + deadline_name + "\"";
		rs = stmt.executeQuery(sql);
		ArrayList<String> deadline = new ArrayList<String>();
		ArrayList<String> timeline = new ArrayList<String>();
		if(rs.next()) {
			deadline.add(rs.getString("Deadline_Name"));
			timeline.add(rs.getString("Deadline_Date"));
		}
		pm.setDeadline(deadline);
		pm.setTimeline(timeline);
		
		//loading the Submits table and put into the Preference JAVA Object
		Preference prefer = new Preference();
		sql = "SELECT * from Submits where PM_SSO=" + SSO;
		rs = stmt.executeQuery(sql);
		String name_1 = null;
		if(rs.next())
			 name_1 = rs.getString("Name_1");
		System.out.println(name_1); //--->Security Analyst
		//loading the Rotation_Preference table and put into the Preference JAVA Object
		sql = "SELECT * from rotation_preference WHERE Name_1=\"" + name_1+"\"";
		rs = stmt.executeQuery(sql);
		if(rs.next()){
			Job job = new Job(rs.getString("Name_1"));
			prefer.setJob1(job);
			job = new Job(rs.getString("Name_2"));
			prefer.setJob2(job);
			job = new Job(rs.getString("Name_1"));
			prefer.setJob3(job);
			prefer.setNotes(rs.getString("Notes"));
			prefer.setReason(rs.getString("Reasoning"));
		}
		pm.setPrefer(prefer);
		
		//loading the Completes table and put into the Member_Survey JAVA Object
		Member_Survey ms = new Member_Survey();
		sql = "SELECT * from Completes where PM_SSO=" + SSO;
		rs = stmt.executeQuery(sql);
		String ms_date = null;
		if(rs.next())
			ms_date =rs.getString("Date");
		System.out.println(ms_date); 
		//loading the PM_Survey table and put into the Member_Survey JAVA Object
		sql = "SELECT * from PM_Survey WHERE Date=" + ms_date;
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			ms.setQ1(Integer.toString(rs.getInt("Question_1")));
			ms.setQ2(Integer.toString(rs.getInt("Question_2")));
			ms.setQ3(Integer.toString(rs.getInt("Question_2")));
			ms.setCurrent(rs.getString("Current_Work"));
			System.out.println("\t\t"+ rs.getString("Current_Work"));
			ms.setDepartment(rs.getString("Department"));
			System.out.println("\nt\t"+ rs.getString("Department"));
		}
		pm.setMembersurvey(ms);
		
		//there is still timeline need todo
		//not sure about the feedback will be for PM
		rs.close();
	    stmt.close();
	    conn.close();
	    return pm;
	}
	
	/*
	 * This is used to load the BPM data from the database
	 */
	public static BPM load_BPM(String SSO) throws Exception {
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
				
		//case Bad-ass Program Member;
		BPM bpm = new BPM();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");   // for date configuration
		
		//getting all the information from the MySQL Database
		//loading the AL table
		String sql = "SELECT * from BPM where BPM_SSO=" + SSO;
		bpm.setSSO(SSO);
		String Action_Name = null;
		String deadline_name = "";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			String password = rs.getString("BPM_Password");
			bpm.setPassword(password);
			String firstname = rs.getString("BPM_FName");
			bpm.setFirstname(firstname);
			String lastname = rs.getString("BPM_LName");
			bpm.setLastname(lastname);
			String track = rs.getString("Track");
			bpm.setTrack(track);
			String email = rs.getString("Email");
			bpm.setEmail(email);
			String university = rs.getString("Title");
			bpm.setTitle(university);
			String notes = rs.getString("Notes");
			bpm.setNote(notes);
			Action_Name = rs.getString("Action_Name");
			deadline_name = rs.getString("Deadline_Name");
		}
		System.out.println(Action_Name);
		System.out.println(Action_Name.trim());
		//loading the ToDo table and put into the ArrayList in Member JAVA Object
		sql = "SELECT * from todo WHERE Action_Name=\"" + Action_Name + "\"";
		rs = stmt.executeQuery(sql);
		ArrayList<String> todolist = new ArrayList<String>();
		ArrayList<String> actionlist = new ArrayList<String>();
		ArrayList<String> intend = new ArrayList<String>();
		if(rs.next()) {
			todolist.add(rs.getString("Action_Name"));
			actionlist.add(rs.getString("Action_Status"));
			intend.add(rs.getString("Intended_For"));
		}
		bpm.setTodolist(todolist);
		bpm.setAction(actionlist);
		bpm.setIntend(intend);
		
		
		// now we need to manipulate the timeline
		sql = "SELECT * from Timeline WHERE Deadline_Name=\"" + deadline_name + "\"";
		rs = stmt.executeQuery(sql);
		ArrayList<String> deadline = new ArrayList<String>();
		ArrayList<String> timeline = new ArrayList<String>();
		if(rs.next()) {
			deadline.add(rs.getString("Deadline_Name"));
			timeline.add(rs.getString("Deadline_Date"));
		}
		bpm.setDeadline(deadline);
		bpm.setTimeline(timeline);
		
		rs.close();
	    stmt.close();
	    conn.close();
	    return bpm;
	}
	
	/*
	 * This is used to load the AL from the database
	 */
	public static AL load_AL(String SSO) throws Exception {
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
				
		//case Assignment Leader;
		AL al = new AL();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");   // for date configuration
		
		//getting all the information from the MySQL Database
		//loading the AL table
		String sql = "SELECT * from AL where AL_SSO=" + SSO;
		al.setSSO(SSO);
		String Action_Name = null;
		String deadline_name = "";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			String password = rs.getString("AL_Password");
			al.setPassword(password);
			String firstname = rs.getString("AL_FName");
			al.setFirstname(firstname);
			String lastname = rs.getString("AL_LName");
			al.setLastname(lastname);
			String track = rs.getString("Track");
			al.setTrack(track);
			String email = rs.getString("Email");
			al.setEmail(email);
			String university = rs.getString("Title");
			al.setTitle(university);
			Action_Name = rs.getString("Action_Name");
			deadline_name = rs.getString("Deadline_Name");
		}
		sql = "SELECT * from todo WHERE Action_Name=\"" + Action_Name + "\"";
		rs = stmt.executeQuery(sql);
		ArrayList<String> todolist = new ArrayList<String>();
		ArrayList<String> actionlist = new ArrayList<String>();
		ArrayList<String> intend = new ArrayList<String>();
		if(rs.next()) {
			todolist.add(rs.getString("Action_Name"));
			actionlist.add(rs.getString("Action_Status"));
			intend.add(rs.getString("Intended_For"));
		}
		al.setTodolist(todolist);
		al.setAction(actionlist);
		al.setIntend(intend);
		
		
		// now we need to manipulate the timeline
		sql = "SELECT * from Timeline WHERE Deadline_Name=\"" + deadline_name + "\"";
		rs = stmt.executeQuery(sql);
		ArrayList<String> deadline = new ArrayList<String>();
		ArrayList<String> timeline = new ArrayList<String>();
		if(rs.next()) {
			deadline.add(rs.getString("Deadline_Name"));
			timeline.add(rs.getString("Deadline_Date"));
		}
		al.setDeadline(deadline);
		al.setTimeline(timeline);
		
		//loading the Fulfills table and put into the AL_Survey JAVA Object
		AL_Survey as = new AL_Survey();
		sql = "SELECT * from Fulfills where AL_SSO=" + SSO;
		rs = stmt.executeQuery(sql);
		String as_date = null;
		if(rs.next())
			as_date =rs.getString("Date");
		System.out.println(as_date); 
		//loading the AL_Survey table and put into the Member_Survey JAVA Object
		sql = "SELECT * from AL_Survey WHERE Date=" + as_date;
		System.out.println(sql);
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			as.setQ1(Integer.toString(rs.getInt("Question_1")));
			as.setQ2(Integer.toString(rs.getInt("Question_2")));
			as.setQ3(Integer.toString(rs.getInt("Question_2")));
			as.setCurrent(rs.getString("Current_Work"));
			System.out.println("\t\t"+ rs.getString("Current_Work"));
			as.setDepartment(rs.getString("Department"));
			System.out.println("\nt\t"+ rs.getString("Department"));
			as.setMember(rs.getString("PM_Name"));
		}
		al.setAlsurvey(as);
		
		//there is still timeline need todo
		//not sure about the feedback will be for PM
		rs.close();
	    stmt.close();
	    conn.close();
	    return al;
	}
	
	
	
	/*
	 * this is a testing to see if we can update the database from the object.
	 */
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
		String rotation1 = "";
		String rotation2 = "";
		String rotation3 = "";
		String rotation4 = "";
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
		query = "UPDATE Submits SET Name_1=\"" + prefer.getJob1() +"\" where PM_SSO=" + SSO;
		stmt.executeUpdate(query);
		query = "UPDATE Rotation_Preference SET "
				+ "Name_1=\"" + prefer.getJob1() +"\", "
				+ "Name_2=\"" + prefer.getJob2() +"\", "
				+ "Name_3=\"" + prefer.getJob3() +"\", "
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
	
	
	public static void main(String[] args) throws Exception {
		//check if the user login makes sense or not
		String SSO = "716124100"; // PM
		String pswd = "NrHmfUjg";
		
		if(!login_check(SSO, pswd)) {
			System.err.println("Incorrect SSO or password");
			System.exit(0);
		}
		AL al = null; // this is the global user
		BPM bpm = null;
		Member pm = null;
		
		//load all the information regarding the JAVA object
		if(type.equals(PM)) {
			pm = load_PM(SSO);
			System.out.println(pm.getEmail());
			System.out.println(pm.getFirstname());
			System.out.println(pm.getUniversity());
			System.out.println(pm.getMajor());
			System.out.println(pm.getBPM_SSO());
			System.out.println(pm.getMembersurvey().getDepartment());
			System.out.println(pm.getMembersurvey().getCurrent());
			Job rotation_1 = load_PM_Job(pm.getJobs().get(0));
			System.out.println(rotation_1.getRid());
			System.out.println(rotation_1.getStatus());
			System.out.println(rotation_1.getAL_feedback());
			System.out.println(rotation_1.getRoledescription());
			
		}
		else if(type.equals(BPM)) {
			bpm = load_BPM(SSO);
			System.out.println(bpm.getTitle());
			System.out.println(bpm.getEmail());
			System.out.println(bpm.getFirstname());
			System.out.println(bpm.getTitle());
			System.out.println(bpm.getNote());
		}
		else if(type.equals(AL)) {
			al = load_AL(SSO);
			System.out.println(al.getTitle());
			System.out.println(al.getEmail());
			System.out.println(al.getFirstname());
			System.out.println(al.getAlsurvey().getQ1());
			System.out.println(al.getAlsurvey().getDepartment());
		}
		
		Rotation rotate = null;
		rotate = load_Rotation_Submission("32222");
		System.out.println(rotate.getRoledepartment());
		System.out.println(rotate.getRoledescription());
		System.out.println(rotate.getRolelocation());
		System.out.println(rotate.getRolename());
		System.out.println(rotate.getAL_sso());
		System.out.println(rotate.getBPM_sso());
		System.out.println(rotate.getTravel());
		System.out.println(rotate.getAdditional());
		System.out.println(rotate.getColeader());
		System.out.println(rotate.getOutcome());
		System.out.println(rotate.getMentor());
		System.out.println(rotate.getPast_experience());
		System.out.println(rotate.getCapabilities());
		System.out.println(rotate.getSub_areas());
	}

}
