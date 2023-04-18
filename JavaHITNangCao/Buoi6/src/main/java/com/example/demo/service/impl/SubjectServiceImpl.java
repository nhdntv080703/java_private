package com.example.demo.service.impl;

import com.example.demo.converter.SubjectConverter;
import com.example.demo.dto.SubjectDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.entity.SubjectEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import com.example.demo.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SubjectConverter subjectConverter;
    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public ResponseEntity<List<SubjectDTO>> findByStudent_Id(Long id) {
        Optional<StudentEntity> studentEntity = studentRepository.findById(id);
        List<SubjectEntity> subjectEntities = studentEntity.get().getSubjectEntities();
        if(subjectEntities != null && !subjectEntities.isEmpty()){
            List<SubjectDTO> subjectDTOS = subjectConverter.converToListDTO(subjectEntities);
            return ResponseEntity.ok(subjectDTOS);
        }
        else{
            throw new NotFoundException("Subject not found with student_id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<?> findAll(Integer page, Integer size){
        if (page == null || page < 0) {
            return ResponseEntity.ok(subjectConverter.converToListDTO(subjectRepository.findAll()));
        }
        Page<SubjectEntity> subjectEntities = subjectRepository.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok(subjectEntities.getContent());
    }

    @Override
    public ResponseEntity<?> createNewSubject(SubjectDTO subjectDTO) {
        //C1 : Trả về nếu không tìm thấy subject by id
        /*
       Student student = studentRepository.findById(subjectDTO.getStudent_id())
                .orElseThrow(()->{
                    throw new RuntimeException("Not found student with id: " + subjectDTO.getStudent_id());
                });
       */
        //c2 : Sử dụng đối tượng Optional : có thể lưu trữ được cả Object trong trường hợp nó null.
        Optional<StudentEntity> studentFindId = studentRepository.findById(subjectDTO.getStudent_id());
        if (!studentFindId.isPresent()) {
            return ResponseEntity.ok("Not found student with id : " + subjectDTO.getStudent_id());
        }
        SubjectEntity subject = new SubjectEntity(subjectDTO.getName(), studentFindId.get());
        SubjectDTO subjectDTO1 = subjectConverter.converToDTO(subjectRepository.save(subject));
        return ResponseEntity.ok(subjectDTO1);
    }
}
