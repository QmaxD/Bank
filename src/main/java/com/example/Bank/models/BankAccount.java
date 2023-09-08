package com.example.Bank.models;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bank_accounts")
@Component
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bankAccount_id")
    private long id;
    //@Column(name = "accountPlace")
    //private byte accountPlace;// 000 - местоположение (город)
    //@Column(name = "accountType")
    //private byte accountType;// 0 - тип счета
    @Column(name = "accountCurrency")
    private String accountCurrency;// 000 - код валюты
    @Column(name = "accountNumber")
    private long accountNumber;//номер счета
    @Column(name = "creationDate")
    private Calendar creationDate;// дата создания счета
    @Column(name = "renewalDate")
    private Calendar renewalDate;// дата пролонгации счета (продление или прекращение условий)
    @Column(name = "isProlongation")
    private boolean isProlongation;
    @Column(name = "closingDate")
    private Calendar closingDate;
    @Column(name = "accountName")
    private String accountName;// название счета (зависит от типа счета)*/
    @Column(name = "balance")
    private BigDecimal balance;
    @Column(name = "interestRate")
    private double interestRate;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "user_id")
    private Long userId;

}

