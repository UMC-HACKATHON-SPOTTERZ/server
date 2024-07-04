package com.umc.hackaton.snapspot.savespot.entity;

import com.umc.hackaton.snapspot.config.entity.BaseEntity;
import com.umc.hackaton.snapspot.spot.entity.Spot;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpotSave extends BaseEntity {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userfolder_id")
    private UserFolder userFolder;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "spot_id")
    private Spot spot;

}
