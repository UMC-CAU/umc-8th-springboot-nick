package umc.spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.spring.global.BaseEntity;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String body;

    private Float score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    @Setter
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    @Setter
    private Store store;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<ReviewImage> reviewImageList;

    @Builder
    public Review(String title, String body, Float score, Member member, Store store) {
        this.title = title;
        this.body = body;
        this.score = score;
        this.member = member;
        this.store = store;
    }
}
