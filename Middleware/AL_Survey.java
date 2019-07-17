
public class AL_Survey extends Survey {

	private static String member;

	public AL_Survey() {
		super();
		this.member = "default";
	}

	public AL_Survey(String q1, String q2, String q3, String cur, String d,
			String r) {
		this.setQ1(q1);
		this.setQ2(q2);
		this.setQ3(q3);
		this.setCurrent(cur);
		this.setDepartment(d);
		this.setMember(r);
	}

	public static String getMember() {
		return AL_Survey.member;
	}

	public static void setMember(String r) {
		AL_Survey.member = r;
	}

}
