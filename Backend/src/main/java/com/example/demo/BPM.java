package com.example.demo;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.io.Reader;
import java.io.FileReader;
import java.io.FileWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;
import java.io.IOException;

public class BPM extends User{
	
	private static String title;
	private static String note;
	private static ArrayList<String> joblist;
	private static ArrayList<String> memberlist;
	
	private static final String DEFAULT = "default";

	public BPM() {
		super();
		this.setTitle(DEFAULT);
		this.setNote(DEFAULT);
		this.memberlist = new ArrayList<String>();
		this.joblist = new ArrayList<String>();
	}

	public BPM(String SSO, String password, String firstname, String lastname,
			String track, /*float[][] profile,*/ String email,
			ArrayList<String> list, ArrayList<String> action, ArrayList<String> time, 
			String title, ArrayList<String> intend,
			ArrayList<String> deadline, ArrayList<String> joblist, 
			ArrayList<String> memberlist, String notes) {
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
		this.setIntend(intend);
		this.joblist = joblist;
		this.memberlist = memberlist;
		this.setNote(notes);
		this.setTimeline(time);

	}

	
	public static void setTitle(String title) {
		boolean isNull = false;
		try {
			title.equalsIgnoreCase(null);
		} catch (NullPointerException npe) {
			isNull = true;
		}
		if (!isNull) {
			BPM.title = title.trim().replaceAll(" ", "").toLowerCase();
		} else {
			System.err.println("Please input a title");
		}
	}

	public static String getTitle() {
		return BPM.title;
	}


	public static ArrayList<String> getMemberlist() {
		return memberlist;
	}

	public static void setMemberlist(ArrayList<String> memberlist) {
		BPM.memberlist = memberlist;
	}

	public static ArrayList<String> getJoblist() {
		return joblist;
	}

	public static void setJoblist(ArrayList<String> replace_list) {
		BPM.joblist = replace_list;
	}
	
	/*
	 * This is just example, this is not finished.
	 */
	public void readJSON(String filename) throws ParseException{
		JSONParser parser = new JSONParser();
		try(Reader reader = new FileReader(filename)){
			JSONObject bpm = (JSONObject) parser.parse(reader);
			this.setSSO((String) bpm.get("sso"));
			this.setFirstname((String) bpm.get("firstname"));
			this.setLastname((String) bpm.get("lastname"));
			this.setTrack((String) bpm.get("track"));
			Iterator<String> iter = null;
			ArrayList<String> replace_list = new ArrayList<String>();
			JSONArray temp_list = (JSONArray) bpm.get("todolist");
			if(temp_list == null) {
				System.out.println("todolist is null");
			}
			else {
				iter = temp_list.iterator();
				while(iter.hasNext()){
					replace_list.add(iter.next());
				}
				this.setTodolist(replace_list);
			}
			JSONArray temp_action = (JSONArray) bpm.get("action");
			if(temp_action == null) {
				System.out.println("action is null");
			}
			else {
				iter = temp_action.iterator();
				replace_list.clear();
				while(iter.hasNext()){
					replace_list.add(iter.next());
				}
				this.setAction(replace_list);
			}
			this.setTitle((String) bpm.get("title"));
			JSONArray temp_job = (JSONArray) bpm.get("joblist");
			if (temp_job == null) {
				System.out.println("joblist is null");
			}
			else {
				iter = temp_job.iterator();
				replace_list.clear();
				while(iter.hasNext()) {
					replace_list.add(iter.next());
				}
			/*this.setJoblist(replace_list);*/
			}
			JSONArray temp_member = (JSONArray) bpm.get("memberlist");
			if(temp_member == null) {
				System.out.println("memberlist is null");
			}
			else {
				iter = temp_member.iterator();
				replace_list.clear();
				while(iter.hasNext()) {
					replace_list.add(iter.next());
				}
			/*this.setMemberlist(replace_list);*/
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * This is just example, this is not finished.
	 */
	@SuppressWarnings("unchecked")
	public void writeJSON(String filename){
		 JSONObject bpm = new JSONObject();
		 bpm.put("type", "BPM");
		 bpm.put("sso", this.getSSO());
		 bpm.put("firstname", this.getFirstname());
		 bpm.put("lastname", this.getLastname());
		 bpm.put("track", this.getTrack());
		 bpm.put("email", BPM.getEmail());
		 JSONArray list = new JSONArray();
		 for (int i =0; i <this.getTodolist().size(); i++){
			 list.add(this.getTodolist().get(i));
		 }
		 bpm.put("todolist", list);
		 JSONArray action = new JSONArray();
		 for (int j =0; j <this.getAction().size(); j++){
			 action.add(this.getAction().get(j));
		 }
		 bpm.put("action", action);
		 bpm.put("title", this.getTitle());
		 
		 try(FileWriter file = new FileWriter(filename)){
			 file.write(bpm.toJSONString());
		 } catch(IOException e){
			 e.printStackTrace();
		 }
	}

	public static String getNote() {
		return note;
	}

	public static void setNote(String note) {
		BPM.note = note;
	}
}
