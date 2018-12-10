package vn.edu.poly.tuanltph04663.controller.admin.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.poly.tuanltph04663.dao.CategoryDAO;
import vn.edu.poly.tuanltph04663.dao.ProductsDAO;
import vn.edu.poly.tuanltph04663.model.Category;
import vn.edu.poly.tuanltph04663.model.Products;

@WebServlet(urlPatterns = { "/productUpdate" })
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductsDAO productsDAO;
	private CategoryDAO categoryDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductUpdate() {
		super();
		this.productsDAO = new ProductsDAO();
		this.categoryDAO = new CategoryDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Products productToUpdate = productsDAO.getById(id);
		List<Category> categories = categoryDAO.getAll();
		
		request.setAttribute("productToUpdate", productToUpdate);
		request.setAttribute("categories", categories);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views-QLWebsite/product_update.jsp");
		requestDispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idProducts"));
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String image = request.getParameter("image");
		String nameProduct = request.getParameter("nameProduct");
		float price = Float.parseFloat(request.getParameter("price"));
		
		Products productToUpdate = productsDAO.getById(id);
		productToUpdate.setCategoryId(categoryId);
		productToUpdate.setImage(image);
		productToUpdate.setNameProduct(nameProduct);
		productToUpdate.setPrice(price);
		
		productsDAO.update(productToUpdate);
		
		// redirect to list product page
		List<Products> products = productsDAO.getAll();
		request.setAttribute("products", products);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Views-QLWebsite/product.jsp");
		requestDispatcher.include(request, response);
	}

}
