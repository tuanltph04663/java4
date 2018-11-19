package vn.edu.poly.tuanltph04663.model;
// Generated Oct 21, 2017 1:18:00 PM by Hibernate Tools 5.1.0.Alpha1

import java.util.HashSet;
import java.util.Set;

/**
 * Account generated by hbm2java
 */
public class Account implements java.io.Serializable {

	private Integer idAccount;
	private String userName;
	private String passWord;
	private String email;
	private String type;
	private Set carts = new HashSet(0);

	public Account() {
	}

	public Account(String userName, String passWord, String email) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
	}

	public Account(String userName, String passWord, String email, String type, Set carts) {
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.type = type;
		this.carts = carts;
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

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
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

	public Set getCarts() {
		return this.carts;
	}

	public void setCarts(Set carts) {
		this.carts = carts;
	}

}
