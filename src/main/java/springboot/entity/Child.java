package springboot.entity;


import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "child")
@Component
@NoArgsConstructor

public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long childId;
    private String childName;
    private int childAge;
    private boolean student;

    public Child(String childName, int childAge,boolean student) {
        this.childName = childName;
        this.childAge = childAge;
        this.student = student;
    }
}
