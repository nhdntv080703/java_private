package com.example.demo.service.impl;

import com.example.demo.converter.PhoneConverter;
import com.example.demo.dto.PhoneDTO;
import com.example.demo.entity.PhoneEntity;
import com.example.demo.entity.StudentEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.PhoneRepository;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    PhoneRepository phoneRepository;
    @Autowired
    PhoneConverter phoneConverter;
    @Autowired
    StudentRepository studentRepository;

    @Override
    public ResponseEntity<PhoneDTO> updatePhoneById(Long id, PhoneDTO phoneDTO) {
        Optional<PhoneEntity> optionalPhoneEntity = phoneRepository.findById(id);
        if(optionalPhoneEntity.isPresent()){
            Optional<StudentEntity> optionalStudent = studentRepository.findById(phoneDTO.getStudent_id());
            if(optionalStudent.isPresent()){
                PhoneEntity existPhoneEntity = optionalPhoneEntity.get();
                existPhoneEntity = phoneConverter.converToEntity(phoneDTO);
                existPhoneEntity.setId(id);
                PhoneEntity phoneEntity = phoneRepository.save(existPhoneEntity);
                return  ResponseEntity.ok(phoneConverter.converToDTO(phoneEntity));
            }
            else {
                throw new NotFoundException("Student not found with id = " + phoneDTO.getStudent_id(), HttpStatus.NOT_FOUND);
            }
        }
        else{
            throw new NotFoundException("Phone not found with id = " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> createNewPhone(PhoneDTO phoneDTO) {
        Optional<StudentEntity> studentOptional = studentRepository.findById(phoneDTO.getStudent_id());
        if (!studentOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found student with id: " + phoneDTO.getStudent_id());
        }
        StudentEntity student = studentOptional.get();
        PhoneEntity phone = new PhoneEntity(phoneDTO.getName(), phoneDTO.getBrand(), student);
        return ResponseEntity.ok(phoneConverter.converToDTO(phoneRepository.save(phone)));
    }

    @Override
    public ResponseEntity<?> getAllPhone(Integer page, Integer size) {
        if (page == null || page < 0) {
            return ResponseEntity.ok(phoneConverter.converToListDTO(phoneRepository.findAll()));
        }
        //Phân trang nhưng có sắp xếp trang theo brand giảm dần
        Page<PhoneEntity> phones = phoneRepository.findAll(PageRequest.of(page, size, Sort.by("brand").descending()));
        return ResponseEntity.ok(phones.getContent());
    }
}
