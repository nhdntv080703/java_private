package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ProductEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    @Autowired
    ModelMapper modelMapper;

    public ProductEntity converDTOToEntity(ProductDTO productDTO){
        ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
        return productEntity;
    }

    public ProductDTO converEntityToDTO(ProductEntity productEntity){
        ProductDTO productDTO = modelMapper.map(productEntity, ProductDTO.class);
        return productDTO;
    }
}
