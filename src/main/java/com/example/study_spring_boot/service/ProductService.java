package com.example.study_spring_boot.service;

import com.example.study_spring_boot.dto.record.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<ProductResponse> getAllProduct(Pageable pageable);
}
