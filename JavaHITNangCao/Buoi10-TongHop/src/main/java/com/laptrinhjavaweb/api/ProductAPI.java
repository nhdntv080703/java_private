package com.laptrinhjavaweb.api;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/product")
public class ProductAPI {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct (@Valid @ModelAttribute ProductDTO productDTO,
                                            BindingResult bindingResult

    ) throws IOException {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            bindingResult.getFieldErrors().forEach(
                    error -> errors.put(error.getField(), error.getDefaultMessage())
            );
            String errorMsg = "";
            for (String key : errors.keySet()) {
                errorMsg += "Error in: " + key + ", Reason: " + errors.get(key) + "\n";
            }
            return ResponseEntity.ok(errorMsg);
        }
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }
}
