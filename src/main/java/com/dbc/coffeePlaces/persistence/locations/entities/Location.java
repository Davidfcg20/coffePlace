package com.dbc.coffeePlaces.persistence.locations.entities;

import com.dbc.coffeePlaces.persistence.companies.entities.Company;
import com.dbc.coffeePlaces.persistence.reviews.entities.Review;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address")
    private String address;

    //Task create this table
    @Column(name = "country")
    private String country;

    //Task create this table
    @Column(name = "city")
    private String city;

    @Column(name = "neighborhood")
    private String neighborhood;

    @ManyToOne()
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;

}
