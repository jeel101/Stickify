package com.eazybytes.eazystore.controller;

import com.eazybytes.eazystore.dto.ErrorResponseDto;
import com.eazybytes.eazystore.dto.ProductDto;
import com.eazybytes.eazystore.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor     //we are autowiring ProductServiceImpl inside ProductController without writing constructor using lombok
// @tRequiredArgsConstrucor Works only on final fields or fields annotated with @NonNull
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    private final IProductService iProductService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(){  //DTO pattern
        List<ProductDto> productList = iProductService.getProducts();
        return ResponseEntity.ok().body(productList);
    }
}
