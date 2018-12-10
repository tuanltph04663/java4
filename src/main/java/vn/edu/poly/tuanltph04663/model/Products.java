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

	// product detail
	private String storge;
	private String weight;
	private String descrtiption;
	private String os;
	private String cpu;
	private String ram;
	private String color;

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

	public String getStorge() {
		return storge;
	}

	public void setStorge(String storge) {
		this.storge = storge;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDescrtiption() {
		return descrtiption;
	}

	public void setDescrtiption(String descrtiption) {
		this.descrtiption = descrtiption;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Products [idProducts=" + idProducts + ", categoryId=" + categoryId + ", image=" + image
				+ ", nameProduct=" + nameProduct + ", price=" + price + ", storge=" + storge + ", weight=" + weight
				+ ", descrtiption=" + descrtiption + ", os=" + os + ", cpu=" + cpu + ", ram=" + ram + ", color=" + color
				+ "]";
	}

}
