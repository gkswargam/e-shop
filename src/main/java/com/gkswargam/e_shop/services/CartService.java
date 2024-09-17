package com.gkswargam.e_shop.services;

import com.gkswargam.e_shop.models.Cart;
import com.gkswargam.e_shop.repositories.CartRepo;
import org.springframework.stereotype.Service;

@Service
public class CartService implements ICartService {
    private final CartRepo cartRepo;

    public CartService(CartRepo cartRepo) {
        this.cartRepo = cartRepo;
    }

    @Override
    public Cart createCart(Cart cart) {
        return cartRepo.save(cart);
    }

    @Override
    public Cart getCart(Long cartId) {
        return cartRepo.findById(cartId).orElseThrow();
    }
}
