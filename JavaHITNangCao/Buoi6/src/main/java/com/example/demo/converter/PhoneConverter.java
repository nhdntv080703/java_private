package com.example.demo.converter;

import com.example.demo.dto.PhoneDTO;
import com.example.demo.entity.PhoneEntity;
import com.example.demo.entity.StudentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhoneConverter {

    ModelMapper modelMapper = new ModelMapper();

    public PhoneEntity converToEntity (PhoneDTO phoneDTO){
        PhoneEntity phoneEntity = modelMapper.map(phoneDTO, PhoneEntity.class);
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(phoneDTO.getStudent_id());
        phoneEntity.setStudent(studentEntity);
        return phoneEntity;
    }

    public PhoneDTO converToDTO (PhoneEntity phoneEntity){
        PhoneDTO phoneDTO = modelMapper.map(phoneEntity, PhoneDTO.class);
        phoneDTO.setStudent_id(phoneEntity.getStudent().getId());
        return phoneDTO;
    }

    public List<PhoneEntity> converToListEntity (List<PhoneDTO> phoneDTOS){
        List<PhoneEntity> phoneEntities = new ArrayList<>();
        for(PhoneDTO phoneDTO : phoneDTOS){
            PhoneEntity phoneEntity = converToEntity(phoneDTO);
            phoneEntities.add(phoneEntity);
        }
        return phoneEntities;
    }

    public List<PhoneDTO> converToListDTO (List<PhoneEntity> phoneEntities){
        List<PhoneDTO> phoneDTOS = new ArrayList<>();
        for(PhoneEntity phoneEntity : phoneEntities){
            PhoneDTO phoneDTO = converToDTO(phoneEntity);
            phoneDTOS.add(phoneDTO);
        }
        return phoneDTOS;
    }
}
