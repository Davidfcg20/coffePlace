package com.dbc.coffeePlaces.persistence.consumptions.entities;

import com.dbc.coffeePlaces.persistence.consumptions_products.entities.ConsumptionProduct;
import com.dbc.coffeePlaces.persistence.locations.entities.Location;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "consumptions")
public class Consumption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "consumption", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ConsumptionProduct>  consumptionsProducts;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;
}
