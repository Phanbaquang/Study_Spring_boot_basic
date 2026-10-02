package com.example.study_spring_boot.service.impl;

import com.example.study_spring_boot.dto.record.ProductResponse;
import com.example.study_spring_boot.entity.Product;
import com.example.study_spring_boot.mapper.Productmapper;
import com.example.study_spring_boot.repository.ProductRepository;
import com.example.study_spring_boot.repository.spec.SpecProduct;
import com.example.study_spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class IProductService implements ProductService {
    private final ProductRepository productRepository;
    private final Productmapper productmapper;

    @Override
    public Page<ProductResponse> getAllProduct(String category, String name, Pageable pageable) {
//        Page<Product> products = productRepository.findAll(pageable);
//        Page<Product> products = productRepository.findAllProductsActive(category, pageable);

        Page<Product> products = productRepository.findAll(SpecProduct.filterProducts(name, BigDecimal.valueOf(1000), category ), pageable);

        return products.map(productmapper::mapProductToResponse);
    }
}
