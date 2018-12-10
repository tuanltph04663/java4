package vn.edu.poly.tuanltph04663.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.poly.tuanltph04663.dao.CartDAO;

/**
 * Servlet implementation class PlusToCartController
 */
public class PlusToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlusToCartController() {
		super();
		// TODO Auto-generated constructor stub
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
			String action = request.getParameter("add");
//			PrintWriter out = response.getWriter();
//			String email = request.getParameter("email");
//			String password = request.getParameter("password");
//			int idProducts = Integer.parseInt(request.getParameter("idProducts"));

			if (session.getAttribute("Account") == null) {
				response.sendRedirect("/Assignment/Views/Login.jsp");

			} else {
				if (action.equalsIgnoreCase("plus")) {
					int idsp = Integer.parseInt(request.getParameter("idProducts"));
					int idctgh = Integer.parseInt(request.getParameter("idDetail"));

					CartDAO.plusToCart(idctgh, idsp);
					response.sendRedirect("/Assignment/Views/Cart.jsp");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
