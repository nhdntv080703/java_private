package com.example.demo.controller;

import com.example.demo.dto.PhoneDTO;
import com.example.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @PostMapping("/create_new_phone")
    public ResponseEntity<?> createNewPhone(@RequestBody PhoneDTO phoneDTO) {
        return phoneService.createNewPhone(phoneDTO);
    }

    @GetMapping("/get_all_phone")
    public ResponseEntity<?> getAllPhone(@RequestParam(name = "page", required = false) Integer page,
                                         @RequestParam(name = "size", required = false , defaultValue = "4") Integer size) {
        return phoneService.getAllPhone(page, size);
    }

    @PutMapping("/update_phone/{id}")
    public ResponseEntity<?> updatePhone(@PathVariable("id") Long id, @RequestBody PhoneDTO phoneDTO){
        return phoneService.updatePhoneById(id, phoneDTO);
    }
}
