package es.deusto.engineering.is.kbs.domain;

public class Adequacy {

	public enum Eligibility {
		ELIGIBLE, NON_ELIGIBLE, CONDITIONAL
	}

	public enum Income {
		SUFFICIENT, INSUFFICIENT
	}

	public enum Risk {
		LOW, MODERATE, HIGH
	}

	private PotentialTenant tenant;
	private RentOffer offer;
	private Eligibility decision;
	private Income income;
	private Risk damageRisk;
	private Risk nonpaymentRisk;

	public Adequacy(PotentialTenant tenant, RentOffer offer) {
		super();
		this.tenant = tenant;
		this.offer = offer;
		this.tenant.addOffer(this);
		this.offer.addCandidate(this);
	}

	// Getters and Setters
	public PotentialTenant getTenant() {
		return tenant;
	}

	public void setTenant(PotentialTenant tenant) {
		this.tenant = tenant;
	}

	public RentOffer getOffer() {
		return offer;
	}

	public void setOffer(RentOffer offer) {
		this.offer = offer;
	}

	public Eligibility getDecision() {
		return decision;
	}

	public void setDecision(Eligibility decision) {
		this.decision = decision;
	}

	public Income getIncome() {
		return income;
	}

	public void setIncome(Income income) {
		this.income = income;
	}

	public Risk getDamageRisk() {
		return damageRisk;
	}

	public void setDamageRisk(Risk damageRisk) {
		this.damageRisk = damageRisk;
	}

	public Risk getNonpaymentRisk() {
		return nonpaymentRisk;
	}

	public void setNonpaymentRisk(Risk nonpaymentRisk) {
		this.nonpaymentRisk = nonpaymentRisk;
	}

	@Override
	public String toString() {
		String findings = "\n\t\trent " + offer;
		// The following plays the role of a Safety Net
		if (income != null) {
			findings += "\n\t\t\tINCOME= " + income;
		}

		if (damageRisk != null) {
			findings += "\n\t\t\tDAMAGE RISK= " + damageRisk;
		}
		
		if (nonpaymentRisk != null) {
			findings += "\n\t\t\tNONPAYMENT RISK= " + nonpaymentRisk;
		}
		
		if (decision != null) {
			findings += "\n\t\t\tDECISION: TENANT IS " + decision;
		}

		return findings;
	}
}