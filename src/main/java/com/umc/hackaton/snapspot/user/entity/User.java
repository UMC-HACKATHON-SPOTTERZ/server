package com.umc.hackaton.snapspot.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.umc.hackaton.snapspot.config.entity.BaseEntity;
import com.umc.hackaton.snapspot.savespot.entity.UserFolder;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Users")
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

    public void updateProfileImg(String profileImg) {
        this.profileImg = profileImg;
    }

    @ToString.Exclude
    @JsonManagedReference
    @OrderBy("id")
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private final Set<UserFolder> userFolders = new LinkedHashSet<>();
}
