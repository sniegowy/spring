package pl.snowball.dao;

import java.util.List;

import pl.snowball.model.LoginCredentials;
import pl.snowball.model.User;
import pl.snowball.model.UserProfile;

public interface UserDao {
	
	User login(LoginCredentials loginCredentials);
	
	List<User> findAllUsers();
	
	void saveUser(User user);
	
	User findById(Long id);
	
	void deleteUserById(Long id);

	User findByUsername(String username);
	
	public List<UserProfile> findUserProfiles();
}
