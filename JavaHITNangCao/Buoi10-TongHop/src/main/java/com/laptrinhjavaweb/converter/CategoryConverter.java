package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {
    @Autowired
    ModelMapper modelMapper;

    public CategoryEntity converDTOToEntity(CategoryDTO categoryDTO){
        CategoryEntity categoryEntity = modelMapper.map(categoryDTO, CategoryEntity.class);
        return categoryEntity;
    }

    public CategoryDTO converEntityToDTO(CategoryEntity categoryEntity){
        CategoryDTO categoryDTO = modelMapper.map(categoryEntity, CategoryDTO.class);
        return categoryDTO;
    }
}
