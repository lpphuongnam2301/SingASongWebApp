package com.namnam.musicapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "singers")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Singer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "day_of_birth")
    private Date dayOfBirth;

    private String description;
    private String thumbnail;

    @Column(name = "official_link")
    private String officialLink;

    @Column(name = "likes")
    private int likes;
}
