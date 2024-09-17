package com.gkswargam.e_shop.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Builder
@Setter
@Getter
@Entity
public class ProductCategory extends BaseModel {
    private String name;
    private String description;
    private Status status;
    @JsonManagedReference
    @OneToMany(mappedBy = "productCategory", fetch = FetchType.EAGER)
    private List<Product> products;
}
