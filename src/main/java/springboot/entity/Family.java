package springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
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

    @OneToOne(mappedBy = "family",cascade = CascadeType.ALL)
    private User user;

    public long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(long familyId) {
        this.familyId = familyId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public int getFatherAge() {
        return fatherAge;
    }

    public void setFatherAge(int fatherAge) {
        this.fatherAge = fatherAge;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public int getMotherAge() {
        return motherAge;
    }

    public void setMotherAge(int motherAge) {
        this.motherAge = motherAge;
    }

}
