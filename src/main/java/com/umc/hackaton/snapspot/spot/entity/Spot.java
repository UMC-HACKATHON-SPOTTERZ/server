package com.umc.hackaton.snapspot.spot.entity;

import com.umc.hackaton.snapspot.config.entity.BaseEntity;
import com.umc.hackaton.snapspot.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "spot")
public class Spot extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "img_url", nullable = false)
    private String imgUrl;

    @Column(name = "like_num")
    private Long likeNum = 0L;

    @Column(name = "visit_num")
    private Long visitNum =0L;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    public void increaseLike() {
        this.likeNum  -= 1;
    }

    public void decreaseLike() {
        this.likeNum  += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spot spot = (Spot) o;
        return Objects.equals(id, spot.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
