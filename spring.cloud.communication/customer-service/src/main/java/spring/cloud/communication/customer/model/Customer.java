package spring.cloud.communication.customer.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private Long id;
	private String name;
	private CustomerType type;
	private List<Account> accounts = new ArrayList<>();
	
	public Customer() {
		
	}
	
	/**
	 * @param id
	 * @param name
	 * @param type
	 * @param accounts
	 */
	public Customer(Long id, String name, CustomerType type, List<Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.accounts = accounts;
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

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
