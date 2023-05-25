package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IUserService {
    UserDTO findOneByUserNameAndStatus(String name, int status);
    List<UserDTO> getUsers(String searchValue, Pageable pageable);
    int getTotalItems(String searchValue);
    UserDTO findOneByUserName(String userName);
    UserDTO findUserById(Long id);
    UserDTO insert(UserDTO userDTO);
    UserDTO update(Long id, UserDTO userDTO);
    UserDTO resetPassword(long id);
    UserDTO updateProfileOfUser(String id, UserDTO userDTO);
    void delete(Long[] ids);
    Map<Long,String> getStaffMaps();
    List<UserDTO> findUsersByStaffIds(List<Long> staffIds);
    UserDTO getUserById(Long id);
    UserDTO findById(Long id);
    ResponseEntity<UserDTO> createUser(UserDTO userDTO);
    ResponseEntity<UserDTO> updateUser(Long id, UserDTO userDTO);
    ResponseEntity<UserDTO> partialUpdateUser(Long id, UserDTO userDTO);
    List<UserDTO> searchUsers(String fullName);
    List<UserDTO> findAll();
    void deleteUser(Long id);
}
