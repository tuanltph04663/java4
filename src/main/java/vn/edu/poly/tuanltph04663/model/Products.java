package vn.edu.poly.tuanltph04663.model;

public class Products implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idProducts;
	private Integer categoryId;
	private String image;
	private String nameProduct;
	private float price;

	public Products() {
	}

	public Products(Integer categoryId, String image, String nameProduct, float price) {
		this.categoryId = categoryId;
		this.image = image;
		this.nameProduct = nameProduct;
		this.price = price;
	}

	public Products(String image, String nameProduct, float price) {

		this.image = image;
		this.nameProduct = nameProduct;
		this.price = price;
	}

	public Integer getIdProducts() {
		return this.idProducts;
	}

	public void setIdProducts(Integer idProducts) {
		this.idProducts = idProducts;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNameProduct() {
		return this.nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public String toString() {
		return "Products [idProducts=" + idProducts + ", categoryId=" + categoryId + ", image=" + image
				+ ", nameProduct=" + nameProduct + ", price=" + price + "]";
	}

}
