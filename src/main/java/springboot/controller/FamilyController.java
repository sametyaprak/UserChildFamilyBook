package springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.Book;
import springboot.entity.Family;
import springboot.repository.BookRepository;
import springboot.repository.FamilyRepository;

import java.util.List;

@RestController
@RequestMapping("/api/families")
public class FamilyController {

    @Autowired
    private FamilyRepository familyRepository;

    // get all books
    @GetMapping
    public List<Family> getAllFamilies(){
        return familyRepository.findAll();
    }


}