package com.gkswargam.e_shop.services;

import com.gkswargam.e_shop.dtos.CartProductDto;
import com.gkswargam.e_shop.models.Cart;
import com.gkswargam.e_shop.models.CartProduct;
import com.gkswargam.e_shop.models.Product;
import com.gkswargam.e_shop.repositories.CartProductRepo;
import com.gkswargam.e_shop.repositories.CartRepo;
import com.gkswargam.e_shop.repositories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CartProductService implements ICartProductService {
    private final CartProductRepo cartProductRepo;
    private final CartRepo cartRepo;
    private final ProductRepo productRepo;

    public CartProductService(CartProductRepo cartProductRepo, CartRepo cartRepo, ProductRepo productRepo) {
        this.cartProductRepo = cartProductRepo;
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    @Override
    public CartProduct addProductToCart(CartProductDto cartProductDto) {
        Optional<Cart> cart = cartRepo.findById(cartProductDto.getCartId());
        if(cart.isEmpty()) {
            throw new NoSuchElementException("cartId = " + cartProductDto.getCartId() + " not found");
        }

        Optional<Product> product = productRepo.findById(cartProductDto.getProductId());
        if(product.isEmpty()) {
            throw new NoSuchElementException("productId = " + cartProductDto.getProductId() + " not found");
        }

        Double totalPrice = product.get().getPrice() * cartProductDto.getProductCount();

        CartProduct cartProduct = CartProduct.builder()
                .cart(cart.get())
                .product(product.get())
                .count(cartProductDto.getProductCount())
                .totalPrice(totalPrice)
                .build();
        return cartProductRepo.save(cartProduct);
    }

    @Override
    public void deleteProductFromCart(Long cartId, Long cartProductId) {
        cartProductRepo.deleteById(cartProductId);
    }
}
