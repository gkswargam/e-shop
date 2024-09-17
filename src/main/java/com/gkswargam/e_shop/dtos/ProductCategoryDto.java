package com.gkswargam.e_shop.dtos;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class ProductCategoryDto {
    private String name;
    private String description;
    private String status;
}
