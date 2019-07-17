
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class testROTATION {

	Rotation job;
	String DEFAULT = "default";
	@Test
	void setUp() throws Exception{
		job = new Rotation();
	}
		
	@Test
	void testDeclaration() {
		job = new Rotation();
		System.out.println("Testing JOB default settings");
		assertEquals(DEFAULT, job.getStatus());
		assertEquals(DEFAULT, job.getMentor());
		assertEquals(DEFAULT, job.getRoledescription());
		assertEquals(DEFAULT, job.getRolelocation());
		assertEquals(DEFAULT, job.getRolename());
		assertEquals(DEFAULT, job.getAL_sso());
		assertEquals(DEFAULT, job.getColeader());
		assertEquals(DEFAULT, job.getRoledepartment());
		assertEquals(DEFAULT, job.getPast_experience());
		assertEquals(0, job.getCapabilities().size());
	}
		
	@Test
	void testSetROTATION() {
		String DEFAULT = " ";
		job = new Rotation();
		job.setRolename(DEFAULT);
		job.setRolelocation(DEFAULT);
		job.setRoledepartment(DEFAULT);
		job.setPast_experience(DEFAULT);
		job.setMentor(DEFAULT);
		job.setColeader(DEFAULT);
		job.setTravel(DEFAULT);
		job.setSub_areas(null);
		job.setRoledescription(DEFAULT);
		job.setAdditional(DEFAULT);
		job.setCapabilities(null);
		job.setOutcome(DEFAULT);
		job.setStatus(DEFAULT);
		job.setAL_sso(DEFAULT);
		job.setBPM_sso(DEFAULT);
		assertEquals(" ", job.getStatus());
		assertEquals(" ", job.getMentor());
		assertEquals(" ", job.getRoledescription());
		assertEquals(" ", job.getRolelocation());
		assertEquals(" ", job.getRolename());
		assertEquals(" ", job.getAL_sso());
		assertEquals(" ", job.getColeader());
		assertEquals(" ", job.getRoledepartment());
		assertEquals(" ", job.getPast_experience());
	}

}
