package com.example.demo.service;

import com.example.demo.dto.StudentDTO;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity<?> createNewStudent(StudentDTO studentDTO);
    ResponseEntity<?> updateById(Long id, StudentDTO studentDTO);
    void deleteStudentById(Long studentId);
    ResponseEntity<?> pageableFindAll(Integer page, Integer size);
    ResponseEntity<?> searchByName(String name, int page, int size);
}
