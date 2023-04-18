package com.example.demo.repository;

import com.example.demo.entity.StudentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    //Tạo 1 danh sách trả về và được phân trang
    List<StudentEntity> findAllByName(String name, Pageable pageable);
}
