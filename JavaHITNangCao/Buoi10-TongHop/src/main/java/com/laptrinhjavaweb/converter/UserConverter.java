package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    ModelMapper modelMapper;

    public UserEntity converDTOToEntity(UserDTO userDTO){
        UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
        return userEntity;
    }

    public UserDTO converEntityToDTO(UserEntity userEntity){
        UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
        return userDTO;
    }
}
