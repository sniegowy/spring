package pl.snowball.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.dao.CustomerDao;
import pl.snowball.model.Customer;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerDao dao;

	public Set<Customer> findAllCustomers() {
		return dao.findAllCustomers();
	}

	public void deleteCustomer(Long customerId) {
		dao.deleteCustomer(customerId);
	}

	public void addCustomer(Customer customer) {
		dao.addCustomer(customer);
	}
}
