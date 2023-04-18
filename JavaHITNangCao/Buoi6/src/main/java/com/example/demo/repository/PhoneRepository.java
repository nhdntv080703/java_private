package com.example.demo.repository;

import com.example.demo.entity.PhoneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneEntity, Long> {
}
