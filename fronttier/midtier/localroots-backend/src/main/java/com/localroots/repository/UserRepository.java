package com.localroots.repository;

import com.localroots.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by their email address
    Optional<User> findByEmail(String email);

    // Find all users with a specific role (e.g., BUYER, FARMER, ADMIN)
    List<User> findByRole(String role);

    // Find all users with a specific status
    List<User> findByStatus(String status);
}
