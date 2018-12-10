package vn.edu.poly.tuanltph04663.controller.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.poly.tuanltph04663.dao.AccountDAO;
import vn.edu.poly.tuanltph04663.model.Account;

@WebServlet(urlPatterns = { "/login", "/logout" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountDAO accountDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		this.accountDAO = new AccountDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getServletPath().equals("/logout")) {
			// clear Account session
			request.getSession().removeAttribute("Account");

			response.sendRedirect("index");
			return;
		}
		request.getRequestDispatcher("/Views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Account account = accountDAO.checkLogin(username, password);

			/**
			 * if have no account in database return
			 */
			if (null == account) {
				doGet(request, response);
				return;
			}

			if (account.isValidUser(username, password)) {
				session.setAttribute("Account", username);

				// to index page
				response.sendRedirect("index");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
