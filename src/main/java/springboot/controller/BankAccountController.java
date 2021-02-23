package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.entity.BankAccount;
import springboot.entity.User;
import springboot.repository.BankAccountRepository;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountController {

    @Autowired
    private BankAccountRepository bankAccountRepository;

    @GetMapping
    public List<BankAccount> getAllBankAccount() {
        return this.bankAccountRepository.findAll();
    }

}
