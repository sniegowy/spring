package pl.snowball.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.snowball.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Long, Customer> implements CustomerDao {

	@SuppressWarnings("unchecked")
	public Set<Customer> findAllCustomers() {
		Criteria criteria = createEntityCriteria();
		return new HashSet<Customer>(criteria.list());
	}

	public void deleteCustomer(Long customerId) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", customerId));
        Customer customer = (Customer)crit.uniqueResult();
        delete(customer);
	}

	public void addCustomer(Customer customer) {
		persist(customer);		
	}

}
