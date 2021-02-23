package springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.entity.BankAccount;
@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Long> {
}
