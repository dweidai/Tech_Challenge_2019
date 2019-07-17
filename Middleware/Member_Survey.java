import org.json.*;
public class Member_Survey extends Survey {
	private static String member;

	public Member_Survey() {
		super();
		member = "default";
	}

	public Member_Survey(String q1, String q2, String q3, String cur, String d,
			String m) {
		this.setQ1(q1);
		this.setQ2(q2);
		this.setQ3(q3);
		this.setCurrent(cur);
		this.setDepartment(d);
		this.setMember(m);
	}

	public static String getMember() {
		return member;
	}

	public static void setMember(String member) {
		Member_Survey.member = member;
	}

}
