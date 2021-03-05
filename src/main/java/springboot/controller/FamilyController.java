package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.entity.Family;
import springboot.exception.ResourceNotFoundException;
import springboot.repository.FamilyRepository;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
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
    public Family getFamilyById(@PathVariable(value = "id") long familyId) {
        return this.familyRepository.findById(familyId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + familyId));
    }
    // partly oder full update family
    @PutMapping("/{id}")
    public Family updateFamily(@RequestBody Family family, @PathVariable ("id") long familyId) {
        Family existingFamily = this.familyRepository.findById(familyId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + familyId));
        if(family.getFatherName()!=null){
            existingFamily.setFatherName(family.getFatherName());
        }
        if(family.getMotherName()!=null){
            existingFamily.setMotherName(family.getMotherName());
        }
        if(family.getFatherAge()!=0){
            existingFamily.setFatherAge(family.getFatherAge());
        }
        if(family.getMotherAge()!=0){
            existingFamily.setMotherAge(family.getMotherAge());
        }
        return this.familyRepository.save(existingFamily);
    }


}