package com.dbc.coffeePlaces.persistence.consumptions_products.entities;

import com.dbc.coffeePlaces.persistence.consumptions.entities.Consumption;
import com.dbc.coffeePlaces.persistence.products.entities.Product;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "consumptions_products")
public class ConsumptionProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "price")
    private Float price;

    @ManyToOne()
    @JoinColumn(name = "consumption_id")
    private Consumption consumption;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;


    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;
}
