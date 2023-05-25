package com.laptrinhjavaweb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserDTO {

    private String fullName;
    private String address;
    private String email;
    private Date birthday;
    private String userName;
    private String passWord;

}
