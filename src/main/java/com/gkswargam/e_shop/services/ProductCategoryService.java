package com.gkswargam.e_shop.services;

import com.gkswargam.e_shop.models.ProductCategory;
import com.gkswargam.e_shop.repositories.ProductCategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService implements IProductCategoryService {
    private final ProductCategoryRepo productCategoryRepo;

    public ProductCategoryService(ProductCategoryRepo productCategoryRepo) {
        this.productCategoryRepo = productCategoryRepo;
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepo.save(productCategory);
    }

    @Override
    public ProductCategory getProductCategory(Long id) {
        return productCategoryRepo.findById(id).orElseThrow();
    }

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepo.findAll();
    }

    @Override
    public ProductCategory updateProductCategory(Long productCategoryId, ProductCategory productCategory) {
        ProductCategory currentProductCategoryItem = productCategoryRepo.findById(productCategoryId).orElseThrow();

        currentProductCategoryItem.setName(productCategory.getName());
        currentProductCategoryItem.setDescription(productCategory.getDescription());
        currentProductCategoryItem.setStatus(productCategory.getStatus());

        return productCategoryRepo.save(currentProductCategoryItem);
    }

    @Override
    public void deleteProductCategory(Long productCategoryId) {
        productCategoryRepo.deleteById(productCategoryId);
    }
}
