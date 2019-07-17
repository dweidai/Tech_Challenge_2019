
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

class testingUSER {
	BPM bpm;
	Member pm;
	AL al;
	@Test
	void setUp() throws Exception {
		bpm = new BPM();
		pm = new Member();
		al = new AL();
	}
	
	@Test
	void testDefault() {
		bpm = new BPM();
		pm = new Member();
		al = new AL();
		System.out.println("Testing bpm, pm and al default settings");
		assertEquals("default", bpm.getSSO());
		assertEquals("default", pm.getSSO());
		assertEquals("default", al.getSSO());
		assertEquals("default", bpm.getPassword());
		assertEquals("default", pm.getPassword());
		assertEquals("default", al.getPassword());
		assertEquals("default", bpm.getFirstname());
		assertEquals("default", pm.getFirstname());
		assertEquals("default", al.getFirstname());
		assertEquals("default", bpm.getLastname());
		assertEquals("default", pm.getLastname());
		assertEquals("default", al.getLastname());
		assertEquals("default", bpm.getTrack());
		assertEquals("default", pm.getTrack());
		assertEquals("default", al.getTrack());
		assertEquals("default", bpm.getEmail());
		assertEquals("default", pm.getEmail());
		assertEquals("default", al.getEmail());
		assertEquals(0, bpm.getTodolist().size());
		assertEquals(0, bpm.getAction().size());
		assertEquals(0, pm.getTodolist().size());
		assertEquals(0, pm.getAction().size());
		assertEquals(0, al.getTodolist().size());
		assertEquals(0, al.getAction().size());
	}
	
	@Test
	void testSet() {
		bpm = new BPM();
		pm = new Member();
		al = new AL();
		bpm.setSSO("cafebabe");
		pm.setSSO("cafebabe");
		al.setSSO("cafebabe");
		assertEquals("cafebabe", bpm.getSSO());
		assertEquals("cafebabe", pm.getSSO());
		assertEquals("cafebabe", al.getSSO());
		bpm.setPassword("cafebabe");
		pm.setPassword("cafebabe");
		al.setPassword("cafebabe");
		assertEquals("cafebabe", bpm.getPassword());
		assertEquals("cafebabe", pm.getPassword());
		assertEquals("cafebabe", al.getPassword());
		bpm.setFirstname("cafebabe");
		pm.setFirstname("cafebabe");
		al.setFirstname("cafebabe");
		assertEquals("cafebabe", bpm.getFirstname());
		assertEquals("cafebabe", pm.getFirstname());
		assertEquals("cafebabe", al.getFirstname());
		bpm.setTrack("cafebabe");
		pm.setTrack("cafebabe");
		al.setTrack("cafebabe");
		assertEquals("cafebabe", bpm.getTrack());
		assertEquals("cafebabe", pm.getTrack());
		assertEquals("cafebabe", al.getTrack());
		bpm.setLastname("cafebabe");
		pm.setLastname("cafebabe");
		al.setLastname("cafebabe");
		assertEquals("cafebabe", bpm.getLastname());
		assertEquals("cafebabe", pm.getLastname());
		assertEquals("cafebabe", al.getLastname());
		bpm.setEmail("cafebabe");
		pm.setEmail("cafebabe");
		al.setEmail("cafebabe");
		assertEquals("cafebabe", bpm.getEmail());
		assertEquals("cafebabe", pm.getEmail());
		assertEquals("cafebabe", al.getEmail());
		ArrayList<String> temp = bpm.getTodolist();
		temp.add("cafebabe");
		bpm.setTodolist(temp);
		assertEquals("cafebabe", bpm.getTodolist().get(0));
		assertEquals(1, bpm.getTodolist().size());
		al.setTodolist(temp);
		assertEquals("cafebabe", al.getTodolist().get(0));
		assertEquals(1, al.getTodolist().size());
		pm.setTodolist(temp);
		assertEquals("cafebabe", pm.getTodolist().get(0));
		assertEquals(1, pm.getTodolist().size());
		temp.add("JOHN");
		bpm.setAction(temp);
		assertEquals("JOHN", bpm.getAction().get(1));
		assertEquals(2, bpm.getAction().size());
		pm.setAction(temp);
		assertEquals("JOHN", pm.getAction().get(1));
		assertEquals(2, pm.getAction().size());
		bpm.setAction(temp);
		assertEquals("JOHN", bpm.getAction().get(1));
		assertEquals(2, bpm.getAction().size());
		al.setAction(temp);
		assertEquals("JOHN", al.getAction().get(1));
		assertEquals(2, al.getAction().size());
		
	}
	
	@Test
	void testMember() {
		bpm = new BPM();
		ArrayList<String> list = new ArrayList<String>();
		list.add("cafe");
		list.add("babe");
		ArrayList<String> jlist = new ArrayList<String>();
		Member_Survey ms = new Member_Survey();
		Preference prefer = new Preference();
		pm = new Member("cafebabe", "cafebabe", "cafe", "babe", "cafebabe", "cafe@babe",
				list, list, list, list, list, "cafebabe", "cafebabe",  "cafebabe", "cafebabe", jlist, ms, prefer
				, "cafebabe");
		assertEquals("cafebabe", pm.getFeedback());
		assertEquals("cafebabe", pm.getBPM_SSO());
		assertEquals("cafebabe", pm.getHiredate());
		assertEquals("cafebabe", pm.getUniversity());
		assertEquals("cafebabe", pm.getMajor());
		assertEquals(0, pm.getJobs().size());
		assertEquals(2, pm.getTimeline().size());
		pm.setMajor("CS");
		assertEquals("CS", pm.getMajor());
		pm.setUniversity("SC");
		assertEquals("SC", pm.getUniversity());
		pm.setHiredate("2000-00-00");
		assertEquals("2000-00-00", pm.getHiredate());
		pm.setFeedback("Stupid");
		assertEquals("Stupid", pm.getFeedback());
	}
	
	
	@Test
	void testAL() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("cafe");
		list.add("babe");
		ArrayList<String> action = new ArrayList<String>();
		list.add("cafe");
		list.add("babe");
		ArrayList<String> joblist = new ArrayList<String>();
		ArrayList<String> memberlist = new ArrayList<String>();
		al = new AL("cafebabe", "cafebabe", "cafe", "babe", "cafebabe", "cafe@babe",
				list, action, list, list, joblist, memberlist, memberlist);
		assertEquals(0, al.getJoblist().size());
		assertEquals(0, al.getMemberlist().size());
		String j1 = "Job";
		String j2 = "Job";
		ArrayList<String> joblist2 = new ArrayList<String>();
		joblist2.add(j1);
		joblist2.add(j2);
		al.setJoblist(joblist2);
		assertEquals(2, al.getJoblist().size());
		ArrayList<String> memlist = new ArrayList<String>();
		memlist.add("m1");
		memlist.add("m2");
		al.setMemberlist(memlist);
		assertEquals(2, al.getMemberlist().size());
	}
	
	@Test
	void testBPM() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("cafe");
		list.add("babe");
		ArrayList<String> action = new ArrayList<String>();
		ArrayList<String> joblist = new ArrayList<String>();
		ArrayList<String> memberlist = new ArrayList<String>();
		bpm = new BPM("cafebabe", "cafebabe", "cafe", "babe", "cafebabe", "cafe@babe",
				list, list, memberlist, "cafebabe", list, list, joblist, memberlist, "cafebabe");
		assertEquals(2, bpm.getTodolist().size());
		assertEquals(2, bpm.getAction().size());
		bpm.setAction(action);
		bpm.setTodolist(action);
		assertEquals(0, bpm.getTodolist().size());
		assertEquals(0, bpm.getAction().size());
		assertEquals("cafebabe", bpm.getTitle());
		bpm.setTitle("yoshi");
		assertEquals("yoshi", bpm.getTitle());
		assertEquals(0, bpm.getJoblist().size());
		assertEquals(0, bpm.getMemberlist().size());
		ArrayList<String> joblist2 = new ArrayList<String>();
		joblist2.add("j1");
		joblist2.add("j2");
		bpm.setJoblist(joblist2);
		assertEquals(2, bpm.getJoblist().size());
		ArrayList<String> memlist = new ArrayList<String>();
		memlist.add("m1");
		memlist.add("m2");
		bpm.setMemberlist(memlist);
		assertEquals(2, bpm.getMemberlist().size());
	}
	
	

}
