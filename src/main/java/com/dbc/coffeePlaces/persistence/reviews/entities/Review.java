package com.dbc.coffeePlaces.persistence.reviews.entities;

import com.dbc.coffeePlaces.persistence.commentaries.entities.Commentary;
import com.dbc.coffeePlaces.persistence.locations.entities.Location;
import com.dbc.coffeePlaces.persistence.ratings.entities.Rating;
import com.dbc.coffeePlaces.persistence.statuses.entities.Status;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "general_opinion")
    private String generalOpinion;

    @ManyToOne()
    @JoinColumn(name = "location_id")
    private Location location;

    @ManyToOne()
    @JoinColumn(name = "rating_id")
    private Rating rating;

    @ManyToOne()
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne()
    @JoinColumn(name = "commentary_id")
    private Commentary commentary;

    @CreationTimestamp
    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime updateAt;
}
