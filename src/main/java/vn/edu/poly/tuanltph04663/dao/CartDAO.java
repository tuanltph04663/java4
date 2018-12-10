package vn.edu.poly.tuanltph04663.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.edu.poly.tuanltph04663.model.Order;
import vn.edu.poly.tuanltph04663.model.Detail;
import vn.edu.poly.tuanltph04663.model.Products;
import vn.edu.poly.tuanltph04663.util.HibernateUtil;

public class CartDAO {

	public static final SessionFactory sf = HibernateUtil.getSessionFactory();

	public static List<Detail> DanhSach() {
		Session session = sf.openSession();
		try {
			List<Detail> danhsach = null;
			session.beginTransaction();
			String hql = "from Detail";
			Query query = session.createQuery(hql);
			danhsach = query.list();

			return danhsach;

		} catch (Exception e) {
			System.out.println(e);

			return null;
		}

	}
	
	// them san pham vao gio hang
	public static boolean ThemCart(Detail ctgh) {
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(ctgh);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}

	}
	
	//them so luong hang da co
	public static void plusToCart(int idgh,int idsp ) {
		Session session = sf.openSession();
		try {
			Detail gh = CartDAO.ThongTinGH(idgh);
			if (gh != null) {
				boolean check = gh.getProducts().getIdProducts().equals(idsp);
				if (check) {
					System.out.println("Trung");
					System.out.println(gh.getQuality());
					gh.setQuality(gh.getQuality() + 1);
					session.beginTransaction();
					session.saveOrUpdate(gh);
					System.out.println(gh.getQuality());
					session.getTransaction().commit();
				}

			} else {


			}
		} catch (Exception e) {
			session.close();
			System.out.println(e);
		}

	}

	//Bot so luong hang da co
	public static void SubToCart(int idgh,int idsp ) {
		Session session = sf.openSession();
		try {
			Detail gh = CartDAO.ThongTinGH(idgh);

			if (gh != null) {
				boolean check = gh.getProducts().getIdProducts().equals(idsp);
				if (check) {
					System.out.println(gh.getQuality());
					gh.setQuality(gh.getQuality()- 1);
					session.beginTransaction();
					session.saveOrUpdate(gh);
					System.out.println(gh.getQuality());
					session.getTransaction().commit();
				}

			} else {


			}
		} catch (Exception e) {
			session.close();
			System.out.println(e);
		}

	}
	
	//Thông tin chi tiết gi�? hàng
	public static Detail ThongTinGH( int id) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			Detail gh = (Detail) session.get(Detail.class,id);
			session.close();
			return gh;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
	
	//Thong tin gio hang
	public static Order ThongTin(int id) {
		try {
			Session session = sf.openSession();
			session.beginTransaction();
			Order gh = (Order) session.get(Order.class, id);
			session.close();
			return gh;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	//thong tin san pham
	public static Products ThongTinsp(int id) {
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
	
	

	public static void main(String[] args) {

		plusToCart(1,1);

      
	}
}
