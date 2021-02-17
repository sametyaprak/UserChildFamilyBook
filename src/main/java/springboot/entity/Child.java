package springboot.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "child")
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long childId;
    private String childName;

    public Child() {
    }

    public Child(String childName) {
        super();
        this.childName = childName;
    }
}
