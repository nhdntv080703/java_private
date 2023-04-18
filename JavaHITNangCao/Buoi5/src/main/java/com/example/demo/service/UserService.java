package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    UserDTO getUserById(Long id);
    UserDTO findById(Long id);
    ResponseEntity<UserDTO> createUser(UserDTO userDTO);
    ResponseEntity<UserDTO> updateUser(Long id, UserDTO userDTO);
    ResponseEntity<UserDTO> partialUpdateUser(Long id, UserDTO userDTO);
    List<UserDTO> searchUsers(String fullName);
    List<UserDTO> findAll();
    void deleteUser(Long id);
}
