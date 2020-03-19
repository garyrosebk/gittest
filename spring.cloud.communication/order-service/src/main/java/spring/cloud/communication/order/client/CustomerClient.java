package spring.cloud.communication.order.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import spring.cloud.communication.order.model.Customer;

public interface CustomerClient {

	@GetMapping("/withAccounts/{customerId}")
		Customer findByIdWithAccounts(@PathVariable("customerId") Long customerId);
}
