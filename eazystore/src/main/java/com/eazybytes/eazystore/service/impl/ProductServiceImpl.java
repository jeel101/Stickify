package com.eazybytes.eazystore.service.impl;

import com.eazybytes.eazystore.entity.Product;
import com.eazybytes.eazystore.dto.ProductDto;
import com.eazybytes.eazystore.repository.ProductRepository;
import com.eazybytes.eazystore.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
//we are injecting something like this
//Controller → Service → Repository

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {
    private final ProductRepository productRepository;
    @Cacheable("products")
    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll()
                .stream().map(this::transformtoDTO).collect(Collectors.toList());
    }

    private ProductDto transformtoDTO (Product product) {
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        return productDto;
    }
}
