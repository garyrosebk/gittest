package spring.cloud.communication.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import spring.cloud.communication.customer.config.RibbonConfiguration;
import spring.cloud.communication.customer.model.Customer;
import spring.cloud.communication.customer.model.CustomerType;
import spring.cloud.communication.customer.repository.CustomerRepository;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan({"spring.cloud.comunication.customer.repository"})
@RibbonClient(name = "account-service", configuration = RibbonConfiguration.class)
public class CustomerApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);

	}
	
	@Bean
	CustomerRepository repository() {
		CustomerRepository repository = new CustomerRepository();
		repository.add(new Customer("John Scott", CustomerType.NEW));
		repository.add(new Customer("Adam Smith", CustomerType.REGULAR));
		repository.add(new Customer("Jacob Ryan", CustomerType.VIP));
		return repository;
	}
}
