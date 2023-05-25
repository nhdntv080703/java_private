package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<?> createProduct(ProductDTO productDTO);
}
