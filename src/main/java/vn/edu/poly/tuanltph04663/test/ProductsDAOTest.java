package vn.edu.poly.tuanltph04663.test;

import java.util.Map;

import vn.edu.poly.tuanltph04663.dao.ProductsDAO;
import vn.edu.poly.tuanltph04663.model.Products;

public class ProductsDAOTest {
	private static ProductsDAO productDao = new ProductsDAO();

	private static void testAddProduct() {
		Products product = new Products(1, "NoImage.jpg", "Product test", Float.valueOf("10.0"));
		productDao.insert(product);
		System.out.println("Insert thanh cong!");
	}

	private static void testGetProductById() {
		int id = 16;
		Products product = productDao.getById(id);
		System.out.println(product);
	}

	private static void testUpdateProduct() {
		int id = 16;
		Products product = productDao.getById(id);
		product.setNameProduct("Product test updated");
		productDao.update(product);
		System.out.println(product);
	}

	private static void testDeleteProduct() {
		int id = 16;
		Products product = productDao.getById(id);
		productDao.delete(product);
		System.out.println("delete thanh cong!!!");
	}
	
	private static void testGetAllProduct() {
		Map<Integer, Products> result = productDao.getAll();
		result.entrySet().stream().forEach(System.out::println);
	}

	public static void main(String[] args) {
		ProductsDAOTest.testGetAllProduct();
	}
}
