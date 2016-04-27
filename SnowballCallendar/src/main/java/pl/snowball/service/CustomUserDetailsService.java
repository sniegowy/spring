package pl.snowball.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.model.User;
import pl.snowball.model.UserProfile;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) {
		User user = userService.findByUsername(username);
		if (user == null) {
            throw new UsernameNotFoundException("Username not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getLoginCredentials().getLogin(), 
				user.getLoginCredentials().getPassword(), user.getState().equals("Active"), 
				true, true, true, getGrantedAuthorities(user));
	}
	
	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		 for (UserProfile userProfile : user.getUserProfiles()) {
			 authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		 }
		 return authorities;
	}
}
