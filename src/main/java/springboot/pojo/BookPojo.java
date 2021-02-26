package springboot.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
        "books"
})
@Component

@NoArgsConstructor
@AllArgsConstructor
public class BookPojo {

    @JsonProperty("books")
    private List<BookDemoqa> bookDemoqas = null;


    @JsonProperty("books")
    public List<BookDemoqa> getBooks() {
        return bookDemoqas;
    }

    @JsonProperty("books")
    public void setBooks(List<BookDemoqa> bookDemoqas) {
        this.bookDemoqas = bookDemoqas;
    }

    public BookPojo withBooks(List<BookDemoqa> bookDemoqas) {
        this.bookDemoqas = bookDemoqas;
        return this;
    }

    @Override
    public String toString() {
        return "BookPojo{" +
                "bookDemoqas=" + bookDemoqas +
                '}';
    }
}


