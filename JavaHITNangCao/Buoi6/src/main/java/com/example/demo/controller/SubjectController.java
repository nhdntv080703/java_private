package com.example.demo.controller;


import com.example.demo.dto.SubjectDTO;
import com.example.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping("/create_new_subject")
    public ResponseEntity<?> createNewSubject(@RequestBody SubjectDTO subjectDTO) {
        return subjectService.createNewSubject(subjectDTO);
    }

    @GetMapping("/get_all_subject")
    public ResponseEntity<?> getAllSubject(@RequestParam(name = "page", required = false) Integer page,
                                         @RequestParam(name = "size", required = false , defaultValue = "4") Integer size) {
        return subjectService.findAll(page, size);
    }

    @GetMapping("/get_by_student_id/{id}")
    public ResponseEntity<?> getByStudent_Id(@PathVariable("id") Long studentId){
        return  subjectService.findByStudent_Id(studentId);
    }
}
