package com.namnam.musicapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "singasong")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SingASong extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rating_point")//1-5 avg
    private Float ratingPoint;

    @Column(name = "total_rated")
    private int totalRated;

    private String description;

    @Column(name = "views")
    private int views;

    @Column(name = "likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name = "song_id")
    private Song song;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
