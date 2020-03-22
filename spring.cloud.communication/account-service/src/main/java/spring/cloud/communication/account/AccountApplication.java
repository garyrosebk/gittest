package spring.cloud.communication.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import spring.cloud.communication.account.model.Account;
import spring.cloud.communication.account.repository.AccountRepository;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"spring.cloud.communication.account.repository"})
public class AccountApplication {

	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}
	
	@Bean
	AccountRepository repository() {
		AccountRepository repository = new AccountRepository();
		repository.add(new Account("1234567890", 5000, 1L));
		repository.add(new Account("1234567891", 5000, 1L));
		repository.add(new Account("1234567892", 0, 1L));
		repository.add(new Account("1234567893", 5000, 2L));
		repository.add(new Account("1234567894", 0, 2L));
		repository.add(new Account("1234567895", 5000, 2L));
		repository.add(new Account("1234567896", 0, 3L));
		repository.add(new Account("1234567897", 5000, 3L));
		repository.add(new Account("1234567898", 5000, 3L));
		return repository;
}
}
