package com.gkswargam.e_shop.services;

import com.gkswargam.e_shop.models.Cart;

public interface ICartService {
    Cart createCart(Cart cart);
    Cart getCart(Long cartId);
}
