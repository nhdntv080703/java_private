package com.example.demo.converter;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;
    }

    public List<UserDTO> converToUserDTO(List<UserEntity> userEntities){
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity item : userEntities){
            UserDTO userDTO = new UserDTO();
            userDTO.setId(item.getId());
            userDTO.setFullName(item.getFullName());
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    public List<UserDTO> convertToListDto (List<UserEntity> entities){
        List<UserDTO> userDTOS = new ArrayList<>();
        for (UserEntity userEntity : entities){
            UserDTO result = modelMapper.map(userEntity, UserDTO.class);
            userDTOS.add(result);
        }
        return userDTOS;
    }

    public List<UserEntity> convertToListEntity (List<UserDTO> dtos){
        List<UserEntity> userEntities = new ArrayList<>();
        for (UserDTO userDTO : dtos){
            UserEntity result = modelMapper.map(userDTO, UserEntity.class);
            userEntities.add(result);
        }
        return userEntities;
    }
}
