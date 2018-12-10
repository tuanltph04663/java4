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

@WebServlet(urlPatterns = { "/customerCreate" })
public class CustomerCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerCreate() {
		super();
		this.accountDAO = new AccountDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views-QLWebsite/customer_create.jsp");
		requestDispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String type = request.getParameter("type");

		Account accountToInsert = new Account();
		accountToInsert.setUserName(userName);
		accountToInsert.setPassword(password);
		accountToInsert.setEmail(email);
		accountToInsert.setType(type);

		accountDAO.insert(accountToInsert);

		// redirect to list customer page
		List<Account> accounts = accountDAO.getAll();
		request.setAttribute("accounts", accounts);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views-QLWebsite/customer.jsp");
		requestDispatcher.include(request, response);
	}

}
