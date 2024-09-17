package com.gkswargam.e_shop.controllers;

import com.gkswargam.e_shop.dtos.ProductCategoryDto;
import com.gkswargam.e_shop.dtos.utils.DtoUtil;
import com.gkswargam.e_shop.models.ProductCategory;
import com.gkswargam.e_shop.services.IProductCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/productCategories")
@RestController
public class ProductCategoryController {
    private final Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);
    private final IProductCategoryService productCategoryService;

    public ProductCategoryController(IProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }

    @PostMapping
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody ProductCategoryDto productCategoryDto) {
        logger.info("received request to create new product category: {}", productCategoryDto);
        return new ResponseEntity<>(productCategoryService
                .createProductCategory(DtoUtil.convertProductCategoryDtoToProductCategory(productCategoryDto)), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductCategory> getProductCategory(@PathVariable("id") Long productCategoryId) {
        return new ResponseEntity<>(productCategoryService.getProductCategory(productCategoryId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        return new ResponseEntity<>(productCategoryService.getAllProductCategories(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable("id") Long productCategoryId,
                                        @RequestBody ProductCategoryDto productCategoryDto) {
        return new ResponseEntity<>(productCategoryService.updateProductCategory(productCategoryId,
                DtoUtil.convertProductCategoryDtoToProductCategory(productCategoryDto)), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProductCategory(@PathVariable("id") Long productCategoryId) {
        productCategoryService.deleteProductCategory(productCategoryId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
