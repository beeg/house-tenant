package es.deusto.engineering.is.kbs.domain;

import java.util.ArrayList;
import java.util.List;

public class PotentialTenant extends AccountHolder{
	

	public enum OccupationProfile {
		FULL_TIME_STUDENT,
		PART_TIME_STUDENT_EMPLOYEE,
		FULL_TIME_EMPLOYEE,
		PART_TIME_STUDENT_SEVERAL_CTRS,
		PART_TIME_EMPLOYEE_SEVERAL_COMPANIES
	}
	
	
	private boolean hasChildrenUnderFour;
	private boolean hasDog;
	private AccountHolder family;
	private List<Occupation> occupations;
	private List<Adequacy> offers;
	private OccupationProfile profile;
	
	
	public PotentialTenant(String name, boolean hasChildrenUnderFour,
			boolean hasDog) {
		super(name);
		this.hasChildrenUnderFour = hasChildrenUnderFour;
		this.hasDog = hasDog;
		//by default the potential tenant is always liable
		this.setLiable(true);
		this.occupations = new ArrayList<Occupation>();
		this.offers = new ArrayList<Adequacy>();
	}


	//Getters and Setters
	
	public boolean isHasChildrenUnderFour() {
		return hasChildrenUnderFour;
	}


	public void setHasChildrenUnderFour(boolean hasChildrenUnderFour) {
		this.hasChildrenUnderFour = hasChildrenUnderFour;
	}


	public boolean isHasDog() {
		return hasDog;
	}


	public void setHasDog(boolean hasDog) {
		this.hasDog = hasDog;
	}


	public AccountHolder getFamily() {
		return family;
	}


	public void setFamily(AccountHolder family) {
		this.family = family;
	}


	public List<Occupation> getOccupations() {
		return occupations;
	}


	public void setOccupations(List<Occupation> occupations) {
		this.occupations = occupations;
	}

	public void addOccupation(Occupation oc)
	{
		this.occupations.add(oc);
	}

	public List<Adequacy> getOffers() {
		return offers;
	}


	public void setOffers(List<Adequacy> offers) {
		this.offers = offers;
	}
	
	public void addOffer(Adequacy offer)
	{
		this.offers.add(offer);
	}


	public OccupationProfile getProfile() {
		return profile;
	}


	public void setProfile(OccupationProfile profile) {
		this.profile = profile;
	}
	


	@Override
	public String toString() {
		
		String answer = "Potential Tenant: " + this.getName();		
		answer += "\n\t hasChildrenUnderFour: " + hasChildrenUnderFour;
		answer += "\n\t hasDog: " + hasDog;
		answer += "\n\t account balance = " + this.getBalance();
		answer += "\n\t has guarantee: " + this.isGuarantee();
		answer += "\n\t will pay deposit: " + this.isPaysDeposit();
		answer += "\n\n\t family " + family;
		answer += "\n\n\t occupations: " + occupations;
		if(profile != null)
		{
			answer += "\n\n\t PROFILE " + profile;
		
		}
		answer += "\n\n\t offers: " + offers;
		
		
		return answer;
	}
	
	

	
}
