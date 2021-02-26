package springboot.service;


import io.restassured.path.json.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.Test;
import springboot.pojo.BookDemoqa;
import io.restassured.response.Response;
import springboot.pojo.BookPojo;

import javax.persistence.Temporal;
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

@Component
public class BookService {


    @Autowired
    BookDemoqa bookDemoqa;
    @Autowired
    BookPojo bookPojo;
    Response response;
    String endpoint = "https://demoqa.com/BookStore/v1/Books";
    String endpointLocal = "http://localhost:8888/api/users";
    List<BookDemoqa> myBookDemoqaList = new ArrayList<>();

    JsonPath jsonPath;

    public List<BookDemoqa> myBookList(){
    response = given().when().get(endpoint);
    jsonPath = response.jsonPath();
    myBookDemoqaList.addAll(jsonPath.getList("books"));
        return myBookDemoqaList;
    }

    public List<Integer> getBookIdsForAUser(int userId){
        response = given().when().get(endpointLocal+"/"+userId);
        jsonPath = response.jsonPath();
        List<Integer> myBookIdList = new ArrayList<>(jsonPath.getList("books.bookId"));
        return myBookIdList;
    }



}
