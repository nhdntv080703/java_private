package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "student")
public class StudentEntity extends BaseEntity{

    public StudentEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Column
    private String name;

    @Column
    private String address;

    @JsonManagedReference// tránh vòng lặp vô hạn, gọi vào thằng cha
    @OneToMany(mappedBy = "studentEntity", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SubjectEntity> subjectEntities;

    @JsonIgnore// không chạy, không cho hiển thị
    @OneToOne(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private PhoneEntity phoneEntity;


    public StudentEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<SubjectEntity> getSubjectEntities() {
        return subjectEntities;
    }

    public void setSubjectEntities(List<SubjectEntity> subjectEntities) {
        this.subjectEntities = subjectEntities;
    }

    public PhoneEntity getPhoneEntity() {
        return phoneEntity;
    }

    public void setPhoneEntity(PhoneEntity phoneEntity) {
        this.phoneEntity = phoneEntity;
    }
}
