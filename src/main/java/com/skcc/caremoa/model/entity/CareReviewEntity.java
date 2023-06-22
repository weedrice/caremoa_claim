package com.skcc.caremoa.model.entity;

import com.skcc.caremoa.model.ReviewType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "\"care_review\"", indexes = {
        @Index(name = "review_id_idx", columnList = "id")
})
@Getter
@Setter
@SQLDelete(sql = "UPDATE \"care_review\" SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class CareReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="cont_id")
    private Long contId;
    
    @Column(name="review_type")
    @Enumerated(EnumType.STRING)
    private ReviewType reviewType;

    @Column(name="member_id")
    private Long memberId;

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

    public static CareReviewEntity of(Long contId, Long memberId, ReviewType reviewType) {
        CareReviewEntity entity = new CareReviewEntity();
        entity.setContId(contId);
        entity.setMemberId(memberId);
        entity.setReviewType(reviewType);

        return entity;
    }
}