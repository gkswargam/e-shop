package com.gkswargam.e_shop.repositories;

import com.gkswargam.e_shop.models.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepo extends JpaRepository<CartProduct, Long> {
}
