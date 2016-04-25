package pl.snowball.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.snowball.model.LoginCredentials;
import pl.snowball.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {
	
	@SuppressWarnings("unchecked")
	public User login(LoginCredentials loginCredentials) {
		Criteria criteria = createEntityCriteria();
		criteria.createAlias("loginCredentials", "lc");
		criteria.add(Restrictions.eq("lc.login", loginCredentials.getLogin()));
		criteria.add(Restrictions.eq("lc.password", loginCredentials.getPassword()));
		List<User> result = criteria.list();
		if (!result.isEmpty()) {
			return result.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}

	public void saveUser(User user) {
		persist(user);
	}

	public User findById(Long id) {
        return getByKey(id);
	} 

	public void deleteUserById(Long id) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
        User user = (User)crit.uniqueResult();
        delete(user);
	}
}
