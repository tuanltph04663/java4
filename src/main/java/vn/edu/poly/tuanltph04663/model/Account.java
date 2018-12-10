package vn.edu.poly.tuanltph04663.model;

public class Account implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer idAccount;
	private String userName;
	private String password;
	private String email;
	private String type;

	public Account() {
	}

	public Account(String userName, String password, String email) {
		this.userName = userName;
		this.password = password;
		this.email = email;
	}

	public Account(String userName, String password, String email, String type) {
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.type = type;
	}

	public Integer getIdAccount() {
		return this.idAccount;
	}

	public void setIdAccount(Integer idAccount) {
		this.idAccount = idAccount;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [idAccount=" + idAccount + ", userName=" + userName + ", password=" + password + ", email="
				+ email + ", type=" + type + "]";
	}

}
