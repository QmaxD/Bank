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

import java.math.BigDecimal;
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
		model.addAttribute("username", username);
		model.addAttribute("role", "user");
		return "/user-dashboard";
	}

	@GetMapping("/create-bank-account")
	public String showFormBankAccount(Model model) {
		model.addAttribute("bankAccount", new BankAccount());
		return "/create-bank-account";
	}

	@PostMapping("/create-bank-account")
	public String createBankAccount(BankAccount bankAccount, @AuthenticationPrincipal UserDetails userDetails, RedirectAttributes ra) {
		String username = userDetails.getUsername();
		User user = userRepository.findByUsernameIgnoreCase(username);
		bankAccount.setUserId(user.getId());
		bankAccount.setFullName(user.getFullname());
		bankAccountRepository.save(bankAccount);
		return "redirect:/user/create-bank-account";
	}

}
