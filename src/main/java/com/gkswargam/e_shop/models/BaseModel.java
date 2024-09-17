package com.gkswargam.e_shop.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@ToString
@Getter
@MappedSuperclass
public class BaseModel {
//    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @JsonIgnore
    @CreationTimestamp
    private Date createdAt;
//    @JsonIgnore
    @UpdateTimestamp
    private Date updatedAt;
}
