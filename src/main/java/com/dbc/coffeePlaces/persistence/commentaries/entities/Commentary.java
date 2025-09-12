package com.dbc.coffeePlaces.persistence.commentaries.entities;

import com.dbc.coffeePlaces.persistence.reviews.entities.Review;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commentaries")
public class Commentary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "is_vegan_friendly")
    private Boolean isVeganFriendly;

    @Column(name = "has_vegan_snack")
    private Boolean hasVeganSnack;

    @OneToMany(mappedBy = "commentary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;
}
