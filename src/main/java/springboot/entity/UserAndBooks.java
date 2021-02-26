package springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users_and_books")
@Getter
@Setter
public class UserAndBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userIDBookId;
    @Column(name = "user_id")
    private long userID;
    @Column(name = "book_id")
    private long bookId;

}
