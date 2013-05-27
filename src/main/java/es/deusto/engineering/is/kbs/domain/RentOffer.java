package es.deusto.engineering.is.kbs.domain;

import java.util.ArrayList;
import java.util.List;

public class RentOffer {

	private int identifier;
	private double cost;
	private List<Adequacy> candidates;
	
	
	public RentOffer(int identifier, double cost) {
		super();
		this.identifier = identifier;
		this.cost = cost;
		this.candidates = new ArrayList<Adequacy>();
	}

	//Getters and Setters
	public int getIdentifier() {
		return identifier;
	}


	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public List<Adequacy> getCandidates() {
		return candidates;
	}


	public void setCandidates(List<Adequacy> candidates) {
		this.candidates = candidates;
	}
	
	public void addCandidate(Adequacy candidate)
	{
		this.candidates.add(candidate);
	}

	@Override
	public String toString() {
		return " identifier=" + identifier + ", cost=" + cost;
	}
	
	
	
	
}
