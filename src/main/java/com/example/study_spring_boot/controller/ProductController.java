package com.example.study_spring_boot.controller;

import com.example.study_spring_boot.common.ApiResponse;
import com.example.study_spring_boot.common.BaseController;
import com.example.study_spring_boot.dto.record.ProductResponse;
import com.example.study_spring_boot.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.Sort.Direction.ASC;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController extends BaseController {

    private final ProductService productService;

    @GetMapping
    public ApiResponse<Page<ProductResponse>> index(
            @RequestParam(value = "page_no", defaultValue = "0") int page,
            @RequestParam(value = "page_size", defaultValue = "10") int size,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(name = "sort_by", defaultValue = "id") String sortBy,
            @RequestParam(name = "sort_dir", defaultValue = "asc") String sortDir

    ) {
        Sort sort = sortDir.equalsIgnoreCase(ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);

        return ApiResponse.success(productService.getAllProduct(pageable));

    }

}
