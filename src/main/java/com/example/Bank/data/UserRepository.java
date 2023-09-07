package com.example.Bank.data;

import com.example.Bank.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Boolean existsByUsernameIgnoreCase(String username);
	User findByUsernameIgnoreCase(String username);

}
