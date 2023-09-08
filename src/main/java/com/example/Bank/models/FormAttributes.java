package com.example.Bank.models;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FormAttributes {
    public static String[] accountNames = {"Универсальный", "Накопительный"};
    public static String[] accountCurrencies = {"Рубль", "Доллар", "Евро"};

    public static int getAccountCurrency(String accountCurrency) {
        switch (accountCurrency) {
            case "Рубль":
                return 643;
            case "Доллар":
                return 840;
            case "Евро":
                return 978;
            default:
                return 0;
        }
    }

    public static int getAccounttype(String accountName) {
        switch (accountName) {
            case "Универсальный":
                return 5;
            case "Накопительный":
                return 3;
            default:
                return 0;
        }
    }

}
