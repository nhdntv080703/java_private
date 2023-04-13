package com.example.demo.api;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserAPI {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO userDTO) {
        return userService.createUser(userDTO);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Long id, @RequestBody UserDTO userDTO) {
        userService.updateUser(id, userDTO);
    }

    @PatchMapping("/{id}")
    public void partialUpdateUser(@PathVariable("id") Long id, @RequestBody UserDTO partialUserDTO) {
        userService.partialUpdateUser(id, partialUserDTO);
    }

    @GetMapping("/search")
    public List<UserDTO> searchUsers(@RequestParam(value = "fullName") String fullName) {
        return userService.searchUsers(fullName);
    }

}
