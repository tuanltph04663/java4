package vn.edu.poly.tuanltph04663.model;

public class Cart implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int accountIdAccount;
	private Account account;

	public Cart() {
	}

	public Cart(int accountIdAccount, Account account) {
		this.accountIdAccount = accountIdAccount;
		this.account = account;
	}

	public int getAccountIdAccount() {
		return this.accountIdAccount;
	}

	public void setAccountIdAccount(int accountIdAccount) {
		this.accountIdAccount = accountIdAccount;
	}

	public Account getAccount() {
		return this.account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
