package com.mico_springboot.ProductService.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;
import java.math.BigDecimal;

@Entity
@Table(name="Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String name;
    private String description;
    private BigDecimal price;
}
