package com.example.demo.converter;

import com.example.demo.dto.StudentDTO;
import com.example.demo.entity.StudentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentConverter {

    ModelMapper modelMapper = new ModelMapper();

    public StudentEntity converToEntity (StudentDTO phoneDTO){
        StudentEntity phoneEntity = modelMapper.map(phoneDTO, StudentEntity.class);
        return phoneEntity;
    }

    public StudentDTO converToDTO (StudentEntity phoneEntity){
        StudentDTO phoneDTO = modelMapper.map(phoneEntity, StudentDTO.class);
        return phoneDTO;
    }

    public List<StudentEntity> converToListEntity (List<StudentDTO> phoneDTOS){
        List<StudentEntity> phoneEntities = new ArrayList<>();
        for(StudentDTO phoneDTO : phoneDTOS){
            StudentEntity phoneEntity = converToEntity(phoneDTO);
            phoneEntities.add(phoneEntity);
        }
        return phoneEntities;
    }

    public List<StudentDTO> converToListDTO (List<StudentEntity> phoneEntities){
        List<StudentDTO> phoneDTOS = new ArrayList<>();
        for(StudentEntity phoneEntity : phoneEntities){
            StudentDTO phoneDTO = converToDTO(phoneEntity);
            phoneDTOS.add(phoneDTO);
        }
        return phoneDTOS;
    }
}
