/*package com.example.Bank.models;

public class Card extends BankAccount {

    private String cardNumber = "";
    private String cardName;// название карты
    private int limit = Integer.MAX_VALUE;
    private int overdraft = 0;

    public Card() {
        setAccountType((byte) 9);
        setRenewalDate(getCreationDate().plusYears(2));
        setProlongation(true);
        setAccountName("Счет карты");
        setInterestRate(0.00);
    }

    public Card(String cardName, int limit, int overdraft) {
        setAccountType((byte) 9);
        setRenewalDate(getCreationDate().plusYears(2));
        setProlongation(true);
        setAccountName("Счет карты");
        setInterestRate(0.00);
        this.cardName = cardName;
        this.limit = limit;
        this.overdraft = overdraft;
    }

}
*/