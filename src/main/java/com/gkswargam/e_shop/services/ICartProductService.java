package com.gkswargam.e_shop.services;

import com.gkswargam.e_shop.dtos.CartProductDto;
import com.gkswargam.e_shop.models.Cart;
import com.gkswargam.e_shop.models.CartProduct;

public interface ICartProductService {
    CartProduct addProductToCart(CartProductDto cartProductDto);
    void deleteProductFromCart(Long cartId, Long cartProductId);
}
