package com.gkswargam.e_shop.repositories;

import com.gkswargam.e_shop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query(value = "SELECT p FROM Product p WHERE p.productCategory.id IN :productCategoryIds")
    List<Product> findProductsByProductCategoryIds(@Param("productCategoryIds") Collection<Long> productCategoryIds);
}
