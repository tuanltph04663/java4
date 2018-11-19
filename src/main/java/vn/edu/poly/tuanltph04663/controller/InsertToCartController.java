package vn.edu.poly.tuanltph04663.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.poly.tuanltph04663.dao.CartDAO;
import vn.edu.poly.tuanltph04663.dao.ProductsDAO;
import vn.edu.poly.tuanltph04663.model.Cart;
import vn.edu.poly.tuanltph04663.model.Detail;
import vn.edu.poly.tuanltph04663.model.Products;

/**
 * Servlet implementation class InsertToCartController
 */
public class InsertToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertToCartController() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		try {
			PrintWriter out=response.getWriter();
			HttpSession session = request.getSession();
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String action = request.getParameter("add");
			int idProducts = Integer.parseInt(request.getParameter("idProducts"));
			
			if (session.getAttribute("Account") == null) {
				response.sendRedirect("/Assignment/Views/Login.jsp");

			} else {
				if(action.equalsIgnoreCase("insert")){
					Products sp=ProductsDAO.ThongTin(idProducts);
					Cart cart=CartDAO.ThongTin(1);
					Detail ctgh=new Detail(cart, sp, 1);
					
					CartDAO.ThemCart(ctgh);
					response.sendRedirect("/Assignment/Views/Cart.jsp");
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
