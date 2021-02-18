package springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springboot.entity.Child;
import springboot.entity.User;
import springboot.repository.UserRepository;

@SpringBootApplication
public class SpringbootCrudRestfulWebservicesApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootCrudRestfulWebservicesApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//buradan core java ile veri girişi yapabiliriz.
//		User user = new User("enes","cagri","enes@gmail",28);
//		Child child = new Child("enesin oglu",5,false);
//		Child child2 = new Child("enesin kizi",15,true);
//		user.getChilds().add(child2);
//		user.getChilds().add(child);
//		this.userRepository.save(user);
	}
}
