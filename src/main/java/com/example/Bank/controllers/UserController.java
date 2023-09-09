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
	public String dashboard(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		String username = userDetails.getUsername();
		User user = userRepository.findByUsernameIgnoreCase(username);
		List<BankAccount> bankAccount = bankAccountRepository.findAllByFullName(user.getFullname());
		model.addAttribute("bank_accounts", bankAccount);
		model.addAttribute("fullname", user.getFullname());
		model.addAttribute("username", user.getUsername());
		model.addAttribute("role", "user");
		return "/user-dashboard";
	}

	@GetMapping("/edit-bank-account/{id}/")
	public String showBankAccountEditForm(@PathVariable("id") long id, Model model, @AuthenticationPrincipal UserDetails userDetails) {
		String username = userDetails.getUsername();
		User user = userRepository.findByUsernameIgnoreCase(username);
		BankAccount bankAccount = bankAccountRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid bankAccount Id:" + id));
		model.addAttribute("bankAccount", bankAccount);
		model.addAttribute("fullname", user.getFullname());
		model.addAttribute("username", user.getUsername());
		model.addAttribute("role", "user");
		return "/edit-bank-account";
	}

	@PostMapping("/edit-bank-account/{id}/")
	public String editBankAccount(@ModelAttribute("bankAccount") BankAccount updatedBankAccount) {
		BankAccount bankAccount = bankAccountRepository.findById(updatedBankAccount.getId())
				.orElseThrow(() -> new IllegalArgumentException("Invalid bankAccount Id:" + updatedBankAccount.getId()));
		BigDecimal temp = new BigDecimal(0);
		BigDecimal balance = bankAccount.getBalance();
		BigDecimal change = updatedBankAccount.getBalance();
		if (change.compareTo(temp) < 0) {
			System.out.println("снимаем сумму");
			if (balance.compareTo(change) >= 0) {
				bankAccount.setBalance(balance.add(change));
			}
		}
		else if (change.compareTo(temp) > 0) {
			System.out.println("кладем сумму");
			bankAccount.setBalance(balance.add(change));
		} else {
			System.out.println("ничего не делаем");
		}

		//bankAccount.setBalance(updatedBankAccount.getBalance());
		bankAccountRepository.save(bankAccount);
		return "redirect:/user/dashboard";
	}

	@GetMapping("/delete-bank-account/{id}/")
	public String deleteBankAccount(@PathVariable("id") long id, Model model) {
		bankAccountRepository.deleteById(id);
		return "redirect:/user/dashboard";
	}

	@GetMapping("/create-bank-account")
	public String showBankAccountsForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
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

		bankAccount.setUserId(user.getId());
		bankAccount.setFullName(user.getFullname());
		String accountCurrency = bankAccount.getAccountCurrency();
		short accountCurrencyNumber = FormAttributes.getAccountCurrencyNumber(accountCurrency);
		bankAccount.setAccountCurrency(String.valueOf(accountCurrencyNumber));
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
