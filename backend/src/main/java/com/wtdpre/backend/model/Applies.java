package com.wtdpre.backend.model;

import com.wtdpre.backend.model.timeEntity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Applies extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @ManyToOne
    @JoinColumn(name = "jop_post_no")
    private JopPost jopPost;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

    public static Applies toEntity(Member member, JopPost jopPost) {
        return Applies.builder()
                .member(member)
                .jopPost(jopPost)
                .build();
    }

}



