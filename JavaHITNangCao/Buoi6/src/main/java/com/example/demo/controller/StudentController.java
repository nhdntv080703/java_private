package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create_new_student")
    public ResponseEntity<?> createNewStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.createNewStudent(studentDTO);
    }

    @GetMapping("/get_all_student")
    public ResponseEntity<?> pageableFindAll(@RequestParam(name = "page", required = false) Integer page,
                                             @RequestParam(name = "size", required = false) Integer size) {
        return studentService.pageableFindAll(page, size);
    }

    @GetMapping("/searchByName")
    public ResponseEntity<?> searchByName(@RequestParam(name = "name", required = false) String name,
                                          @RequestParam(name = "page", required = false) int page,
                                          @RequestParam(name = "size", required = false) int size) {
        return  studentService.searchByName(name, page, size);
    }

    @PutMapping("/update_student/{id}")
    public  ResponseEntity<?> updateStudentById(@PathVariable("id") Long id, @RequestBody StudentDTO studentDTO){
        return studentService.updateById(id, studentDTO);
    }

    @DeleteMapping("/delete_student/{id}")
    public void deleteStudent (@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
    }
}

