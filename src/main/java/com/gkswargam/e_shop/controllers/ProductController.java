package com.gkswargam.e_shop.controllers;

import com.gkswargam.e_shop.dtos.ProductDto;
import com.gkswargam.e_shop.models.Product;
import com.gkswargam.e_shop.services.IProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") Long productId) {
        return new ResponseEntity<>(productService.getProduct(productId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<Product>> getProductsByPageRequest(@RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(productService.getProductsByPageRequest(PageRequest.of(page, size)), HttpStatus.OK);
    }

    @PostMapping("/productCategories")
    public ResponseEntity<List<Product>> getProductsByProductCategories(@RequestBody Collection<Long> productCategoryIds) {
        return new ResponseEntity<>(productService.getProductsByProductCategories(productCategoryIds), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long productId, @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(productService.updateProduct(productId, productDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
