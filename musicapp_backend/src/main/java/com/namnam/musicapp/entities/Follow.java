package com.namnam.musicapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "follows")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Follow extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private User follower;

    @ManyToOne
    @JoinColumn(name = "following_id")
    private User following;


}
