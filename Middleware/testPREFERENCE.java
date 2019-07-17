
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testPREFERENCE {
	
	Preference prefer;
	@Test
	void setUp() throws Exception  {
		prefer = new Preference();
	}
	@Test
	void testDeclaration() {
		prefer = new Preference();
		assertEquals("default", prefer.getJob1());
		assertEquals("default", prefer.getJob2());
		assertEquals("default", prefer.getJob3());
		assertEquals("default", prefer.getNotes());
		assertEquals("default", prefer.getReason());
	}
	
	@Test
	void testSet() {
		String al = "cafebabe";
		Job job1 = new Job("cafebabe", "cafebabe", "cafebabe", "cafebabe", "cafebabe",
				"cafebabe", "cafebabe", al, "cafebabe");
		Job job2 = new Job("cafebabe", "cafebabe", "cafebabe", "cafebabe", "cafebabe",
				"cafebabe",  "cafebabe",al, "cafebabe");
		Job job3 = new Job("cafebabe", "cafebabe", "cafebabe", "cafebabe", "cafebabe",
				"cafebabe", "cafebabe", al, "cafebabe");
		prefer.setJob1(job1);
		prefer.setJob2(job2);
		prefer.setJob3(job3);
		assertEquals("cafebabe", prefer.getJob1().getRolename());
		assertEquals("cafebabe", prefer.getJob2().getRolename());
		assertEquals("cafebabe", prefer.getJob3().getRolename());
		assertEquals("cafebabe", prefer.getJob1().getRolelocation());
		assertEquals("cafebabe", prefer.getJob2().getRolelocation());
		assertEquals("cafebabe", prefer.getJob3().getRolelocation());
		prefer.setNotes("cafebabe");
		prefer.setReason("cafebabe");
		assertEquals("cafebabe", prefer.getNotes());
		assertEquals("cafebabe", prefer.getReason());
	}

}
