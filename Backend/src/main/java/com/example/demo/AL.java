package com.example.demo;

import java.util.*;
import org.json.*;
public class AL extends User{

	private static String title;
	private static ArrayList<String> joblist;
	private static ArrayList<String> memberlist;
	private static AL_Survey alsurvey;

	private static final String DEFAULT = "default";

	public AL() {
		super();
		this.title = DEFAULT;
		this.joblist = new ArrayList<String>();
		this.memberlist = new ArrayList<String>();
	}

	public AL(String SSO, String password, String firstname, String lastname,
			String track, /*float[][] profile,*/ String email,
			ArrayList<String> list, ArrayList<String> action, ArrayList<String> intend,
			ArrayList<String> deadline, ArrayList<String> timeline,
			ArrayList<String> joblist, ArrayList<String> memberlist) {
		this.setFirstname(firstname);
		this.setLastname(lastname);
		this.setSSO(SSO);
		this.setPassword(password);
		this.setTrack(track);
		//setProfile(profile);
		this.setEmail(email);
		this.setTodolist(list);
		this.setAction(action);
		this.setTitle(title);
		this.setDeadline(deadline);
		this.setTimeline(timeline);
		this.setIntend(intend);
		this.joblist = joblist;
		this.memberlist = memberlist;

	}
	
	public void setTitle(String title) {
		boolean isNull = false;
		try {
			title.equalsIgnoreCase(null);
		} catch (NullPointerException npe) {
			isNull = true;
		}
		if (!isNull) {
			this.title = title.trim().replaceAll(" ", "").toLowerCase();
		} else {
			System.err.println("Please input a title");
		}
	}

	public String getTitle() {
		return this.title;
	}

	public ArrayList<String> getJoblist() {
		return joblist;
	}

	public void setJoblist(ArrayList<String> joblist) {
		this.joblist = joblist;
	}

	public ArrayList<String> getMemberlist() {
		return this.memberlist;
	}

	public void setMemberlist(ArrayList<String> memberlist) {
		this.memberlist = memberlist;
	}

	public static AL_Survey getAlsurvey() {
		return alsurvey;
	}

	public static void setAlsurvey(AL_Survey alsurvey) {
		AL.alsurvey = alsurvey;
	}

}
