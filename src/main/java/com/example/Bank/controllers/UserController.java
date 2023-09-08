package com.example.Bank.controllers;

import com.example.Bank.data.BankAccountRepository;
import com.example.Bank.data.UserRepository;
import com.example.Bank.models.BankAccount;
import com.example.Bank.models.FormAttributes;
import com.example.Bank.models.User;
import com.example.Bank.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
	private final UserRepository userRepository;
	private final BankAccountRepository bankAccountRepository;
	public UserController(BankAccountRepository bankAccountRepository, UserRepository userRepository) {
		this.userRepository = userRepository;
		this.bankAccountRepository = bankAccountRepository;
	}

	@Autowired
	private UserService userService;

	@GetMapping("/dashboard")
	public String dashboard(Model model, @AuthenticationPrincipal UserDetails userDetails, BigDecimal balance) {
		String username = userDetails.getUsername();
		User user = userRepository.findByUsernameIgnoreCase(username);

		List<BankAccount> bankAccount = bankAccountRepository.findAllByFullName(user.getFullname());
		model.addAttribute("bank_accounts", bankAccount);

		model.addAttribute("fullname", user.getFullname());
		model.addAttribute("username", user.getUsername());
		model.addAttribute("role", "user");

		return "/user-dashboard";
	}

	@GetMapping("/create-bank-account")
	public String showFormBankAccount(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		String username = userDetails.getUsername();
		User user = userRepository.findByUsernameIgnoreCase(username);

		model.addAttribute("bankAccount", new BankAccount());

		model.addAttribute("accountName", FormAttributes.accountNames);
		model.addAttribute("accountCurrency", FormAttributes.accountCurrencies);

		model.addAttribute("fullname", user.getFullname());
		model.addAttribute("username", user.getUsername());
		model.addAttribute("role", "user");

		return "/create-bank-account";
	}

	@PostMapping("/create-bank-account")
	public String createBankAccount(BankAccount bankAccount, @AuthenticationPrincipal UserDetails userDetails, RedirectAttributes ra) throws IOException {
		String username = userDetails.getUsername();
		User user = userRepository.findByUsernameIgnoreCase(username);
		System.out.println("данные из файла считаны: " + FormAttributes.getCurrentBankAccountNumberFromFile());

		String accountCurrency = bankAccount.getAccountCurrency();
		short accountCurrencyNumber = FormAttributes.getAccountCurrencyNumber(accountCurrency);
		bankAccount.setAccountCurrency(String.valueOf(accountCurrencyNumber));

		bankAccount.setUserId(user.getId());
		bankAccount.setFullName(user.getFullname());
		Calendar date = new GregorianCalendar();
		bankAccount.setCreationDate(date);
		bankAccount.setAccountNumber(FormAttributes.countCurrentBankAccountsNumber());
		if (bankAccount.getAccountName().equals("Универсальный")){
			bankAccount.setProlongation(true);
			bankAccount.setInterestRate(0.01);
			date.add(Calendar.YEAR, 5);
			bankAccount.setRenewalDate(date);
		}
		else if (bankAccount.getAccountName().equals("Накопительный")) {
			bankAccount.setProlongation(false);
			bankAccount.setInterestRate(5.50);
			date.add(Calendar.YEAR, 1);
			bankAccount.setRenewalDate(date);
		}

		bankAccountRepository.save(bankAccount);
		System.out.println("данные записаны в файл: " + FormAttributes.writeCurrentBankAccountNumberToFile());
		return "redirect:/user/create-bank-account";
	}

}
