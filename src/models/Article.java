package models;

public class Article {
	
	private int id;
	private int category_id;
	private String name;
	private float price;
	private int qte;
	
	/**
	 * @param id
	 * @param categoryId
	 * @param name
	 * @param price
	 * @param qte
	 */
	public Article(int id, int categoryId, String name, float price, int qte) {
		super();
		this.id = id;
		category_id = categoryId;
		this.name = name;
		this.price = price;
		this.qte = qte;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the category_id
	 */
	public int getCategory_id() {
		return category_id;
	}

	/**
	 * @param categoryId the category_id to set
	 */
	public void setCategory_id(int categoryId) {
		category_id = categoryId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the qte
	 */
	public int getQte() {
		return qte;
	}

	/**
	 * @param qte the qte to set
	 */
	public void setQte(int qte) {
		this.qte = qte;
	}
	
}
