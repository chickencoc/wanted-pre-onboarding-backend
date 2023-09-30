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
public class JopPost extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(columnDefinition = "varchar(300) comment '채용포지션'", nullable = false)
    private String position;

    @Column(columnDefinition = "bigint comment '채용보상금'", nullable = false)
    private Long reward;

    @Column(columnDefinition = "varchar(100) comment '사용기술'", nullable = false)
    private String techStack;

    @Column(columnDefinition = "text comment '채용내용'", nullable = false)
    private String content;

}



