package com.example.study_spring_boot.repository.spec;

import ch.qos.logback.core.util.StringUtil;
import com.example.study_spring_boot.entity.Product;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SpecProduct {

    public static Specification<Product> filterProducts(String name, BigDecimal price, String category){
         return ((root, query,  criteriaBuilder) -> {
             List<Predicate> predicates = new ArrayList<>();

             if(StringUtils.hasText(name)){
                 predicates.add((criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%")));
             }
             return  criteriaBuilder.and(predicates.toArray(predicates.toArray(new Predicate[0])));
         });
    }
}
