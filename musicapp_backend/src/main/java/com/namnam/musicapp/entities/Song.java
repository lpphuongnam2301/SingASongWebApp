package com.namnam.musicapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "songs")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Song extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 300)
    private String name;

    private String thumbnail;
    private String description;
    private int likes;

    @Column(name = "is_official")
    private boolean isOfficial;

    private String video;

    @ManyToOne
    @JoinColumn(name = "composer_id")
    private Composer composer;

    @ManyToOne
    @JoinColumn(name = "singer_id")
    private Singer singer;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
