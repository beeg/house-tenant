package es.deusto.engineering.is.kbs.domain;

public class Occupation {

	public enum Type {
		STUDIES,
		EMPLOYMENT,
		VOLUNTEER_SERVICE
	}
	
	private int weeklyHours;
	private String company;
	private Type type;
	
	public Occupation(int weeklyHours, String company, Type type) {
		super();
		this.weeklyHours = weeklyHours;
		this.company = company;
		this.type = type;
	}


	//Getters and Setters
	public int getWeeklyHours() {
		return weeklyHours;
	}


	public void setWeeklyHours(int weeklyHours) {
		this.weeklyHours = weeklyHours;
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	@Override
	public String toString() {
		return "[weeklyHours=" + weeklyHours + ", company="
				+ company + ", type=" + type + "]";
	}
	
	
	
	
}
