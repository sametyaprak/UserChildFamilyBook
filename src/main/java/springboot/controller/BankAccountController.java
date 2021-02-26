package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.entity.BankAccount;
import springboot.entity.Family;
import springboot.entity.User;
import springboot.exception.ResourceNotFoundException;
import springboot.repository.BankAccountRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    // get bankaccount by id
    @GetMapping("/{id}")
    public BankAccount getFamilyById(@PathVariable(value = "id") long userId) {
        return this.bankAccountRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("BankAccount not found with id :" + userId));
    }
    // update bankaccount
    @PutMapping("/{id}")
    public BankAccount updateUser(@RequestBody BankAccount bankAccount, @PathVariable ("id") long bankAccountId) {
        BankAccount existingBankAccount = this.bankAccountRepository.findById(bankAccountId)
                .orElseThrow(() -> new ResourceNotFoundException("BankAccount not found with id :" + bankAccountId));
        existingBankAccount.setBalance(bankAccount.getBalance());
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        existingBankAccount.setLastUpdate(formatter.format(calendar.getTime()));
        return this.bankAccountRepository.save(existingBankAccount);
    }

}
