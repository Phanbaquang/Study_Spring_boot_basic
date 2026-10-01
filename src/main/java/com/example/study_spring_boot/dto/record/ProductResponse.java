package com.example.study_spring_boot.dto.record;

import java.math.BigDecimal;

public record ProductResponse(
        String id,
        String name,
        BigDecimal price,
        String category,
        String status) {

}
