
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testSURVEY {
	
	AL_Survey as;
	Member_Survey ms;
	@Test
	void setUp() throws Exception  {
		as = new AL_Survey();
		ms = new Member_Survey();
	}

	@Test
	void testSurvey() {
		as = new AL_Survey();
		ms = new Member_Survey();
		assertEquals("default", as.getQ1());
		assertEquals("default", as.getQ2());
		assertEquals("default", as.getQ3());
		assertEquals("default", as.getCurrent());
		assertEquals("default", ms.getQ1());
		assertEquals("default", ms.getQ2());
		assertEquals("default", ms.getQ3());
		assertEquals("default", ms.getCurrent());
	}
	
	@Test
	void testSetSurvey() {
		as = new AL_Survey();
		ms = new Member_Survey();
		as.setDepartment(null);
		ms.setDepartment(null);
		assertEquals(null, as.getDepartment());
		assertEquals(null, ms.getDepartment());
		Job job = new Job();
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
		String j = "cafebabe";
		as.setCurrent(j);
		assertEquals("cafebabe", as.getCurrent());
		ms.setCurrent(j);
		assertEquals("cafebabe", ms.getCurrent());
		as.setQ1("cafebabe");
		as.setQ2("cafebabe");
		as.setQ3("cafebabe");
		ms.setQ1("cafebabe");
		ms.setQ2("cafebabe");
		ms.setQ3("cafebabe");
		assertEquals("cafebabe", as.getQ1());
		assertEquals("cafebabe", as.getQ2());
		assertEquals("cafebabe", as.getQ3());
		assertEquals("cafebabe", ms.getQ1());
		assertEquals("cafebabe", ms.getQ2());
		assertEquals("cafebabe", ms.getQ3());
	}
	
	@Test
	void testMemberSurvey() {
		ms = new Member_Survey();
		assertEquals("default", ms.getMember());
		assertEquals("default", ms.getMember());
		BPM bpm = new BPM();
		ArrayList<String> list = new ArrayList<String>();
		list.add("cafe");
		list.add("babe");
		ArrayList<String> jlist = new ArrayList<String>();
		Member_Survey ks = new Member_Survey();
		Preference prefer = new Preference();
		Member m = new Member("cafebabe", "cafebabe", "cafe", "babe", "cafebabe", "cafe@babe",
				list, list, list, list, list, "cafebabe", "cafebabe",  "cafebabe", "cafebabe", jlist, ms, prefer
				, "cafebabe");
		String m1 = "cafebabe";
		ms.setMember(m1);
		assertEquals("cafebabe", ms.getMember());
	}
	
	@Test
	void testALSurvey() {
		as = new AL_Survey();
		assertEquals("default", as.getMember());
		assertEquals("default", as.getMember());
		BPM bpm = new BPM();
		ArrayList<String> list = new ArrayList<String>();
		list.add("cafe");
		list.add("babe");
		ArrayList<String> jlist = new ArrayList<String>();
		Member_Survey ms = new Member_Survey();
		Preference prefer = new Preference();
		Member m = new Member("cafebabe", "cafebabe", "cafe", "babe", "cafebabe", "cafe@babe",
				list, list, list, list, list, "cafebabe", "cafebabe",  "cafebabe", "cafebabe", jlist, ms, prefer
				, "cafebabe");
		String m1 = "cafebabe";
		as.setMember(m1);
		assertEquals("cafebabe", as.getMember());
	}
	
}
