package com.example.study_spring_boot.service.impl;

import com.example.study_spring_boot.dto.record.ProductResponse;
import com.example.study_spring_boot.entity.Product;
import com.example.study_spring_boot.mapper.Productmapper;
import com.example.study_spring_boot.repository.ProductRepository;
import com.example.study_spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IProductService implements ProductService {
    private final ProductRepository productRepository;
    private final Productmapper productmapper;
    @Override
    public Page<ProductResponse> getAllProduct(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return products.map(productmapper::mapProductToResponse);
    }
}
