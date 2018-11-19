package vn.edu.poly.tuanltph04663.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import vn.edu.poly.tuanltph04663.model.Account;
import vn.edu.poly.tuanltph04663.util.HibernateUtil;

public class AccountDAO {

	public static final SessionFactory sf = HibernateUtil.getSessionFactory();

	
	//kiem tra đăng nhập
	
	public static Account checkLogin(String username){
		Session session = sf.openSession();
		try {
			session.beginTransaction();
			String hql="from Account tk where tk.userName like '"+username+"'";
			Query query=session.createQuery(hql);
			Account account= (Account) query.uniqueResult();
			return account;
		} catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
			
		}
	}
	public static void main(String[] args) {
		Account account=AccountDAO.checkLogin("NguyenVan");
		
			System.out.println(account.getPassWord());
		
	} 
}
