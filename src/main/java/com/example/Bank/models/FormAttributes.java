package com.example.Bank.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FormAttributes {
    public static String[] accountNames = {"Универсальный", "Накопительный"};
    public static String[] accountCurrencies = {"Рубли", "Доллары", "Евро"};

    public static boolean isWriteBankAccount(String outpoot) {
        if (outpoot.isEmpty() || outpoot == null) return false;
        File file = new File("src/main/resources/bank-accounts.json");
        try {
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(outpoot);
            pw.close();
        } catch (IOException e) { e.printStackTrace(); }
        return true;
    }

    public enum BankAccountType {
        Счет,
        Карта
    }
    public enum BankAccount_1 {
        Универсальный,
        Накопительный
    }
    public enum BankAccount_2 {
        Кредитная,
        Дебитовая
    }


}
