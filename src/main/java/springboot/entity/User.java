package springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;

	@Column(name = "user_age")
	private Integer userAge;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_ıd ", referencedColumnName = "id")
	private Set<Child> childs = new HashSet<>();

	public User() {
		
	}
	
	public User(String firstName, String lastName, String email,Integer userAge) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userAge = userAge;

	}
}
