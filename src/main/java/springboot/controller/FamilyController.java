package springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.entity.Family;
import springboot.entity.User;
import springboot.exception.ResourceNotFoundException;
import springboot.repository.FamilyRepository;

import java.util.List;

@RestController
@RequestMapping("/api/families")
public class FamilyController {

    @Autowired
    private FamilyRepository familyRepository;

    // get all families
    @GetMapping
    public List<Family> getAllFamilies(){
        return familyRepository.findAll();
    }
    // get family by id
    @GetMapping("/{id}")
    public Family getFamilyById(@PathVariable(value = "id") long userId) {
        return this.familyRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
    }
    // update user
    @PutMapping("/{id}")
    public Family updateUser(@RequestBody Family family, @PathVariable ("id") long userId) {
        Family existingFamily = this.familyRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
        existingFamily.setFatherName(family.getFatherName());
        existingFamily.setMotherName(family.getMotherName());
        existingFamily.setFatherAge(family.getFatherAge());
        existingFamily.setFatherAge(family.getFatherAge());
        return this.familyRepository.save(existingFamily);
    }


}