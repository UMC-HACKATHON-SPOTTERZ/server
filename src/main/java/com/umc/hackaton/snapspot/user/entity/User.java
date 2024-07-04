package com.umc.hackaton.snapspot.user.entity;

import com.umc.hackaton.snapspot.config.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "profile_img", nullable = false)
    private String profileImg;

    @PrePersist
    public void prePersist() {
        if (this.profileImg == null || this.profileImg.isEmpty()) {
            this.profileImg = "default";
        }
    }
}
