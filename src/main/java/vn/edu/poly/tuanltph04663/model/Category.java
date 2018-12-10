package vn.edu.poly.tuanltph04663.model;

public class Category implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCategory;
	private String nameCategory;

	public Category() {
	}

	public Category(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public Integer getIdCategory() {
		return this.idCategory;
	}

	public void setIdCategory(Integer idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return this.nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", nameCategory=" + nameCategory + "]";
	}

}
