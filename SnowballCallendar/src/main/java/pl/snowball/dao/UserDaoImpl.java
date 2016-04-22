package pl.snowball.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import pl.snowball.model.LoginCredentials;
import pl.snowball.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

	public User login(LoginCredentials loginCredentials) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

}
