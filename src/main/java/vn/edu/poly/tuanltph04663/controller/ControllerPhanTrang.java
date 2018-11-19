package vn.edu.poly.tuanltph04663.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.edu.poly.tuanltph04663.dao.ProductsDAO;
import vn.edu.poly.tuanltph04663.model.Products;

/**
 * Servlet implementation class ControllerPhanTrang
 */
public class ControllerPhanTrang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerPhanTrang() {
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
		try (PrintWriter out = response.getWriter()) {
			HttpSession session = request.getSession();
			List<Products> list = ProductsDAO.DanhSach();
			int start = 0;
			int end;
			if (list.size() < 12) {
				end = 6;
			} else {
				end = list.size();
			}

			if (request.getParameter("start") != null) {
				start = Integer.parseInt(request.getParameter("start"));
			}
			if (request.getParameter("end") != null) {
				end = Integer.parseInt(request.getParameter("end"));
			}
			List<Products> list1 = ProductsDAO.SoProducts(list, start, end);

			session.setAttribute("cart", list1);

			response.sendRedirect("/Assignment/Views/Shop.jsp");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
