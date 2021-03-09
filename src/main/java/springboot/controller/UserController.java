package springboot.controller;

import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.entity.User;
import springboot.exception.ResourceNotFoundException;
import springboot.repository.UserRepository;
import springboot.service.GraphQLService;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	GraphQLService graphQLService;

	@PostMapping("/graphql")
	public ResponseEntity<Object> getAllUsers(@RequestBody String query){
		ExecutionResult execute = graphQLService.getGraphQL().execute(query);
		return new ResponseEntity<Object>(execute, HttpStatus.OK);
	}

	// get all users
	@GetMapping
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}


	@GetMapping("/names/{firstName}")
	public List<User>getNames(@PathVariable (value = "firstName")String firstName){
		return this.userRepository.findByFirstName(firstName);
	}

	// get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value = "id") long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
	}

	// create user
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	// update user
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		 User existingUser = this.userRepository.findById(userId)
			.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));

		 if(user.getFirstName()!=null && !user.getFirstName().equals("")){
			 existingUser.setFirstName(user.getFirstName());
		 }
		if(user.getLastName()!=null&& !user.getLastName().equals("")){
			existingUser.setLastName(user.getLastName());
		}
		if(user.getEmail()!=null && !user.getEmail().equals("")){
			existingUser.setEmail(user.getEmail());
		}
		if(user.getUserAge()!=null && !user.getUserAge().equals("")){
			existingUser.setUserAge(user.getUserAge());
		}
		if(user.getAdress()!=null && !user.getAdress().equals("")){
			if(user.getAdress().getCity()!=null && !user.getAdress().getCity().equals("")){
				existingUser.getAdress().setCity(user.getAdress().getCity());
			}
			if(user.getAdress().getStreet()!=null && !user.getAdress().getStreet().equals("")){
				existingUser.getAdress().setStreet(user.getAdress().getStreet());
			}
			if(user.getAdress().getPostalCode()!=null && !user.getAdress().getPostalCode().equals("")){
				existingUser.getAdress().setPostalCode(user.getAdress().getPostalCode());
			}
			//!String.valueOf(user.getAdress().getPostalCode()).equals("")
			//existingUser.setAdress(user.getAdress());
		}
//		if(user.getChilds()!=null && !user.getChilds().equals("")){
//			//cocugu icine koyduk....
//			existingUser.setChilds(user.getChilds());
//		}
		 return this.userRepository.save(existingUser);
	}
	
	// delete user by id
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable ("id") long userId){
		 User existingUser = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
//		 existingUser.setChilds(null);
//		 existingUser.setAdress(null);
		 userRepository.deleteById(userId);
		 return "USER DELETED...";
	}

}
