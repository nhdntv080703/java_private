package com.example.demo.service;

import com.example.demo.dto.SubjectDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubjectService {
    ResponseEntity<List<SubjectDTO>> findByStudent_Id(Long id);
    ResponseEntity<?> findAll(Integer page, Integer size);
    ResponseEntity<?> createNewSubject(SubjectDTO subjectDTO);
}
