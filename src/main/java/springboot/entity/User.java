package springboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
@NoArgsConstructor
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

	@Embedded
	private Adress adress;

	@OneToOne(cascade = CascadeType.ALL)
	private Family family;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_ıd ", referencedColumnName = "id")
	private Set<Child> childs = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(name = "users_and_books",
			joinColumns = {
							@JoinColumn(name = "user_id",referencedColumnName = "id")},
			inverseJoinColumns = {
							@JoinColumn(name = "book_id")})

	private Set<Book> books = new HashSet<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "users_id",referencedColumnName = "id")
	private Set<BankAccount>bankAccounts = new HashSet<>();

	public User(String firstName, String lastName, String email, Integer userAge, Adress adress, Family family, Set<Child> childs, Set<Book> books, Set<BankAccount> bankAccounts) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userAge = userAge;
		this.adress = adress;
		this.family = family;
		this.childs = childs;
		this.books = books;
		this.bankAccounts = bankAccounts;
	}
}
