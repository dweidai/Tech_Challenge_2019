import java.util.*;
import org.json.*;
public class Job {
	//Database Developer
	private static String status;
	private static String rid;
	private static String startdate;
	private static String enddate;
	private static String rolename;
	private static String roledescription;
	private static String updatefield;
	private static String al_sso;
	private static String AL_feedback;
	private static String rolelocation;
	private static final String DEFAULT = "default";

	public Job() {
		this.setStatus(DEFAULT);
		this.setRid(DEFAULT);
		this.setStartdate(DEFAULT);
		this.setEnddate(DEFAULT);
		this.setRoledescription(DEFAULT);
		this.setRolelocation(DEFAULT);
		this.setRolename(DEFAULT);
		this.setUpdatefield(DEFAULT);
		this.setAL_sso(DEFAULT);
		this.setAL_feedback(DEFAULT);
	}
	public Job(String rolename) {
		this.setStatus(DEFAULT);
		this.setRid(DEFAULT);
		this.setStartdate(DEFAULT);
		this.setEnddate(DEFAULT);
		this.setRoledescription(DEFAULT);
		this.setRolelocation(DEFAULT);
		this.setRolename(rolename);
		this.setUpdatefield(DEFAULT);
		this.setAL_sso(DEFAULT);
		this.setAL_feedback(DEFAULT);		
	}
	public Job(String status, String startdate, String enddate, String rolename,
			String roledescription, String rolelocation, String field, String al,
			String fb) {
		this.setStatus(status);
		this.setStartdate(startdate);
		this.setEnddate(enddate);
		this.setRolename(rolename);
		this.setRoledescription(roledescription);
		this.setRolelocation(rolelocation);
		this.setAL_sso(al);
		this.setAL_feedback(fb);
		this.setUpdatefield(field);

	}
	/*
	 * No longer needed
	 */
	public static String hash(String rolename) {
		int threshold = 20;
		//set the length of the string to be 20 characters long max
		if(rolename.length() < threshold) {
			rolename = String.format("%-20s", rolename);
		}
		int hash = 7;
		for (int i = 0; i < threshold; i++) {
		    hash = hash*31 + rolename.charAt(i);
		}
		return Integer.toString(hash);
	}
	

	public static String getRolename() {
		return Job.rolename;
	}

	public void setRolename(String name) {
		if (name == null) {
			System.err.println("Please input a job for the name");
		} else {
			this.rolename = name;
		}
	}

	public static String getRoledescription() {
		return Job.roledescription;
	}

	public static void setRoledescription(String name) {
		Job.roledescription = name;
	}

	public static String getRolelocation() {
		return Job.rolelocation;
	}

	public static void setRolelocation(String rolelocation) {
		Job.rolelocation = rolelocation;
	}

	public static String getStartdate() {
		return Job.startdate;
	}

	public static void setStartdate(String date) {
		Job.startdate = date;
	}

	public static String getEnddate() {
		return Job.enddate;
	}

	public static void setEnddate(String date) {
		Job.enddate = date;
	}

	public static String getUpdatefield() {
		return Job.updatefield;
	}

	public static void setUpdatefield(String updatefield) {
		Job.updatefield = updatefield;
	}

	public static String getAL_feedback() {
		return AL_feedback;
	}

	public static void setAL_feedback(String aL_feedback) {
		AL_feedback = aL_feedback;
	}

	public static String getRid() {
		return rid;
	}

	public static void setRid(String rolename) {
		Job.rid = rolename;
	}

	public static String getAL_sso() {
		return al_sso;
	}

	public static void setAL_sso(String al_sso) {
		Job.al_sso = al_sso;
	}

	public static String getStatus() {
		return status;
	}

	public static void setStatus(String status) {
		Job.status = status;
	}

}
