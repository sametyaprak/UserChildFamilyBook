package springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
@Setter
@Table
@NoArgsConstructor

public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long familyId;
    private String fatherName;
    private int fatherAge;
    private String motherName;
    private int motherAge;

    @OneToOne(mappedBy = "family",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

    public long getFamilyId() {
        return familyId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public int getFatherAge() {
        return fatherAge;
    }

    public String getMotherName() {
        return motherName;
    }

    public int getMotherAge() {
        return motherAge;
    }
}
