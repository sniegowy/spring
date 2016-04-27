package pl.snowball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.dao.UserDao;
import pl.snowball.model.LoginCredentials;
import pl.snowball.model.User;
import pl.snowball.model.UserProfile;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public User login(LoginCredentials loginCredentials) {
		return dao.login(loginCredentials);
	}
	
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public void saveUser(User user) {
		user.getLoginCredentials().setPassword(passwordEncoder.encode(user.getLoginCredentials().getPassword()));
		dao.saveUser(user);
	}

	public User findById(Long id) {
		return dao.findById(id);
	}

	public void updateUser(User user) {
		user.getLoginCredentials().setPassword(passwordEncoder.encode(user.getLoginCredentials().getPassword()));
		User entity = dao.findById(user.getId());
		if (entity != null) {
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.getLoginCredentials().setLogin(user.getLoginCredentials().getLogin());
			entity.getLoginCredentials().setPassword(user.getLoginCredentials().getPassword());
		}
	}

	public void deleteUserById(Long id) {
		dao.deleteUserById(id);
	}

	public User findByUsername(String username) {
		return dao.findByUsername(username);
	}

	public List<UserProfile> findUserProfiles() {
		return dao.findUserProfiles();
	}
}
