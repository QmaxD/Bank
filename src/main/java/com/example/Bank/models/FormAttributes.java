package com.example.Bank.models;

import java.io.*;

public class FormAttributes {
    public static String[] accountNames = {"Универсальный", "Накопительный"};
    public static String[] accountCurrencies = {"Рубль", "Доллар", "Евро"};
    public static enum Currencies {
        рубль,
        доллар,
        евро
    }

    public static short getAccountCurrencyNumber(String accountCurrency) {
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
    public static int getAccountTypeNumber(String accountName) {
        switch (accountName) {
            case "Универсальный":
                return 5;
            case "Накопительный":
                return 3;
            default:
                return 0;
        }
    }
    public static String getAccountCurrencyString(String accountCurrencyNumber) {
        switch (accountCurrencyNumber) {
            case "643":
                return "Рубль";
            case "840":
                return "Доллар";
            case "978":
                return "Евро";
            default:
                return "NULL";
        }
    }

    public static long currentBankAccountNumber;
    public static String path = "E://GITHUB//Project_Java//Bank//src//main//resources//currentBankAccountNumber.txt";
    public static long getCurrentBankAccountNumber() {
        if (currentBankAccountNumber != 0)
            return currentBankAccountNumber;
        return -1;
    }
    public static void setCurrentBankAccountNumber(long number) {
        currentBankAccountNumber = number;
    }
    public static boolean getCurrentBankAccountNumberFromFile() throws IOException {
        try {
            File file = new File(path);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();
            currentBankAccountNumber = Integer.parseInt(line);
            bufferedReader.close();
            System.out.println(currentBankAccountNumber);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static boolean writeCurrentBankAccountNumberToFile() throws IOException {
        try {
            File file = new File(path);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.valueOf(currentBankAccountNumber));
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    public static long countCurrentBankAccountsNumber() {
        currentBankAccountNumber++;
        System.out.println("currentBankAccountNumber=" + currentBankAccountNumber);
        return currentBankAccountNumber;
    }

}
