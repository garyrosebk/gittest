package spring.cloud.communication.product.model;

public class Product {

	private Long id;
	private String name;
	private int price;
	
	public Product() {
		
	}
	
	public Product(Long id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}