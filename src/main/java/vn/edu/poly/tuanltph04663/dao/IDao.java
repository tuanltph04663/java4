package vn.edu.poly.tuanltph04663.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import vn.edu.poly.tuanltph04663.util.HibernateUtil;

public interface IDao<T> {

	public static final SessionFactory SESSION_FACTORY = HibernateUtil.getSessionFactory();

	public List<T> getAll();

	public T getById(int id);

	public void insert(T t);

	public void update(T t);

	public void delete(T t);
}
