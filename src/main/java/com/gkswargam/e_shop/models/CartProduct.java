package com.gkswargam.e_shop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Builder
@Setter
@Getter
@Entity
public class CartProduct extends BaseModel {
    @JsonBackReference
    @ManyToOne
    private Cart cart;
    @JsonBackReference
    @ManyToOne
    private Product product;
    private Integer count;
    private Double totalPrice;
}
