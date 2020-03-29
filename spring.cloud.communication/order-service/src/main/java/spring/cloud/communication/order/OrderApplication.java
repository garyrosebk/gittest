package spring.cloud.communication.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import spring.cloud.communication.order.repository.OrderRepository;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"spring.cloud.communication.order.repository"})
@RibbonClients({
	@RibbonClient(name = "account-service"),
	@RibbonClient(name = "customer-service"),
	@RibbonClient(name = "product-service")
})
public class OrderApplication {
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);

	}
	
	@Bean
	OrderRepository repository() {
		return new OrderRepository();
	}
}
