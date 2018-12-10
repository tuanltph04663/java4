package vn.edu.poly.tuanltph04663.test;

import vn.edu.poly.tuanltph04663.dao.AccountDAO;
import vn.edu.poly.tuanltph04663.model.Account;

public class AccountDAOTest {
	
	private static AccountDAO accountDao = new AccountDAO();
	
	private static void checkLoginTest() {
		Account account = accountDao.checkLogin("tuan", "matkhau");
		System.out.println(account);
	}

	public static void main(String[] args) {
		AccountDAOTest.checkLoginTest();
	}
}
