package com.skcc.caremoa.model.entity;

import com.skcc.caremoa.model.ClaimStatus;
import com.skcc.caremoa.model.ClaimType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "\"claim\"")
@Getter
@Setter
@SQLDelete(sql = "UPDATE \"claim\" SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class ClaimEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "review_id")
    private Long reviewId;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ClaimStatus claimStatus;

    @Column(name = "claimType")
    @Enumerated(EnumType.STRING)
    private ClaimType claimType;

    @Column(name = "claimContents")
    private String claimContents;

    @Column(name ="registered_at")
    private Timestamp registeredAt;

    @Column(name ="updated_at")
    private Timestamp updatedAt;

    @Column(name ="deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt() {
        this.registeredAt = Timestamp.from(Instant.now());
    }

    @PreUpdate
    void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public static ClaimEntity of(Long reviewId, ClaimStatus claimStatus, ClaimType claimType, String claimContents) {
        ClaimEntity claimEntity = new ClaimEntity();
        claimEntity.setReviewId(reviewId);
        claimEntity.setClaimStatus(claimStatus);
        claimEntity.setClaimType(claimType);
        claimEntity.setClaimContents(claimContents);

        return claimEntity;
    }
}
