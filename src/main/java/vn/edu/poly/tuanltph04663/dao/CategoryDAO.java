package vn.edu.poly.tuanltph04663.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.edu.poly.tuanltph04663.model.Category;

public class CategoryDAO implements IDao<Category> {

	private static final String SELECT_ALL_QUERY = "FROM Category";

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {
		Session session = SESSION_FACTORY.openSession();
		List<Category> result = new ArrayList<>();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL_QUERY);
			result = (List<Category>) query.list();
			session.close();
			return result;

		} catch (Exception e) {
			System.out.println(e);
			return result;
		}
	}

	@Override
	public Category getById(int id) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			Category category = (Category) session.get(Category.class, id);
			session.close();
			return category;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public void insert(Category t) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			session.save(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void update(Category t) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			session.update(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e);
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	@Override
	public void delete(Category t) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			session.delete(t);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

}
