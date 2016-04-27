package pl.snowball.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="user_data")
public class User {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="login_credentials_id")
	private LoginCredentials loginCredentials;
	
	@Column
	@NotEmpty
	private String firstName;
	
	@Column
	@NotEmpty
	private String lastName;
	
	@Column
	private String state = UserState.ACTIVE.getState();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="user_data_user_profile", 
		joinColumns = {@JoinColumn(name = "user_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "user_profile_id")})
	private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
	
	public LoginCredentials getLoginCredentials() {
		return loginCredentials;
	}
	public void setLoginCredentials(LoginCredentials loginCredentials) {
		this.loginCredentials = loginCredentials;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Set<UserProfile> getUserProfiles() {
		return userProfiles;
	}
	public void setUserProfiles(Set<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}
}
