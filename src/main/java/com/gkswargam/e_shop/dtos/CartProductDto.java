package com.gkswargam.e_shop.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartProductDto {
    private Long cartId;
    private Long productId;
    private Integer productCount;
}
