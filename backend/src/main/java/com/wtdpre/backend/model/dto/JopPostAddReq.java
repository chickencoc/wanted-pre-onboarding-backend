package com.wtdpre.backend.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JopPostAddReq {

    private Long companyNo;
    private String position;
    private Long reward;
    private String techStack;
    private String content;
}
