package spring.cloud.communication.account.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import spring.cloud.communication.account.model.Account;

public class AccountRepository {

	private List<Account> accounts = new ArrayList<>();
	
	public Account add(Account account) {
		account.setId((long) (accounts.size()+1));
		accounts.add(account);
		return account;
	}
	
	public Account update(Account account) {
		accounts.set(account.getId().intValue() -1, account);
		return account;
	}
	
	public Account findById(Long id) {
		Optional<Account> account = accounts.stream().filter(p->p.getId().equals(id)).findFirst();
		if(account.isPresent()) return account.get();
		else return null;
	}
	
	public void delete(Long id) {
		accounts.remove(id.intValue());
	}
	
	public List<Account> find(List<Long> ids){
		return accounts.stream().filter(p->ids.contains(p.getId())).collect(Collectors.toList());
	}
	
	public List<Account> findByCustomer(Long customerId){
		return accounts.stream().filter(p->p.getCustomerId().equals(customerId)).collect(Collectors.toList());
	}
}
