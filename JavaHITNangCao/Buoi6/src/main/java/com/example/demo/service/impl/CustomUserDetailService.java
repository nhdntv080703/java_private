package com.example.demo.service.impl;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserDetailsImpl;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO userDTO = userService.findOneByUserName(username);
        if (userDTO != null) {
            UserDetails userDetails = UserDetailsImpl.build(userDTO);
            return userDetails;
        } else {
            throw new UsernameNotFoundException("User Not Found with username: " + username);
        }
    }
}
