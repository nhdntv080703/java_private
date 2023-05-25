package com.laptrinhjavaweb.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

public class ProductDTO {

    @NotBlank(message = "Name is not empty and null")
    private String productName;

    @NotBlank(message = "Count is not empty and null")
    private String count;

    private MultipartFile multipartFile;

    private String description;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
