package com.example.demo.service;

import com.example.demo.dto.PhoneDTO;
import org.springframework.http.ResponseEntity;


public interface PhoneService {
    ResponseEntity<PhoneDTO> updatePhoneById(Long id, PhoneDTO phoneDTO);
    ResponseEntity<?> createNewPhone(PhoneDTO phoneDTO);
    ResponseEntity<?> getAllPhone(Integer page, Integer size);
}
