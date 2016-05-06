package pl.snowball.dao;

import java.util.Set;

import pl.snowball.model.Customer;

public interface CustomerDao {

	Set<Customer> findAllCustomers();

	void deleteCustomer(Long customerId);

	void addCustomer(Customer customer);

}
