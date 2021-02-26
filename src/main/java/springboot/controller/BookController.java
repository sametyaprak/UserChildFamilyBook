package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import springboot.pojo.BookDemoqa;
import springboot.pojo.BookPojo;
import springboot.service.BookService;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


@RestController
@RequestMapping("/api/books")
public class BookController {


    @Autowired
    BookPojo bookPojo;

    @Autowired
    private BookService bookService;

    @Autowired
    BookDemoqa bookDemoqa;



    // get all books
    @GetMapping()
    public List<BookDemoqa>getAllBooks(){
        return bookService.myBookList();
    }

    @GetMapping("/{index}")
    public Object getBooksByBookIndex(@PathVariable (value = "index") int index){
        return bookService.myBookList().get(index);
    }
    @GetMapping("users/{userId}/books")
    public Object getBooksByUserId(@PathVariable (value = "userId") int userId){
        List<Object> userBooks = new ArrayList<>();
        for(Integer w:bookService.getBookIdsForAUser(userId)){
            userBooks.add(bookService.myBookList().get(w));
        }
        return userBooks;
    }






}
