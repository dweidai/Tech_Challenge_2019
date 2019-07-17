import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class Testing_JSON_SIMPLE {

	public static void main(String[] args) {
		BPM bpm = new BPM();
		Member pm = new Member();
		AL al = new AL();
		System.out.println("Hello World");
		System.out.println(bpm.getFirstname());
		System.out.println(bpm.getLastname());
		
		
		File file = new File("/Users/apple/Desktop/giant_object.json");
		if(file.exists()) {
			System.out.println("this is the right pwd");
		}
		else {
			System.out.println("file non existed");
		}
		
		JSONParser parser = new JSONParser();
		Reader reader = null;
		try {
			reader = new FileReader("/Users/apple/Desktop/giant_object.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JSONObject jsonObject = null;
		try {
			jsonObject = (JSONObject) parser.parse(reader);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject);
		
		
		try {
			bpm.readJSON("/Users/apple/Desktop/giant_object.json");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(bpm.getFirstname());
		System.out.println(bpm.getLastname());
		System.out.println(bpm.getTodolist());
		
		bpm.setFirstname("Meat");
		bpm.setLastname("Mobile");
		
		bpm.writeJSON("/Users/apple/Desktop/giant_object(1).json");
		try {
			bpm.readJSON("/Users/apple/Desktop/giant_object(1).json");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(bpm.getFirstname());
		System.out.println(bpm.getLastname());
	}

}
