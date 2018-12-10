package vn.edu.poly.tuanltph04663.controller.admin.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.poly.tuanltph04663.dao.AccountDAO;
import vn.edu.poly.tuanltph04663.model.Account;

@WebServlet(urlPatterns = { "/customer" })
public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Customer() {
		super();
		this.accountDAO = new AccountDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Account> accounts = accountDAO.getAll();
		request.setAttribute("accounts", accounts);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views-QLWebsite/customer.jsp");
		requestDispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
