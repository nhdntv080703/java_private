package com.example.demo.controller;

import com.example.demo.Dto.UserDTO;
import com.example.demo.service.UserService;
import com.example.demo.utils.UploadFileCloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UploadFileCloudinary uploadFileCloudinary;
    @Autowired
    private UserService userService;

    @PostMapping("/create_user")
    public ResponseEntity<?> createNewUser(@RequestParam String name,
                                           @RequestParam String address,
                                           @RequestParam MultipartFile multipartFile)
            throws IOException {
        return ResponseEntity.ok(userService.create(name, address, multipartFile));
    }

    @PostMapping("/create_user2")
    public ResponseEntity<?> createNewUser(@Valid @ModelAttribute UserDTO userDTO,
                                           BindingResult bindingResult)
            throws IOException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            String errorMsg = "";
            for (String key : errors.keySet()) {
                errorMsg += "Error in: " + key + ", Reason: " + errors.get(key) + "\n";
            }
            return ResponseEntity.ok(errorMsg);
        }
        return ResponseEntity.ok(userService.create2(userDTO));
    }

    @PostMapping("/create_user3")
    public ResponseEntity<?> createNewUser3(@RequestParam String name,
                                            @RequestParam String address,
                                            @RequestParam MultipartFile multipartFile
    ) {
        return ResponseEntity.ok(userService.createNewUser3(name, address, multipartFile));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteImageByUrl(@RequestParam String url) throws Exception {
        return ResponseEntity.ok(uploadFileCloudinary.removeFileToUrl(url));
    }

}
