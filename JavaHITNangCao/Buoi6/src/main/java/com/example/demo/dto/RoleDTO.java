package com.example.demo.dto;

public class RoleDTO {

	private static final long serialVersionUID = 5830885581031027382L;

	private Long id;
    private String name;
    private String code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}    
}
