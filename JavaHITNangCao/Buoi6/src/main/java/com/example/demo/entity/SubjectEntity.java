package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "subject")
public class SubjectEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    //EAGER : Load data của chính entity gốc và những thằng liên quan
    //LAZY  : Cái nào được gọi thì chỉ được load mình data của cái đó , k load các thằng liên quan
    //tìm hiểu tại sao để LAZY ở thằng Many to one lại lỗi ?
    @JsonBackReference// sử dụng cho thằng con
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private StudentEntity studentEntity;

    public SubjectEntity() {
    }

    public SubjectEntity(String name, StudentEntity studentEntity) {
        this.name = name;
        this.studentEntity = studentEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }
}
