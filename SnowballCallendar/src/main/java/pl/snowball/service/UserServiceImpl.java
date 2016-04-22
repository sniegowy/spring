package pl.snowball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.dao.UserDao;
import pl.snowball.model.LoginCredentials;
import pl.snowball.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;
	
	public User login(LoginCredentials loginCredentials) {
		return dao.login(loginCredentials);
	}
	
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}
}
