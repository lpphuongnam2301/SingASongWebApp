package com.namnam.musicapp.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "comments")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name = "sing_a_song_id")
    private SingASong singASong;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
