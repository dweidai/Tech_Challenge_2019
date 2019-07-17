package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.json.simple.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController 
public class BackEndController {

	//Get the SSO and password after the user logs in.
	@RequestMapping(method=RequestMethod.POST, produces={MediaType.APPLICATION_JSON_VALUE})
	public JSONObject recieveSSO(@RequestBody JSONObject userJSON) { 
		//For now: Print out what the front end sent
		System.out.println(userJSON);
		
		//With the SSO and password, figure out what type of user it is and send it to front end
		
		//For now: hard coded a type to send to front end 
		JSONObject test = new JSONObject();
		test.put("type", "BPM");
		return test;
	}
	
	//Send all information needed to populate the BPM home page when it opens
	@RequestMapping(method=RequestMethod.GET,value="/bpm-home", produces={MediaType.APPLICATION_JSON_VALUE})
	public JSONObject send_BPM_details() {
		//For now: hardcoded data 
		//pms_1 = {name, position, location, date hired, other info, role description}
		JSONObject program_member = new JSONObject();
		program_member.put("name", "Saranya");
		program_member.put("track", "IT");
		program_member.put("position", "position");
		program_member.put("location", "Chicago");
		program_member.put("hiredate", "2/2/2018");
		program_member.put("info", "info");
		program_member.put("description",  "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		
		JSONObject program_member2 = new JSONObject();
		program_member2.put("name", "Bailey");
		program_member2.put("track", "IT");
		program_member2.put("position", "position");
		program_member2.put("location", "Chicago");
		program_member2.put("hiredate", "2/2/2018");
		program_member2.put("info", "info");
		program_member2.put("description",  "Lorem ipsum dolor sit amet, cons");
		
		JSONObject[] pms_1 = {program_member,program_member};
		JSONObject[] pms_2 = {program_member,program_member2};
		JSONObject[] pms_3 = {program_member,program_member};
		JSONObject[] pms_4 = {program_member2,program_member};

		String[] todo = {"Send surveys", "Submit Rotations"};
		String[] timeline = {"6/7 rotations released", "7/15 Submit Rotations"};

		JSONObject BPM_Data = new JSONObject();
		BPM_Data.put("first_rotation", pms_1);
		BPM_Data.put("second_rotation", pms_2);
		BPM_Data.put("third_rotation", pms_3);
		BPM_Data.put("fourth_rotation", pms_4);
		BPM_Data.put("todolist", todo);
		BPM_Data.put("timeline", timeline);
		System.out.print("h");
		System.out.print(BPM_Data);
		return BPM_Data;
	}
	
	/*
	 * @RequestMapping(method=RequestMethod.GET,value="/bpm-home") public String
	 * send_pm_by_rotation(@RequestBody String userJSON) { //Call function to query
	 * database with the sso in the userJSON //and the rotation number
	 * System.out.println(userJSON); return "hi"; }
	 * 
	 * @RequestMapping(method=RequestMethod.POST,value="/al-home") public String
	 * test(@RequestBody JSONObject rotationNumber) { return "hi"; }
	 */
	/*
	 * //home page to do list populating
	 * 
	 * @RequestMapping(method=RequestMethod.GET, value="bpm/home/todo") public
	 * jsonObject bpm_home_todo { //get information from java object, write it to w
	 * new json object return// new json object }
	 */
	
}
