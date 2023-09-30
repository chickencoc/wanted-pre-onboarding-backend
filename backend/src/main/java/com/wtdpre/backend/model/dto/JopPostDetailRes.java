package com.wtdpre.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JopPostDetailRes {

    private Long jopPostNo;
    private String position;
    private Long reward;
    private String techStack;
    private String content;

    private String companyName;
    private String companyCountry;
    private String companyCity;

    private List<Long> jopPostNoList;
}
