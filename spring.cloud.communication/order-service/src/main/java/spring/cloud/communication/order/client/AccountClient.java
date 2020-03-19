package spring.cloud.communication.order.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import spring.cloud.communication.order.model.Account;

public interface AccountClient {

	@PutMapping("withdraw/{accountId}/{amount}")
	Account withdraw(@PathVariable("accountID") Long id, @PathVariable("amount") int amount);
}
