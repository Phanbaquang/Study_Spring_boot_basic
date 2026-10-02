package com.example.study_spring_boot.mapper;

import com.example.study_spring_boot.dto.record.ProductResponse;
import com.example.study_spring_boot.entity.Product;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-02T14:39:02+0700",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.12 (Microsoft)"
)
@Component
public class ProductmapperImpl implements Productmapper {

    @Override
    public ProductResponse mapProductToResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        String id = null;
        String name = null;
        BigDecimal price = null;
        String category = null;
        String status = null;

        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        category = product.getCategory();
        status = product.getStatus();

        ProductResponse productResponse = new ProductResponse( id, name, price, category, status );

        return productResponse;
    }
}
