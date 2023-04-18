package com.example.demo.converter;

import com.example.demo.dto.SubjectDTO;
import com.example.demo.entity.SubjectEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubjectConverter {

    ModelMapper modelMapper = new ModelMapper();

    public SubjectEntity converToEntity (SubjectDTO phoneDTO){
        SubjectEntity phoneEntity = modelMapper.map(phoneDTO, SubjectEntity.class);
        return phoneEntity;
    }

    public SubjectDTO converToDTO (SubjectEntity phoneEntity){
        SubjectDTO phoneDTO = modelMapper.map(phoneEntity, SubjectDTO.class);
        phoneDTO.setStudent_id(phoneEntity.getStudentEntity().getId());
        return phoneDTO;
    }

    public List<SubjectEntity> converToListEntity (List<SubjectDTO> phoneDTOS){
        List<SubjectEntity> phoneEntities = new ArrayList<>();
        for(SubjectDTO phoneDTO : phoneDTOS){
            SubjectEntity phoneEntity = converToEntity(phoneDTO);
            phoneEntities.add(phoneEntity);
        }
        return phoneEntities;
    }

    public List<SubjectDTO> converToListDTO (List<SubjectEntity> phoneEntities){
        List<SubjectDTO> phoneDTOS = new ArrayList<>();
        for(SubjectEntity phoneEntity : phoneEntities){
            SubjectDTO phoneDTO = converToDTO(phoneEntity);
            phoneDTOS.add(phoneDTO);
        }
        return phoneDTOS;
    }
}
