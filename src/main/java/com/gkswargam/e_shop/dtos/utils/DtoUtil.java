package com.gkswargam.e_shop.dtos.utils;

import com.gkswargam.e_shop.dtos.CartDto;
import com.gkswargam.e_shop.dtos.ProductCategoryDto;
import com.gkswargam.e_shop.dtos.ProductDto;
import com.gkswargam.e_shop.models.Cart;
import com.gkswargam.e_shop.models.Product;
import com.gkswargam.e_shop.models.ProductCategory;
import com.gkswargam.e_shop.models.Status;

public class DtoUtil {
    public static ProductCategory convertProductCategoryDtoToProductCategory(ProductCategoryDto productCategoryDto) {
        return ProductCategory.builder()
                .name(productCategoryDto.getName())
                .description(productCategoryDto.getDescription())
                .status(Status.valueOf(productCategoryDto.getStatus()))
                .build();
    }

    public static Product convertProductDtoToProduct(ProductDto productDto, ProductCategory productCategory) {
        return Product.builder()
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .taxPercentage(productDto.getTaxPercentage())
                .status(productDto.getStatus())
                .productCategory(productCategory)
                .build();
    }

    public static Cart convertCartDtoToCart(CartDto cartDto) {
        return Cart.builder()
                .userId(cartDto.getUserId())
                .build();
    }
}
