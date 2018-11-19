package vn.edu.poly.tuanltph04663.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.poly.tuanltph04663.dao.ProductsDAO;
import vn.edu.poly.tuanltph04663.model.Products;

/**
 * Servlet implementation class ControllerProducts
 */
public class ControllerProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerProducts() {
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

		try {
			String action = request.getParameter("action");
			if (action.equals("Delete")) {
				int idProducts = Integer.parseInt(request.getParameter("idProducts"));
				boolean xoa = ProductsDAO.XoaProducts(idProducts);
				if (xoa == true) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Views-QLWebsite/Products.jsp");
					dispatcher.forward(request, response);
				}
			}
			if (action.equals("Edit")) {
				int idProducts = Integer.parseInt(request.getParameter("idProducts"));
				Products sp = ProductsDAO.ThongTin(idProducts);
				request.setAttribute("update", sp);
				response.sendRedirect("/Website-BanHang/Views-QLWebsite/Update.jsp");
			}
			if (action.equals("Update")) {
				String hinhanhsp=request.getParameter("hinhanhsp");
				String tesp=request.getParameter("tensp");
				float giasp=Float.parseFloat(request.getParameter("giasp"));
	
				Products sp=new Products(hinhanhsp, tesp, giasp);
				
				boolean sua=ProductsDAO.UpdateTT(sp);
				if(sua==true){
					response.sendRedirect("/Website-BanHang/Views-QLWebsite/Products.jsp");
				}else{
					
					response.sendRedirect("http://google.com");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
