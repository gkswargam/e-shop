package com.gkswargam.e_shop.controllers;

import com.gkswargam.e_shop.dtos.CartDto;
import com.gkswargam.e_shop.dtos.CartProductDto;
import com.gkswargam.e_shop.dtos.utils.DtoUtil;
import com.gkswargam.e_shop.models.Cart;
import com.gkswargam.e_shop.services.CartProductService;
import com.gkswargam.e_shop.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/carts")
@RestController
public class CartController {
    private final CartService cartService;
    private final CartProductService cartProductService;

    public CartController(CartService cartService, CartProductService cartProductService) {
        this.cartService = cartService;
        this.cartProductService = cartProductService;
    }

    @PostMapping
    public ResponseEntity<Cart> createCart(@RequestBody CartDto cartDto) {
        return new ResponseEntity<>(cartService.createCart(DtoUtil.convertCartDtoToCart(cartDto)), HttpStatus.CREATED);
    }

    @GetMapping("{cartId}")
    public ResponseEntity<Cart> getCart(@PathVariable Long cartId) {
        return new ResponseEntity<>(cartService.getCart(cartId), HttpStatus.OK);
    }

    @PostMapping("{cartId}/cartProducts")
    public ResponseEntity<Cart> addProductToCart(@PathVariable("cartId") Long cartId,
                                                 @RequestBody CartProductDto cartProductDto) {
        cartProductDto.setCartId(cartId);
        cartProductService.addProductToCart(cartProductDto);
        return new ResponseEntity<>(cartService.getCart(cartId), HttpStatus.OK);
    }

    @DeleteMapping("{cartId}/cartProducts/{cartProductId}")
    public ResponseEntity<Cart> deleteProductFromCart(@PathVariable("cartId") Long cartId,
                                      @PathVariable("cartProductId") Long cartProductId) {
        cartProductService.deleteProductFromCart(cartId, cartProductId);
        return new ResponseEntity<>(cartService.getCart(cartId), HttpStatus.OK);
    }
}
