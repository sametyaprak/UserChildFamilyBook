package springboot.controller;

import graphql.ExecutionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.entity.Book;
import springboot.repository.BookRepository;
import springboot.service.GraphQLService;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    GraphQLService graphQLService;

    // get all books
    @GetMapping
    public List<Book>getAllBooks(){
        return bookRepository.findAll();
    }

    @PostMapping("/graphql")
    public ResponseEntity<Object> getAllUsers(@RequestBody String query){
        ExecutionResult execute = graphQLService.getGraphQL().execute(query);
        return new ResponseEntity<Object>(execute, HttpStatus.OK);
    }


}
