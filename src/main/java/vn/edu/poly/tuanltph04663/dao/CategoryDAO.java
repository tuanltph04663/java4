package vn.edu.poly.tuanltph04663.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.edu.poly.tuanltph04663.model.Category;
import vn.edu.poly.tuanltph04663.util.HibernateUtil;

public class CategoryDAO {

	public static final SessionFactory sf = HibernateUtil.getSessionFactory();

	// Lấy toàn bộ sản phẩm
	public static List<Category> DanhSach() {
		Session session = sf.openSession();
		try {
			List<Category> danhsach = null;

			session.beginTransaction();
			String hql = "from Category";
			Query query = session.createQuery(hql);
			danhsach = query.list();
			session.close();
			return danhsach;

		} catch (Exception e) {
			System.out.println(e);

			return null;
		}

	}
	// lấy thông tin chi tiết của 1 sản phẩm

	public static Category ThongTin(int id) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			Category dt = (Category) session.get(Category.class, id);
			session.close();
			return dt;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	// thêm sản phẩm

	public static boolean ThemCategory(Category dt) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.save(dt);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}
	// sửa thông tin sản phẩm

	public static boolean UpdateTT(Category sp) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.update(sp);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}
	// xóa sản phẩm

	public static boolean XoaCategory(int id) {
		Session session = sf.openSession();
		Category dt = CategoryDAO.ThongTin(id);
		if (dt == null) {
			return false;
		}
		try {
			session.beginTransaction();
			session.delete(dt);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	}

	// lấy số sản phẩm tính từ
	public static List<Category> SoCategory(List<Category> list, int n, int m) {
		try {

			List<Category> result = new ArrayList<>();
			for (int i = n; i < m; i++) {
				result.add(list.get(i));
			}
			return result;
		} catch (Exception e) {
			return null;
		}

	}

	public static List<Category> SoCategory(int n, int m) {
		try {

			List<Category> danhsach = null;
			Session session = sf.openSession();
			session.beginTransaction();
			String hql = "from Category";
			Query query = session.createQuery(hql);
			query.setFirstResult(n);
			query.setMaxResults(m);
			danhsach = query.list();
			session.close();
			return danhsach;

		} catch (Exception e) {
			return null;
		}

	}
	
	
	public static void main(String[] args) {
		List<Category> categeo=CategoryDAO.DanhSach();
	
	}

}
