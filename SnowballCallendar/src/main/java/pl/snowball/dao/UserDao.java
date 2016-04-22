package pl.snowball.dao;

import java.util.List;

import pl.snowball.model.LoginCredentials;
import pl.snowball.model.User;

public interface UserDao {
	
	User login(LoginCredentials loginCredentials);
	List<User> findAllUsers();
}
