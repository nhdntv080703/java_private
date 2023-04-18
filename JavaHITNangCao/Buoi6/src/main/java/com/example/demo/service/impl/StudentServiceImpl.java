package com.example.demo.service.impl;

import com.example.demo.converter.StudentConverter;
import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentConverter studentConverter;

    @Override
    public ResponseEntity<?> createNewStudent(StudentDTO studentDTO) {
        StudentEntity student = studentConverter.converToEntity(studentDTO);
        return ResponseEntity.ok(studentConverter.converToDTO(studentRepository.save(student)));
    }

    @Override
    public ResponseEntity<?> updateById(Long id, StudentDTO studentDTO) {
        Optional<StudentEntity> existStudentEntity = studentRepository.findById(id);
        if(existStudentEntity.isPresent()){
            StudentEntity studentEntity = existStudentEntity.get();
            studentEntity = studentConverter.converToEntity(studentDTO);
            studentEntity.setId(id);
            return ResponseEntity.ok(studentConverter.converToDTO(studentRepository.save(studentEntity)));
        }
        else {
            throw new NotFoundException("Student not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteStudentById(Long studentId) {
        StudentEntity student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            studentRepository.delete(student);
        }
        else {
            throw new NotFoundException("Student not found with id " + studentId, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> pageableFindAll(Integer page, Integer size) {
        if (page == null || page < 0){
            List<StudentEntity> studentEntities = studentRepository.findAll();
            List<StudentDTO> studentDTOS = studentConverter.converToListDTO(studentEntities);
            return ResponseEntity.ok(studentConverter.converToListDTO(studentRepository.findAll()));
        }
        else {
            Page<StudentEntity> students = studentRepository.findAll(PageRequest.of(page, size));
            return ResponseEntity.ok(students.getContent());
        }
    }

    @Override
    public ResponseEntity<?> searchByName(String name, int page, int size) {
        if (page < 0) {
            page = 0;
        }
        List<StudentEntity> students = studentRepository.findAllByName(name, PageRequest.of(page, size));
        return ResponseEntity.ok(studentConverter.converToListDTO(students));
    }
}
