package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserAPI {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUsers(@RequestBody UserDTO newUser) {
        return ResponseEntity.ok(userService.insert(newUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUsers(@PathVariable("id") long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.update(id, userDTO));
    }


    @PutMapping("/password/{id}/reset")
    public ResponseEntity<UserDTO> resetPassword(@PathVariable("id") long id) {
        return ResponseEntity.ok(userService.resetPassword(id));
    }

    @PutMapping("/profile/{username}")
    public ResponseEntity<UserDTO> updateProfileOfUser(@PathVariable("username") String username, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateProfileOfUser(username, userDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUsers(@RequestBody Long[] idList) {
        if (idList.length > 0) {
            userService.delete(idList);
        }
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        // Kiểm tra thông tin đăng nhập
        List<UserDTO> userDTOS = userService.findAll();
        for(UserDTO user : userDTOS){
            if (username.equals(user.getUserName()) && password.equals(user.getPassWord()))
                return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
    }
}
