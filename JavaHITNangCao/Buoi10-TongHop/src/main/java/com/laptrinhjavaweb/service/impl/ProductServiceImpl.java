package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.ProductService;
import com.laptrinhjavaweb.utils.UploadFileCloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductConverter productConverter;

    @Autowired
    UploadFileCloudinary uploadFileCloudinary;

    @Override
    public ResponseEntity<?> createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = productConverter.converDTOToEntity(productDTO);
        try {
            String urlImage = uploadFileCloudinary.getUrlFromFile(productDTO.getMultipartFile());
            productEntity.setImage(urlImage);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(productConverter.converEntityToDTO(productRepository.save(productEntity)));
    }
}
