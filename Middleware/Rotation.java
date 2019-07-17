import java.util.ArrayList;
public class Rotation{
	private static String rolename;
	private static String rolelocation;
	private static String roledepartment;
	private static String past_experience;
	private static String mentor;
	private static String coleader;
	private static String travel;
	private static ArrayList<String> sub_areas;
	private static String roledescription;
	private static String additional;
	private static ArrayList<String> capabilities;
	private static String outcome;
	private static String status;
	private static String AL_sso;
	private static String BPM_sso;
	private static String RID;
	private static final String DEFAULT = "default";
	
	public Rotation() {
		this.setRID(DEFAULT);
		this.setRolename(DEFAULT);
		this.setRolelocation(DEFAULT);
		this.setRoledepartment(DEFAULT);
		this.setPast_experience(DEFAULT);
		this.setMentor(DEFAULT);
		this.setColeader(DEFAULT);
		this.setTravel(DEFAULT);
		this.sub_areas = new ArrayList<String>();
		this.setRoledescription(DEFAULT);
		this.setAdditional(DEFAULT);
		this.capabilities = new ArrayList<String>();
		this.setOutcome(DEFAULT);
		this.setStatus(DEFAULT);
		this.setAL_sso(DEFAULT);
		this.setBPM_sso(DEFAULT);
	}
	public Rotation(String rid, String rolename, String rolelocation, String roledepartment,
			String past_experience, String menter, String coleader, String travel,
			ArrayList<String> sub_areas, String description, String additional, 
			String capabilities, String outcome, String status, 
			String al, String BPM) {
		this.setRID(rid);
		this.setRolename(rolename);
		this.setRolelocation(rolelocation);
		this.setRoledepartment(roledepartment);
		this.setPast_experience(past_experience);
		this.setMentor(menter);
		this.setColeader(coleader);
		this.setTravel(travel);
		this.setSub_areas(sub_areas);
		this.setRoledescription(description);
		this.setAdditional(additional);
		this.setOutcome(outcome);
		this.setStatus(status);
		this.setAL_sso(al);
		this.setBPM_sso(BPM);
		
	}
	public static String getRolename() {
		return rolename;
	}
	public static void setRolename(String rolename) {
		Rotation.rolename = rolename;
	}
	public static String getRolelocation() {
		return rolelocation;
	}
	public static void setRolelocation(String rolelocation) {
		Rotation.rolelocation = rolelocation;
	}
	public static String getRoledepartment() {
		return roledepartment;
	}
	public static void setRoledepartment(String roledepartment) {
		Rotation.roledepartment = roledepartment;
	}
	public static String getPast_experience() {
		return past_experience;
	}
	public static void setPast_experience(String past_experience) {
		Rotation.past_experience = past_experience;
	}
	public static String getMentor() {
		return mentor;
	}
	public static void setMentor(String mentor) {
		Rotation.mentor = mentor;
	}
	public static String getColeader() {
		return coleader;
	}
	public static void setColeader(String coleader) {
		Rotation.coleader = coleader;
	}
	public static String getTravel() {
		return travel;
	}
	public static void setTravel(String travel) {
		Rotation.travel = travel;
	}
	public static ArrayList<String> getSub_areas() {
		return sub_areas;
	}
	public static void setSub_areas(ArrayList<String> sub_areas) {
		Rotation.sub_areas = sub_areas;
	}
	public static String getRoledescription() {
		return roledescription;
	}
	public static void setRoledescription(String description) {
		Rotation.roledescription = description;
	}
	public static String getAdditional() {
		return additional;
	}
	public static void setAdditional(String additional) {
		Rotation.additional = additional;
	}
	public static ArrayList<String> getCapabilities() {
		return capabilities;
	}
	public static void setCapabilities(ArrayList<String> capabilities) {
		Rotation.capabilities = capabilities;
	}
	public static String getOutcome() {
		return outcome;
	}
	public static void setOutcome(String outcome) {
		Rotation.outcome = outcome;
	}
	public static String getStatus() {
		return status;
	}
	public static void setStatus(String status) {
		Rotation.status = status;
	}
	public static String getAL_sso() {
		return AL_sso;
	}
	public static void setAL_sso(String aL_sso) {
		AL_sso = aL_sso;
	}
	public static String getBPM_sso() {
		return BPM_sso;
	}
	public static void setBPM_sso(String bPM_sso) {
		BPM_sso = bPM_sso;
	}
	public static String getRID() {
		return RID;
	}
	public static void setRID(String rID) {
		RID = rID;
	}
	
	
}
