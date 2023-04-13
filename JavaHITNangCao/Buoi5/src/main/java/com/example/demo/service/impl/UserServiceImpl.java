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
    public ResponseEntity<UserEntity> createUser(UserDTO userDTO) {
        UserEntity userEntity = userConverter.convertToEntity(userDTO);
        if (userRepository.findByUserName(userEntity.getUserName()) != null) {
            throw new AlreadyExistsException("UserEntity already exists with username " + userEntity.getUserName(), HttpStatus.ALREADY_REPORTED);
        }
        UserEntity createdUserEntity = userRepository.save(userEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserEntity);
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(Long id, UserDTO userDTO) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserEntity existingUserEntity = userOptional.get();
            existingUserEntity.setUserName(userDTO.getUserName());
            existingUserEntity.setFullName(userDTO.getFullName());
            existingUserEntity.setPassWord(userDTO.getPassWord());
            userRepository.save(existingUserEntity);
            return ResponseEntity.ok(existingUserEntity);
        } else {
            throw new NotFoundException("UserEntity not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<UserEntity> partialUpdateUser(Long id, UserDTO partialUserDTO) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        UserEntity partialUserEntity = userConverter.convertToEntity(partialUserDTO);
        if (userOptional.isPresent()) {
            UserEntity existingUserEntity = userOptional.get();
            if (partialUserEntity.getUserName() != null) {
                existingUserEntity.setUserName(partialUserEntity.getUserName());
            }
            if (partialUserEntity.getFullName() != null) {
                existingUserEntity.setFullName(partialUserEntity.getFullName());
            }
            if (partialUserEntity.getPassWord() != null) {
                existingUserEntity.setPassWord(partialUserEntity.getPassWord());
            }
            userRepository.save(existingUserEntity);
            return ResponseEntity.ok(existingUserEntity);
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
