package vn.edu.poly.tuanltph04663.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.edu.poly.tuanltph04663.model.Account;

public class AccountDAO implements IDao<Account> {

	private static final String CHECK_LOGIN_QUERY = "FROM Account a" 
			+ " WHERE a.userName LIKE :userName"
			+ " AND a.password LIKE :password";
	
	private static final String GET_BY_USERNAME = "FROM Account a"
			+ " WHERE a.userName";

	private static final String SELECT_ALL_QUERY = "FROM Account";

	public Account checkLogin(String userName, String password) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(CHECK_LOGIN_QUERY);
			query.setString("userName", userName);
			query.setString("password", password);
			Account account = (Account) query.uniqueResult();
			return account;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getAll() {
		Session session = SESSION_FACTORY.openSession();
		List<Account> result = new ArrayList<>();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL_QUERY);
			result = (List<Account>) query.list();
			session.close();
			return result;

		} catch (Exception e) {
			System.out.println(e);
			return result;
		}
	}
	
	public Account getByUsername(String username) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			Query query = session.createQuery(GET_BY_USERNAME);
			query.setParameter("username", username);
			Account account = (Account) query.uniqueResult();
			session.close();
			return account;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Account getById(int id) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			Account account = (Account) session.get(Account.class, id);
			session.close();
			return account;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public void insert(Account t) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void update(Account t) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void delete(Account t) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
