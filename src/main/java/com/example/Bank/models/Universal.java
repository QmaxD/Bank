/*package com.example.Bank.models;

import lombok.*;

@Setter
@Getter
public class Universal extends BankAccount {
    public Universal (BankAccount bankAccount, double interestRate)
    {
        super(
            bankAccount.getId(),
            bankAccount.getAccountPlace(),
            bankAccount.getAccountCurrency(),
            bankAccount.getAccountNumber(),
            bankAccount.getCreationDate(),
            bankAccount.getBalance(),
            bankAccount.getFullName(),
            bankAccount.getUser_id()
        );

        setAccountType((byte) 5);
        setRenewalDate(getCreationDate().plusYears(5));
        setProlongation(true);
        setAccountName("Универсальный");
        setInterestRate(0.01);

        setInterestRate(interestRate);
    }

    @Override
    public String toString() {
        return "Universal(" +
                "id=" + getId() +
                ", accountPlace=" + getAccountPlace() +
                ", accountType=" + getAccountType() +
                ", accountCurrency=" + getAccountCurrency() +
                ", accountNumber=" + getAccountNumber() +
                ", creationDate=" + getCreationDate() +
                ", renewalDate=" + getRenewalDate() +
                ", isProlongation=" + isProlongation() +
                ", closingDate=" + getClosingDate() +
                ", accountName=" + getAccountName() +
                ", balance=" + getBalance() +
                ", interestRate=" + getInterestRate() +
                ", firstName=" + getFullName() +
                ", lastName=" + getUser_id() +
                ")";
    }

}
*/