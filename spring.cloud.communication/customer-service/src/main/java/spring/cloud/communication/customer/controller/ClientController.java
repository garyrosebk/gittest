package spring.cloud.communication.customer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spring.cloud.communication.customer.client.AccountClient;
import spring.cloud.communication.customer.model.Account;
import spring.cloud.communication.customer.model.Customer;
import spring.cloud.communication.customer.repository.CustomerRepository;

@RestController
public class ClientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	AccountClient accoutClient;
	
	@PostMapping
	public Customer add(@RequestBody Customer customer) {
		return repository.add(customer);
	}
	
	@PutMapping
	public Customer update(@RequestBody Customer customer) {
		return repository.update(customer);
	}
	
	@GetMapping("/id")
	public Customer findById(@PathVariable("id") Long id) {
		return repository.findById(id);
	}
	
	@GetMapping("/withAccounts/{id}")
	public Customer findByIdWithAccounts(@PathVariable("id") Long id) throws JsonProcessingException{
		List<Account> accounts = accoutClient.findByCustomer(id);
		LOGGER.info("Accounts found: {}", mapper.writeValueAsString(accounts));
		
		Customer c = repository.findById(id);
		c.setAccounts(accounts);
		
		return c;
	}
	
	@PostMapping("/ids")
	public List<Customer> find(@RequestBody List<Long> ids){
		return repository.find(ids);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		repository.delete(id);
	}
}
