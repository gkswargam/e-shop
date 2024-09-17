package com.gkswargam.e_shop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Builder
@Setter
@Getter
@Entity
public class Cart extends BaseModel {
    private Long userId;
    @JsonManagedReference
    @OneToMany(mappedBy = "cart")
    private List<CartProduct> cartProducts;
}
