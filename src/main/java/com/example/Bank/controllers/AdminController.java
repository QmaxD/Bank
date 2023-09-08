package com.example.Bank.controllers;

import com.example.Bank.data.RoleRepository;
import com.example.Bank.data.UserRepository;
import com.example.Bank.models.Role;
import com.example.Bank.models.User;
import com.example.Bank.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	public AdminController(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Autowired
	private UserService userService;
	
	@GetMapping("/dashboard")
	public String dashboard(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		String username = userDetails.getUsername();
		//User user = userRepository.findByUsernameIgnoreCase(username);
		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);
		model.addAttribute("username", username);
		model.addAttribute("role", "admin");

		return "/admin-dashboard";
	}
	
	@GetMapping("/register")
	public String registrationPage(Model model, @AuthenticationPrincipal UserDetails userDetails) {
		String username = userDetails.getUsername();
		//User user = userRepository.findByUsernameIgnoreCase(username);
		model.addAttribute("user", new User());
		model.addAttribute("username", username);
		model.addAttribute("role", "admin");
		return "/register-admin";
	}
	
	@PostMapping("/register")
	public String registerUser(User user, RedirectAttributes ra) {
		if(userService.findUserByUsername(user.getUsername()) != null) {
			ra.addFlashAttribute("error", "Admin Already Exists");
			return "redirect:/admin/register";
		}
		userService.saveAdmin(user);
		ra.addFlashAttribute("success", "Registration Successful. Please Login");
		return "redirect:/admin/register";
	}

}
