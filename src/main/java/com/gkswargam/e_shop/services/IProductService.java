package com.gkswargam.e_shop.services;

import com.gkswargam.e_shop.dtos.ProductDto;
import com.gkswargam.e_shop.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface IProductService {
    Product createProduct(ProductDto productDto);
    Product getProduct(Long productId);
    List<Product> getAllProducts();
    Page<Product> getProductsByPageRequest(PageRequest pageRequest);
    List<Product> getProductsByProductCategories(Collection<Long> productCategoryIds);
    Product updateProduct(Long productId, ProductDto productDto);
    void deleteProduct(Long productId);
}
