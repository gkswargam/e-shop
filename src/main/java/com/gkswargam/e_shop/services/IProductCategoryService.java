package com.gkswargam.e_shop.services;

import com.gkswargam.e_shop.models.ProductCategory;

import java.util.List;

public interface IProductCategoryService {
    ProductCategory createProductCategory(ProductCategory productCategory);
    ProductCategory getProductCategory(Long productCategoryId);
    List<ProductCategory> getAllProductCategories();
    ProductCategory updateProductCategory(Long productCategoryId, ProductCategory productCategory);
    void deleteProductCategory(Long productCategoryId);
}
