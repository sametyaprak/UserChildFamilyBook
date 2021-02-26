package springboot.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Table(name = "books")
@NoArgsConstructor
@Component
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookId;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "books")
    Set<User> users = new HashSet<>();

    public Book(Set<User> users) {
        this.users = users;
    }

    public Book(long bookId) {
        this.bookId = bookId;
    }

    public long getBookId() {
        return bookId;
    }


}
