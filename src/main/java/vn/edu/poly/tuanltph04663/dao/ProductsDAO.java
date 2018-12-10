package vn.edu.poly.tuanltph04663.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import vn.edu.poly.tuanltph04663.model.Products;

public class ProductsDAO implements IDao<Products> {

	private static final String SELECT_ALL_QUERY = "FROM Products";

	@SuppressWarnings("unchecked")
	@Override
	public List<Products> getAll() {
		Session session = SESSION_FACTORY.openSession();
		List<Products> result = new ArrayList<>();
		try {
			session.beginTransaction();
			Query query = session.createQuery(SELECT_ALL_QUERY);
			result = (List<Products>) query.list();
			session.close();
			return result;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public Products getById(int id) {
		Session session = SESSION_FACTORY.openSession();
		try {
			session.beginTransaction();
			Products result = (Products) session.get(Products.class, id);
			session.close();
			return result;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	@Override
	public void insert(Products t) {
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
	public void update(Products t) {
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
	public void delete(Products t) {
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
