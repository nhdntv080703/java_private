package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.RoleDTO;
import com.laptrinhjavaweb.entity.RoleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    @Autowired
    ModelMapper modelMapper;

    public RoleEntity converDTOToEntity(RoleDTO roleDTO){
        RoleEntity roleEntity = modelMapper.map(roleDTO, RoleEntity.class);
        return roleEntity;
    }

    public RoleDTO converEntityToDTO(RoleEntity roleEntity){
        RoleDTO roleDTO = modelMapper.map(roleEntity, RoleDTO.class);
        return roleDTO;
    }
}
