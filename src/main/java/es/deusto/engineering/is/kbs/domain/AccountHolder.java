package es.deusto.engineering.is.kbs.domain;

public class AccountHolder {

	private String name;
	private double balance;
	private boolean liable;
	private boolean guarantee;
	private boolean paysDeposit;

	public AccountHolder(String name) {
		super();
		this.name = name;
	}

	public AccountHolder(String name, double balance, boolean liable, boolean guarantee, boolean paysDeposit) {
		super();
		this.name = name;
		this.balance = balance;
		this.liable = liable;
		this.guarantee = guarantee;
		this.paysDeposit = paysDeposit;
	}

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean isGuarantee() {
		return guarantee;
	}

	public void setGuarantee(boolean guarantee) {
		this.guarantee = guarantee;
	}

	public boolean isPaysDeposit() {
		return paysDeposit;
	}

	public void setPaysDeposit(boolean paysDeposit) {
		this.paysDeposit = paysDeposit;
	}

	public boolean isLiable() {
		return liable;
	}

	public void setLiable(boolean liable) {
		this.liable = liable;
	}

	@Override
	public String toString() {
		return " is AccountHolder " + name + ", with balance " + balance
				+ ", liable " + liable + ", has guarantee " + guarantee
				+ ", will pay Deposit " + paysDeposit;
	}
}