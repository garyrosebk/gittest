package spring.cloud.communication.order.client;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import spring.cloud.communication.order.model.Product;

public interface ProductClient {

	@PostMapping("/ids")
		List<Product> findByIds(List<Long> ids);
	
}
