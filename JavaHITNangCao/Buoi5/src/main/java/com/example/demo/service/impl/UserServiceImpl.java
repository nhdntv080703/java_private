package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.NotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    @Override
    public UserDTO getUserById(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserDTO userDTO = userConverter.convertToDto(userOptional.get());
            return userDTO;
        } else {
            throw new NotFoundException("UserEntity not found with id " + id , HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public UserDTO findById(Long id) {
        return userConverter.convertToDto(userRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertToEntity(userDTO);
        if (userRepository.findByUserName(userEntity.getUserName()) != null) {
            throw new AlreadyExistsException("UserEntity already exists with username " + userEntity.getUserName(), HttpStatus.ALREADY_REPORTED);
        }
        UserEntity createdUserEntity = userRepository.save(userEntity);
        UserDTO createUserDTO = userConverter.convertToDto(createdUserEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserDTO);
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Long id, UserDTO userDTO) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserEntity existingUserEntity = userOptional.get();
            existingUserEntity = userConverter.convertToEntity(userDTO);
            UserEntity userEntity = userRepository.save(existingUserEntity);
            UserDTO updateUserDTO = userConverter.convertToDto(userEntity);
            return ResponseEntity.ok(updateUserDTO);
        } else {
            throw new NotFoundException("UserEntity not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<UserDTO> partialUpdateUser(Long id, UserDTO partialUserDTO) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserEntity existingUserEntity = userOptional.get();
            if (partialUserDTO.getUserName() != null) {
                existingUserEntity.setUserName(partialUserDTO.getUserName());
            }
            if (partialUserDTO.getFullName() != null) {
                existingUserEntity.setFullName(partialUserDTO.getFullName());
            }
            if (partialUserDTO.getPassWord() != null) {
                existingUserEntity.setPassWord(partialUserDTO.getPassWord());
            }
            UserEntity userEntity = userRepository.save(existingUserEntity);
            UserDTO updateUserDTO = userConverter.convertToDto(userEntity);
            return ResponseEntity.ok(updateUserDTO);
        } else {
            throw new NotFoundException("UserEntity not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<UserDTO> searchUsers(String fullName) {
        List<UserEntity> userEntities = userRepository.findByFullNameContaining(fullName);
        List<UserDTO> userDTOS = new ArrayList<>();
        for(UserEntity item : userEntities){
            UserDTO userDTO = userConverter.convertToDto(item);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDTO> userDTOS = userConverter.convertToListDto(userEntities);
        return userDTOS;
    }

    @Override
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

}
