//package com.example.demo;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

@CrossOrigin
@RestController 
public class Controller {
    //declaring all java objects
    AL al = new AL();
    AL_Survey al_survey = new AL_Survey();
    BPM bpm = new BPM();
    Job job = new Job();
    Member member = new Member();
    Member_Survey member_survey = new Member_Survey();
    Preference pref = new Preference();
    Survey survey = new Survey();
    User user = new User();
    
    static String AL = "al";
	static String BPM = "bpm";
	static String PM = "pm";
	//connect to the database
	static int port = 3306;
	static String PUBLIC_DNS = "team2-db.clycp9fxciou.us-east-1.rds.amazonaws.com";
	static String PORT = ":"+ Integer.toString(port) +"/";
	static String DATABASE_NAME = "team2db";
	static String NO_Warning = "?useSSL=false";
	static String url = "jdbc:mysql://" + PUBLIC_DNS + PORT + DATABASE_NAME + NO_Warning;
	static String root = "team2";
	static String password = "team2Password";
	
	
	public static String type = "pm"; //global variable to track the user type
    //login page//
    @RequestMapping(method=RequestMethod.POST, value="login")
    public void login_sso (@RequestBody JSONObject login) throws Exception //will contain both sso and password
    {
    	String SSO = ""; // TODO update from json
		String pswd = ""; //TODO update from json
		SSO = (String) login.get("sso");
		pswd = (String) login.get("password");
	
		if(!login_check(SSO, pswd)) {
			System.err.println("Incorrect SSO or password");
			System.exit(0);
		}
		if(type.equals(PM))
			member = load_PM(SSO);
		else if(type.equals(AL))
			al = load_AL(SSO);
		else if(type.equals(BPM))
			bpm = load_BPM(SSO);
    }


    //bpm home page//
    @RequestMapping(method=RequestMethod.GET, value="bpm/home", produces={MediaType.APPLICATION_JSON_VALUE})
	public JSONObject bpm_home_get() throws Exception
	{
    	JSONObject toReturn = new JSONObject();
        JSONArray bpm_home_items = new JSONArray(); //json array stores page population items
        JSONObject todolist = new JSONObject();
        
        ArrayList<String> todo_items = bpm.getTodolist(); //retrieving todo list
        todolist.put("todolist", todo_items);
        bpm_home_items.add(todolist); //add todo list

        JSONObject bpm_timeline = new JSONObject();
        ArrayList<String> timeline = bpm.getAction(); //retrieve timeline
        bpm_timeline.put("timeline", timeline);
        bpm_home_items.add(bpm_timeline); //add timeline
        
        ArrayList<String> members = bpm.getMemberlist(); //arraylist of members' sso's
        Iterator i = members.iterator();
        while (i.hasNext()) //adding program member info, iterating through member sso's
        {
            JSONObject rotation_info = new JSONObject();

            String sso = (String) i.next(); //getting current member sso
            Member pm = null;
            pm = load_PM(sso); //retrieving member info from sso

            String rID = pm.getJobs().get(0);
            Job job = null;
            job = load_PM_Job(rID); //retrieving job info for member

            //retrieving info
            String name = pm.getFirstname() + " " + pm.getLastname();
            String rolename = job.getRolename();
            String hire_date = job.getStartdate();
            String role_description = job.getRoledescription();

            //loading into json
            rotation_info.put("name", name);
            rotation_info.put("rolename", job);
            rotation_info.put("startdate", hire_date);
            rotation_info.put("description", role_description);

            //load into json array
            bpm_home_items.add(rotation_info);
        }
        toReturn.put("bpm/home", bpm_home_items);
		return toReturn;// return json object
    }
        

    //bpm role assignment -- hardcode
    @RequestMapping(method=RequestMethod.GET, value="bpm/rotation_assignment", produces={MediaType.APPLICATION_JSON_VALUE})
    public JSONObject role_assignment()
    {
    	//TODO hard coding it good luck
        JSONObject roles = new JSONObject();
        return roles;
    }



    //bpm communications
	@RequestMapping(method=RequestMethod.GET, value="bpm/communications", produces={MediaType.APPLICATION_JSON_VALUE})
	public JSONObject bpm_communications__page() throws Exception
	{
		JSONObject toReturn = new JSONObject();
        JSONArray bpm_communication_items = new JSONArray(); //send back to front
        ArrayList<String> todo_items = bpm.getTodolist(); //get to do list
        JSONObject todolist = new JSONObject();
        todolist.put("todolist", todo_items);
        bpm_communication_items.add(todolist); //add to do list
        ArrayList<String> members = bpm.getMemberlist(); //arraylist of members' sso's
        Iterator i = members.iterator();
        while (i.hasNext())
        {
            JSONObject member = new JSONObject();
            String sso = (String) i.next();
            Member pm = null;
            pm = load_PM(sso); //load member info

            String fname = pm.getFirstname();
            String lname = pm.getLastname();
            String name = fname + " " + lname;
            //add to json
            member.put("name", name);
            //add to json array
            bpm_communication_items.add(member);
        }
        toReturn.put("bpm/communication", bpm_communication_items);
        return toReturn;
    }


    //bpm rotation approval
    @RequestMapping(method=RequestMethod.GET, value="bpm/rotation_approval", produces={MediaType.APPLICATION_JSON_VALUE})
	public JSONObject bpm_rotation_approval() throws Exception
	{
    	JSONObject toReturn = new JSONObject();
        JSONArray approved_rotations= new JSONArray();
        ArrayList<String> rotations = bpm.getJoblist(); //list of rotation id's
        Iterator i = rotations.iterator();
        while (i.hasNext())
        {
            JSONObject rotation_AL = new JSONObject();
            String rID = (String) i.next();
            Job job = null;
            job = load_PM_Job(rID); //loading rotation info

            AL al_name = null;
            //retrieve info
            String name = al_name.getFirstname() + " " + al_name.getLastname();
            String rolename = job.getRolename();
            String location = job.getRolelocation();
            String description = job.getRoledescription();

            //add to json object
            rotation_AL.put("AL", name);
            rotation_AL.put("rolename", rolename);
            rotation_AL.put("location", location);
            rotation_AL.put("description", description);

            //load to json array
            approved_rotations.add(rotation_AL);
        }
        toReturn.put("bpm/rotation_approval", approved_rotations);
        return toReturn;
    }


    //al home
    @RequestMapping(method=RequestMethod.GET, value="al/home", produces={MediaType.APPLICATION_JSON_VALUE})
	public JSONObject al_home() throws Exception
	{
    	JSONObject toReturn = new JSONObject();
        JSONArray al_home_items = new JSONArray();
        JSONObject todolist = new JSONObject();
        ArrayList<String> todo_items = al.getTodolist(); //retrieving todo list
        todolist.put("todolist", todo_items);
        al_home_items.add(todolist); //add to do list

        JSONObject al_timeline = new JSONObject();
        ArrayList<String> timeline = al.getAction();
        al_timeline.put("timeline", timeline);
        al_home_items.add(al_timeline); //add timeline

        ArrayList<String> members = al.getMemberlist(); //arraylist of members' sso's
        Iterator i = members.iterator();
        while (i.hasNext()) //iterate through AL's program members
        {
            JSONObject rotation_info = new JSONObject();
            String sso = (String) i.next();
            Member pm = null;
            pm = load_PM(sso);//retrieving individual member info from sso

            ArrayList<String> lead_past_jobs = pm.getJobs(); //member rotation history
            Iterator j = lead_past_jobs.iterator();
            
            while (j.hasNext())
            {
                String rID = (String) j.next();
                Job job = null;
                job = load_PM_Job(rID);//retrieving job info for member

                String name = pm.getFirstname() + " " + pm.getLastname();
                String rolename = job.getRolename();
                String location = job.getRolelocation();
                String start_date = job.getStartdate();
                String end_date = job.getEnddate();
                String role_description = job.getRoledescription();

                rotation_info.put("name", name);
                rotation_info.put("rolename", rolename);
                rotation_info.put("location", location);
                rotation_info.put("startdate", start_date);
                rotation_info.put("enddate", end_date);
                rotation_info.put("description", role_description);
                al_home_items.add(rotation_info);
            }

        }
        toReturn.put("al/home", al_home_items);
		return toReturn;
    }


    //al communications
    @RequestMapping(method=RequestMethod.GET, value="al/communication", produces={MediaType.APPLICATION_JSON_VALUE})
	public JSONObject bpm_communications ()
	{
    	JSONObject toReturn = new JSONObject();
        JSONArray al_communication_items = new JSONArray();
        JSONObject todolist = new JSONObject();
        ArrayList<String> todo_items = al.getTodolist();
        todolist.put("todolist", todo_items);
        al_communication_items.add(todolist); //add todo list
        toReturn.put("al/communication", al_communication_items);
        return toReturn;
    }

    //TODO double check for completion
    @RequestMapping(method=RequestMethod.GET, value="lead/assignment", produces={MediaType.APPLICATION_JSON_VALUE})
    public JSONObject lead_assignment() throws Exception
    {
        JSONObject toReturn = new JSONObject();
    	JSONArray lead_rotations = new JSONArray();
        ArrayList<String> rotations = bpm.getJoblist();
        Iterator i = rotations.iterator();
        while (i.hasNext())
        {
            JSONObject rotation_info = new JSONObject();
            String rID = (String)i.next();
            Job job = null;
            job = load_PM_Job(rID);

            String role = job.getRolename();
            String location = job.getRolelocation();
            String role_description = job.getRoledescription();
            String AL = job.getAL_sso();
            AL al_name = null;
            String name = al_name.getFirstname() + " " + al_name.getLastname();

            rotation_info.put("rolename", role);
            rotation_info.put("location", location);
            rotation_info.put("AL", name);
            rotation_info.put("description", role_description);
            lead_rotations.add(rotation_info);
        }
        toReturn.put("leadassignment", lead_rotations);
        return toReturn;
    }

    //LEAD communications
	@RequestMapping(method=RequestMethod.GET, value="lead/communications", produces={MediaType.APPLICATION_JSON_VALUE})
	public JSONObject lead_communications ()
	{
		JSONObject toReturn = new JSONObject();
        JSONArray lead_communications_items = new JSONArray();
        JSONObject todolist = new JSONObject();
        ArrayList<String> todo_items = new ArrayList<String>();
        if(type.equals(PM))
			todo_items = member.getTodolist();
		else if(type.equals(AL))
			todo_items = al.getTodolist();
		else if(type.equals(BPM))
			todo_items = bpm.getTodolist();
        todolist.put("todolist", todo_items);
        lead_communications_items.add(todolist); //add todo list
        toReturn.put("lead/communications", lead_communications_items);
        return toReturn;
    }


    //LEAD History
    @RequestMapping(method=RequestMethod.GET, value="lead/history", produces={MediaType.APPLICATION_JSON_VALUE})
    public JSONObject lead_history() throws Exception
    {
    	JSONObject toReturn = new JSONObject();
        JSONArray lead_info = new JSONArray();
        ArrayList<String> lead_past_jobs = member.getJobs(); //lead rotation history
        Iterator i = lead_past_jobs.iterator();
        while (i.hasNext())
        {
            JSONObject rotation_info = new JSONObject();

            String rotation_id = (String) i.next();
            Job job = null;
            job = load_PM_Job(rotation_id); //loading past rotation info

            //retrieve info
            String name = member.getFirstname() +" "+ member.getLastname();
            
            String rolename = job.getRolename();
            String location = job.getRolelocation();
            String start_date = job.getStartdate();
            String end_date = job.getEnddate();
            String role_description = job.getRoledescription();
            String update = job.getUpdatefield();

            //add to json
            rotation_info.put("name", name);
            rotation_info.put("rolename", rolename);
            rotation_info.put("startdate", start_date);
            rotation_info.put("enddate", end_date);
            rotation_info.put("description", role_description);
            rotation_info.put("updatefield", update);

            //add to json array
            lead_info.add(rotation_info);
        }
        toReturn.put("lead/history", lead_info);
        return toReturn;
    }
    
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
		Connection conn = DriverManager.getConnection(url, root, password);
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
		Connection conn = DriverManager.getConnection(url, root, password);
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
		Connection conn = DriverManager.getConnection(url, root, password);
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
		Connection conn = DriverManager.getConnection(url, root, password);
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
		
		Connection conn = DriverManager.getConnection(url, root, password);
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
		
		Connection conn = DriverManager.getConnection(url, root, password);
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
}
