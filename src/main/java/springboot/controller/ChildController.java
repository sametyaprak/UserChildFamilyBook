package springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.Child;
import springboot.repository.ChildRepository;

import java.util.List;

@RestController
@RequestMapping("/api/childs")
public class ChildController {

    @Autowired
    private ChildRepository childRepository;

    public List<Child> getAllUser(){
        return this.childRepository.findAll();
    }

}
