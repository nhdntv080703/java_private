package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.AlreadyExistsException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDTO findOneByUserNameAndStatus(String name, int status) {
        return userConverter.convertToDto(userRepository.findOneByUserNameAndStatus(name, status));
    }

    @Override
    public List<UserDTO> getUsers(String searchValue, Pageable pageable) {
        Page<UserEntity> users = null;
        users = userRepository.findByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0, pageable);
        List<UserEntity> newsEntities = users.getContent();
        List<UserDTO> result = new ArrayList<>();
        for (UserEntity userEntity : newsEntities) {
            UserDTO userDTO = userConverter.convertToDto(userEntity);
            userDTO.setRoleCode(userEntity.getRoles().get(0).getCode());
            result.add(userDTO);
        }
        return result;
    }

    @Override
    public int getTotalItems(String searchValue) {
        int totalItem = 0;
        totalItem = (int) userRepository.countByUserNameContainingIgnoreCaseOrFullNameContainingIgnoreCaseAndStatusNot(searchValue, searchValue, 0);
        return totalItem;
    }

    @Override
    public UserDTO findOneByUserName(String userName) {
        UserEntity userEntity = userRepository.findOneByUserName(userName);
        UserDTO userDTO = userConverter.convertToDto(userEntity);
        return userDTO;
    }

    @Override
    public UserDTO findUserById(Long id) {
        UserEntity entity = userRepository.findById(id).get();
        List<RoleEntity> roles = entity.getRoles();
        UserDTO dto = userConverter.convertToDto(entity);
        roles.forEach(item -> {
            dto.setRoleCode(item.getCode());
        });
        return dto;
    }

    @Override
    @Transactional
    public UserDTO insert(UserDTO newUser) {
        RoleEntity role = roleRepository.findOneByCode(newUser.getRoleCode());
        UserEntity userEntity = userConverter.convertToEntity(newUser);
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        userEntity.setStatus(1);
        userEntity.setPassword(newUser.getPassWord());
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public UserDTO update(Long id, UserDTO updateUser) {
        RoleEntity role = roleRepository.findOneByCode(updateUser.getRoleCode());
        UserEntity oldUser = userRepository.findById(id).get();
        UserEntity userEntity = userConverter.convertToEntity(updateUser);
        userEntity.setUserName(oldUser.getUserName());
        userEntity.setStatus(oldUser.getStatus());
        userEntity.setRoles(Stream.of(role).collect(Collectors.toList()));
        userEntity.setPassword(oldUser.getPassword());
        return userConverter.convertToDto(userRepository.save(userEntity));
    }

    @Override
    public UserDTO resetPassword(long id) {
        return null;
    }

    @Override
    @Transactional
    public UserDTO updateProfileOfUser(String username, UserDTO updateUser) {
        UserEntity oldUser = userRepository.findOneByUserName(username);
        oldUser.setFullName(updateUser.getFullName());
        return userConverter.convertToDto(userRepository.save(oldUser));
    }

    @Override
    @Transactional
    public void delete(Long[] ids) {
        for (Long item : ids) {
            UserEntity userEntity = userRepository.findById(item).get();
            userEntity.setStatus(0);
            userRepository.save(userEntity);
        }
    }

    @Override
    public Map<Long, String> getStaffMaps() {
        Map<Long, String> results = new HashMap<>();
        List<UserEntity> staffS = userRepository.findByStatusAndRoles_Code(1, "STAFF");
        for (UserEntity userEntity : staffS){
            results.put(userEntity.getId(), userEntity.getFullName());
        }
        return results;
    }

    @Override
    public List<UserDTO> findUsersByStaffIds(List<Long> staffIds) {
        List<UserDTO> staffs = new ArrayList<>();
        for (Long item : staffIds){
            UserDTO userDTO = findUserById(item);
            staffs.add(userDTO);
        }
        return staffs;
    }

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
                existingUserEntity.setPassword(partialUserDTO.getPassWord());
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
