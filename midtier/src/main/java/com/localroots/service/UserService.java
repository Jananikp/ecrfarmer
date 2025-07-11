package com.localroots.service;

import com.localroots.dto.UserDTO;
import com.localroots.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    Optional<User> getUserByEmail(String email);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
}
