package vn.edu.poly.tuanltph04663.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.poly.tuanltph04663.dao.AccountDAO;
import vn.edu.poly.tuanltph04663.model.Account;

/**
 * Servlet implementation class CheckLogin
 */
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;
	
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckLogin() {
		super();
		this.accountDAO = new AccountDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = request.getSession();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Account account = accountDAO.checkLogin(username, password);
			
			/**
			 * if have no account in database return
			 */
			if (account == null) {
				return;
			}
			
			if (username.equals(account.getUserName()) && password.equals(account.getPassword())) {
				session.setAttribute("Account", username);
				response.sendRedirect("/Assignment/Views/Shop.jsp");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
