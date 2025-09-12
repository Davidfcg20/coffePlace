package com.dbc.coffeePlaces.persistence.companies.entities;

import com.dbc.coffeePlaces.persistence.locations.entities.Location;
import com.dbc.coffeePlaces.persistence.profiles.entities.Profile;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne()
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Location> locations;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;
}
