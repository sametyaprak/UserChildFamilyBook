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
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setChilds(user.getChilds());

//		 if(user.getFirstName()!=null){
//			 existingUser.setFirstName(user.getFirstName());
//		 }
//		if(user.getLastName()!=null){
//			existingUser.setLastName(user.getLastName());
//		}
//		if(user.getEmail()!=null){
//			existingUser.setEmail(user.getEmail());
//		}
//		if(user.getChilds()!=null){
//			//cocugu icine koyduk....
//			existingUser.setChilds(user.getChilds());
//		}
		 return this.userRepository.save(existingUser);
	}
	
	// delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
		 User existingUser = this.userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
		 existingUser.setChilds(null);
		 //this.userRepository.delete(existingUser);
		 return ResponseEntity.ok().build();
	}

}
