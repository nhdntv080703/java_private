package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
