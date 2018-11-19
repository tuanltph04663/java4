/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.poly.tuanltph04663.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.edu.poly.tuanltph04663.model.Products;
import vn.edu.poly.tuanltph04663.util.HibernateUtil;

public class ProductsDAO {


	/**
	 *
	 */
	public static final SessionFactory sf = HibernateUtil.getSessionFactory();

	// Lấy toàn bộ sản phẩm
	public static List<Products> DanhSach() {
		Session session = sf.openSession();
		try {
			List<Products> danhsach = null;

			session.beginTransaction();
			String hql = "from Products";
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

	public static Products ThongTin(int id) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			Products dt = (Products) session.get(Products.class, id);
			session.close();
			return dt;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	// thêm sản phẩm

	public static boolean ThemProducts(Products dt) {
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

	public static boolean UpdateTT(Products sp) {
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

	public static boolean XoaProducts(int id) {
		Session session = sf.openSession();
		Products dt = ProductsDAO.ThongTin(id);
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
	public static List<Products> SoProducts(List<Products> list, int n, int m) {
		try {

			List<Products> result = new ArrayList<>();
			for (int i = n; i < m; i++) {
				result.add(list.get(i));
			}
			return result;
		} catch (Exception e) {
			return null;
		}

	}

	public static List<Products> SoProducts(int n, int m) {
		try {

			List<Products> danhsach = null;
			Session session = sf.openSession();
			session.beginTransaction();
			String hql = "from Products";
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
		try {

			List<Products> list=ProductsDAO.SoProducts(0, 6);
			for (Products Products : list) {
				System.out.println(Products.getNameProduct());
			}
		} catch (Exception e) {
			System.out.println(e);
		}


	}
}
