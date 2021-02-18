package springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.entity.Child;
import springboot.exception.ResourceNotFoundException;
import springboot.repository.ChildRepository;
import java.util.List;

@RestController
@RequestMapping("/api/children")
public class ChildController {

    @Autowired
    private ChildRepository childRepository;

    private Child child;
    // get all users
    @GetMapping
    public List<Child> getAllChildren() {
        return this.childRepository.findAll();
    }

    // get user by id
    @GetMapping("/{id}")
    public Child getChildById(@PathVariable (value = "id") long childId) {
        return this.childRepository.findById(childId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + child));
    }

    // create child
    // bagli olan user.i nasıl baglayacagız belli değil
    @PostMapping
    public Child createChild(@RequestBody Child child) {
        return this.childRepository.save(child);
    }

    // update user
    @PutMapping("/{id}")
    public Child updateUser(@RequestBody Child child, @PathVariable ("id") long childId) {
        Child existingChild = this.childRepository.findById(childId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + child));
        existingChild.setChildName(child.getChildName());
        return this.childRepository.save(existingChild);
    }

    // delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Child> deleteUser(@PathVariable ("id") long childId){
        Child existingChild = this.childRepository.findById(childId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + childId));
        this.childRepository.delete(existingChild);
        //----existingChild.setChilds(null);
        //this.userRepository.delete(existingUser);
        return ResponseEntity.ok().build();
    }
}
