package com.gkswargam.e_shop.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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
public class Product extends BaseModel {
    private String name;
    private String description;
    private Double price;
    private Double taxPercentage;
    private Status status;
    @JsonBackReference
    @ManyToOne
    private ProductCategory productCategory;
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartProducts;
}
