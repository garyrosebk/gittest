package spring.cloud.communication.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import spring.cloud.communication.product.model.Product;
import spring.cloud.communication.product.repository.ProductRepository;


@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"spring.cloud.communication.product.repository"})
@RibbonClients({
	@RibbonClient(name = "account-service"),
	@RibbonClient(name = "customer-service"),
	@RibbonClient(name = "product-service")
})
public class ProductApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);

	}
	
	@Bean
	ProductRepository repository() {
		ProductRepository repository = new ProductRepository();
		repository.add(new Product("Test1", 1000));
		repository.add(new Product("Test2", 1500));
		repository.add(new Product("Test3", 2000));
		repository.add(new Product("Test4", 3000));
		repository.add(new Product("Test5", 1300));
		repository.add(new Product("Test6", 2700));
		repository.add(new Product("Test7", 3500));
		repository.add(new Product("Test8", 1250));
		repository.add(new Product("Test9", 2450));
		repository.add(new Product("Test10", 800));
		return repository;
	}
}
