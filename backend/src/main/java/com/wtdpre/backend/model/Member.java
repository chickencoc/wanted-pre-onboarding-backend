package com.wtdpre.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(columnDefinition = "varchar(100) comment '사용자이메일'", nullable = false)
    private String email;

}



