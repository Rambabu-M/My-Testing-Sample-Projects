package pojoClassPackage;

import java.util.List;

public class classOne {

	private String first_name;
	private String last_name;
	private String emial_id;
	private List skills;
		
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getEmial_id() {
		return emial_id;
	}
	public void setEmial_id(String emial_id) {
		this.emial_id = emial_id;
	}
	public List getSkills() {
		return skills;
	}
	public void setSkills(List skills) {
		this.skills = skills;
	}
}
