package com.gkswargam.e_shop.services;

import com.gkswargam.e_shop.dtos.ProductDto;
import com.gkswargam.e_shop.dtos.utils.DtoUtil;
import com.gkswargam.e_shop.models.Product;
import com.gkswargam.e_shop.models.ProductCategory;
import com.gkswargam.e_shop.repositories.ProductCategoryRepo;
import com.gkswargam.e_shop.repositories.ProductRepo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    private final ProductRepo productRepo;
    private final ProductCategoryRepo productCategoryRepo;

    public ProductService(ProductRepo productRepo, ProductCategoryRepo productCategoryRepo) {
        this.productRepo = productRepo;
        this.productCategoryRepo = productCategoryRepo;
    }

    @Override
    public Product createProduct(ProductDto productDto) {
        Optional<ProductCategory> productCategory = productCategoryRepo.findById(productDto.getProductCategoryId());
        return productCategory.map(category -> productRepo.save(DtoUtil.convertProductDtoToProduct(productDto, category))).orElseThrow();
    }

    @Override
    public Product getProduct(Long productId) {
        return productRepo.findById(productId).orElseThrow();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Page<Product> getProductsByPageRequest(PageRequest pageRequest) {
        return productRepo.findAll(pageRequest);
    }

    @Override
    public List<Product> getProductsByProductCategories(Collection<Long> productCategoryIds) {
        return productRepo.findProductsByProductCategoryIds(productCategoryIds);
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDto) {
        Product product = productRepo.findById(productId).orElseThrow();

        Optional<ProductCategory> productCategory = productCategoryRepo.findById(productDto.getProductCategoryId());

        if(productCategory.isPresent()) {
            product.setProductCategory(productCategory.get());
        } else {
            throw new NoSuchElementException("product category: " + productDto.getProductCategoryId() + " not found ");
        }

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setTaxPercentage(productDto.getTaxPercentage());
        product.setStatus(productDto.getStatus());

        return productRepo.save(product);
    }

    @Override
    public void deleteProduct(Long productId) {
        productRepo.deleteById(productId);
    }
}
