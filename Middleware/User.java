import java.util.ArrayList;
import java.util.Arrays;
import org.json.*;
public class User {
	private static String SSO;
	private static String password;
	private static String firstname;
	private static String lastname;
	private static String track;
	//private static double[][] profile = new double[1080][1080];
	private static String email;
	private static ArrayList<String> todolist;
	private static ArrayList<String> action;
	private static ArrayList<String> intend;
	private static ArrayList<String> deadline;
	private static ArrayList<String> timeline;

	private static String DEFAULT = "default";

	public User() {
		this.SSO = DEFAULT;
		this.password = DEFAULT;
		this.firstname = DEFAULT;
		this.lastname = DEFAULT;
		this.track = DEFAULT;
		//Arrays.fill(profile, 0.0);
		this.email = DEFAULT;
		this.todolist = new ArrayList<String>();
		this.action = new ArrayList<String>();
		this.intend = new ArrayList<String>();
		this.deadline = new ArrayList<String>();
		this.timeline = new ArrayList<String>();

	}

	protected User(String SSO, String password, String firstname, String lastname,
			String track, /*double[][] profile,*/ String email,
			ArrayList<String> list, ArrayList<String> action, ArrayList<String> intend, 
			ArrayList<String> dead, ArrayList<String> timeline) {
		setFirstname(firstname);
		setLastname(lastname);
		setSSO(SSO);
		setPassword(password);
		setTrack(track);
		//setProfile(profile);
		setEmail(email);
		setTodolist(list);
		setAction(action);
		setIntend(intend);
		setDeadline(dead);
		setTimeline(timeline);
	}

	protected static String getName() {
		return User.firstname + " " + User.lastname;
	}
	protected static String getFirstname() {
		return User.firstname;
	}
	
	protected static String getLastname() {
		return User.lastname;
	}
	protected static void setFirstname(String firstname) {
		boolean isNull = false;
		try {
			firstname.equalsIgnoreCase(null);
		} catch (NullPointerException npe) {
			isNull = true;
		}
		if (!isNull) {
			User.firstname = firstname;
		} else {
			System.err.println("Please input a firstname");
		}
	}

	protected static void setLastname(String lastname) {
		User.lastname = lastname;
	}

	protected static String getTrack() {
		return User.track;
	}

	protected static void setTrack(String track) {	
		User.track = track.trim().replaceAll(" ", "").toLowerCase();
	}

	protected static String getSSO() {
		return User.SSO;
	}

	protected static void setSSO(String SSO) {
		User.SSO = SSO.trim().replaceAll(" ", "").toLowerCase();
	}

	protected static String getPassword() {
		return User.password;
	}

	protected static void setPassword(String password) {
		boolean isNull = false;
		try {
			password.equalsIgnoreCase(null);
		} catch (NullPointerException npe) {
			isNull = true;
		}
		if (!isNull) {
			User.password = password;
		} else {
			System.err.println("Please input a password");
		}

	}
	protected static boolean isNumber(String number) {
		for (char c : number.toCharArray()) {
			if (Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}
	/*
	public static float[][] getProfile() {
		return profile;
	}

	public static void setProfile(float[][] profile) {
		User.profile = profile;
	}
	*/
	protected static String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		User.email = email;
	}

	protected ArrayList<String> getTodolist() {
		return todolist;
	}

	protected void setTodolist(ArrayList<String> todolist) {
		User.todolist = todolist;
	}

	protected ArrayList<String> getAction() {
		return action;
	}

	protected void setAction(ArrayList<String> action) {
		User.action = action;
	}

	protected static ArrayList<String> getIntend() {
		return intend;
	}

	protected static void setIntend(ArrayList<String> intend) {
		User.intend = intend;
	}

	protected static ArrayList<String> getDeadline() {
		return deadline;
	}

	protected static void setDeadline(ArrayList<String> deadline) {
		User.deadline = deadline;
	}

	protected static ArrayList<String> getTimeline() {
		return timeline;
	}

	protected static void setTimeline(ArrayList<String> timeline) {
		User.timeline = timeline;
	}
}
