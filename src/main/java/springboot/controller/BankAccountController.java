package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.entity.BankAccount;
import springboot.entity.User;
import springboot.exception.ResourceNotFoundException;
import springboot.pojo.BankAccountPojo;
import springboot.repository.BankAccountRepository;
import springboot.repository.UserRepository;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/api/bankaccounts")
public class BankAccountController {

    Calendar calendar = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    BankAccount bankAccountNew = new BankAccount();

    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<BankAccount> getAllBankAccount() {
        return this.bankAccountRepository.findAll();
    }
    // get bankaccount by id
    @GetMapping("/{id}")
    public BankAccount getFamilyById(@PathVariable(value = "id") long bankAccountId) {
        return this.bankAccountRepository.findById(bankAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("BankAccount not found with id :" + bankAccountId));
    }
    // create bankAccount
    @PostMapping
    public BankAccount createBankAccount(@RequestBody BankAccountPojo bankAccountPojo) {
        User existingUser = this.userRepository.findById(bankAccountPojo.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + bankAccountPojo.getId()));
        bankAccountNew.setLastUpdate(formatter.format(calendar.getTime()));
        bankAccountNew.setOpenDate(formatter.format(calendar.getTime()));
        bankAccountNew.setBalance(bankAccountPojo.getBalance());
        existingUser.getBankAccounts().add(bankAccountNew);
        return this.bankAccountRepository.save(bankAccountNew);
    }
    // update bankaccount
    @PutMapping("/{id}")
    public BankAccount updateUser(@RequestBody BankAccount bankAccount, @PathVariable ("id") long bankAccountId) {
        BankAccount existingBankAccount = this.bankAccountRepository.findById(bankAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("BankAccount not found with id :" + bankAccountId));
        existingBankAccount.setBalance(bankAccount.getBalance());
        Calendar calendar = Calendar.getInstance();
        existingBankAccount.setLastUpdate(formatter.format(calendar.getTime()));
        return this.bankAccountRepository.save(existingBankAccount);
    }

}
