package pl.snowball.service;

import java.util.Set;

import pl.snowball.model.Customer;

public interface CustomerService {

	Set<Customer> findAllCustomers();
	
	void deleteCustomer(Long customerId);
	
	void addCustomer(Customer customer);
}
