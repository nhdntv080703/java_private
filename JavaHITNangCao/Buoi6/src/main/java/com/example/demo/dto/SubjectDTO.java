package com.example.demo.dto;

public class SubjectDTO {
    private String name;

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    private Long student_id;

    public SubjectDTO(){

    }

    public SubjectDTO(String name, String address, Long student_id) {
        this.name = name;
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
