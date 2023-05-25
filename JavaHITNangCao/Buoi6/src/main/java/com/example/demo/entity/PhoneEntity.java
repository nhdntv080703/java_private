package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "phone")
public class PhoneEntity extends BaseEntity{

    @Column
    private String name;

    @Column
    private String brand;

    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentEntity student;

    public PhoneEntity() {
    }

    public PhoneEntity(String name, String brand, StudentEntity studentEntity) {
        this.name = name;
        this.brand = brand;
        this.student = studentEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }
}
