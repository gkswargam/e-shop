package com.gkswargam.e_shop.dtos;

import com.gkswargam.e_shop.models.Status;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ProductDto {
    private String name;
    private String description;
    private Double price;
    private Double taxPercentage;
    private Status status;
    private Long productCategoryId;
}
