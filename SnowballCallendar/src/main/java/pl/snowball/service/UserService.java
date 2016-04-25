package pl.snowball.service;

import java.util.List;

import pl.snowball.model.LoginCredentials;
import pl.snowball.model.User;

public interface UserService {
	
	User login(LoginCredentials loginCredentials);
	
	List<User> findAllUsers();
	
	void saveUser(User user);
	
	User findById(Long id);
	
	void updateUser(User user);
	
	void deleteUserById(Long id);
}
