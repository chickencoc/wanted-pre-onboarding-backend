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
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(columnDefinition = "varchar(100) comment '회사명'", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(100) comment '국가'", nullable = false)
    private String country;

    @Column(columnDefinition = "varchar(100) comment '지역'", nullable = false)
    private String city;

}



