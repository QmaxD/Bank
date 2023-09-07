/*package com.example.Bank.models;

import lombok.*;

@Setter
@Getter
public class Saving extends BankAccount {
    public Saving (BankAccount bankAccount, double interestRate)
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

        setAccountType((byte) 3);
        setRenewalDate(getCreationDate().plusYears(1));
        setProlongation(false);
        setAccountName("Накопительный");
        setInterestRate(5.50);

        setInterestRate(interestRate);
    }

    @Override
    public String toString() {
        return "Saving(" +
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