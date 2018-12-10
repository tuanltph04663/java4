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
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        this.accountDAO = new AccountDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Account account = new Account(username, password, email);
		accountDAO.insert(account);
		boolean isSuccess = accountDAO.getByUsername(username) == null ? false : true;
		
		if (isSuccess) {
			session.setAttribute("Account", account.getUserName());
			response.sendRedirect("/Assignment/Views/Shop.jsp");
			return;
		} 
		
		response.sendRedirect("/Assignment/Views/Login.jsp");
	}

}
