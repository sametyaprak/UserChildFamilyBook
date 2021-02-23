package springboot.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "bank_account")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bankAccountId;
    private long balance;
    private String openDate;
    private String lastUpdate;


}
