package com.wtdpre.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JopPostListRes {

    private Long jopPostNo;
    private String position;
    private Long reward;
    private String techStack;

    private String companyName;
    private String companyCountry;
    private String companyCity;
}
