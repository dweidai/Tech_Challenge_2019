import java.util.ArrayList;
import org.json.*;
public class Member extends User {
	
	private static String university;
	private static String major;
	private static String hiredate;
	private static String bpm_sso;
	private static ArrayList<String> jobs;
	private static Member_Survey membersurvey;
	private static Preference prefer;
	private static String feedback;

	private static final String DEFAULT = "default";

	public Member() {
		super();
		this.setUniversity(DEFAULT);
		this.setMajor(DEFAULT);
		this.hiredate = DEFAULT;
		this.bpm_sso = (DEFAULT);
		this.jobs = new ArrayList<String>(); //should store the RID
		this.setMembersurvey(null);
		this.setPrefer(null);
		this.setFeedback(DEFAULT);
	}

	public Member(String SSO, String password, String firstname,
			String lastname, String track, /*float[][] profile,*/ String email,
			ArrayList<String> list, ArrayList<String> action, ArrayList<String> intend,
			ArrayList<String> deadline, ArrayList<String> timeline, String university, String major, String hiredate, 
			String bpm, ArrayList<String> pastjobs, Member_Survey ms, Preference p,String fb) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setSSO(SSO);
		this.setPassword(password);
		this.setTrack(track);
		//setProfile(profile);
		this.setEmail(email);
		this.setTodolist(list);
		this.setAction(action);
		this.setUniversity(university);
		this.setMajor(major);
		this.setHiredate(hiredate);
		this.setBPM_SSO(bpm);
		this.setPastjobs(pastjobs);
		this.setMembersurvey(ms);
		this.setPrefer(p);
		this.setTimeline(timeline);
		this.setFeedback(fb);
		this.setDeadline(deadline);
		this.setIntend(intend);
	}
	
	public String getUniversity() {
		return this.university;
	}

	public void setUniversity(String uni) {
		boolean isNull = false;
		try {
			uni.equalsIgnoreCase(null);
		} catch (NullPointerException npe) {
			isNull = true;
		}
		if (!isNull) {
			this.university = uni;
		} else {
			System.err.println("Input an university/high school please");
		}
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		boolean isNull = false;
		try {
			major.equalsIgnoreCase(null);
		} catch (NullPointerException npe) {
			isNull = true;
		}
		if (!isNull) {
			this.major = major;
		} else {
			System.err.println("Input a major, not NULL");
		}
	}

	public String getHiredate() {
		return this.hiredate;
	}

	void setHiredate(String date) {
		this.hiredate = date;
	}

	public String getBPM_SSO() {
		return this.bpm_sso;
	}

	public void setBPM_SSO(String bpm) {
		this.bpm_sso = bpm;
	}

	public ArrayList<String> getJobs() {
		return jobs;
	}

	public void setPastjobs(ArrayList<String> pastjobs) {
		this.jobs = pastjobs;
	}


	public static Member_Survey getMembersurvey() {
		return membersurvey;
	}

	public static void setMembersurvey(Member_Survey membersurvey) {
		Member.membersurvey = membersurvey;
	}

	public static Preference getPrefer() {
		return prefer;
	}

	public static void setPrefer(Preference prefer) {
		Member.prefer = prefer;
	}

	public static String getFeedback() {
		return feedback;
	}

	public static void setFeedback(String feedback) {
		Member.feedback = feedback;
	}

}
