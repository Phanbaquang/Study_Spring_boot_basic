package com.example.study_spring_boot.mapper;

import com.example.study_spring_boot.dto.record.ProductResponse;
import com.example.study_spring_boot.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface Productmapper {
    ProductResponse mapProductToResponse(Product product);
}
