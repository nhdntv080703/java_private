package com.example.demo.service;

import com.example.demo.dto.RoleDTO;


import java.util.List;
import java.util.Map;

public interface IRoleService {
	List<RoleDTO> findAll();
	Map<String,String> getRoles();
}
