package com.example.Bank.data;

import com.example.Bank.models.BankAccount;
import com.example.Bank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    List<BankAccount> findAllByFullName(String name);
    BankAccount findByAccountNumber(Long accountNumber);
    //void deleteByAccountNumber(Long accountNumber);

}
