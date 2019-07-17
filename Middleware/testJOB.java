
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testJOB {
	Job job;
	final String DEFAULT = "default";
	@Test
	void setUp() throws Exception{
		job = new Job();
	}
	
	@Test
	void testDeclaration() {
		job = new Job();
		System.out.println("Testing JOB default settings");
		assertEquals(DEFAULT, job.getStartdate());
		assertEquals(DEFAULT, job.getEnddate());
		assertEquals(DEFAULT, job.getRoledescription());
		assertEquals(DEFAULT, job.getRolelocation());
		assertEquals(DEFAULT, job.getRolename());
		assertEquals(DEFAULT, job.getAL_sso());
		assertEquals("2031663622", job.getRid());
		assertEquals(DEFAULT, job.getAL_feedback());
		assertEquals(DEFAULT, job.getUpdatefield());
	}
	
	@Test
	void testSetJOB() {
		job = new Job();
		job.setStartdate("cafebabe");
		assertEquals("cafebabe", job.getStartdate());
		job.setEnddate("cafebabe");
		assertEquals("cafebabe", job.getEnddate());
		job.setRoledescription("cafebabe");
		assertEquals("cafebabe", job.getRoledescription());
		job.setRolelocation("cafebabe");
		assertEquals("cafebabe", job.getRolelocation());
		job.setRolename("cafebabe");
		assertEquals("cafebabe", job.getRolename());
		
		assertEquals(DEFAULT, job.getAL_sso());
		assertEquals("2031663622", job.getRid());
		assertEquals(DEFAULT, job.getAL_feedback());
		assertEquals(DEFAULT, job.getUpdatefield());
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("cafe");
		list.add("babe");
		ArrayList<String> action = new ArrayList<String>();
		action.add("cafe");
		action.add("babe");
		ArrayList<Job> joblist = new ArrayList<Job>();
		ArrayList<Member> memberlist = new ArrayList<Member>();
		String david = "123456789";
		job.setAL_sso(david);
		job.setRid(david);
		assertEquals("-167358638", job.getRid());
		assertEquals("123456789", job.getAL_sso());
	}
}
