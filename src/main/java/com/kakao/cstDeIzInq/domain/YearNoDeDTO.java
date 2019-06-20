package com.kakao.cstDeIzInq.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class YearNoDeDTO {
    private String year;
    private String name;
    private String acctNo;
    public YearNoDeDTO(String year, String name, String acctNo) {
        this.year = year;
        this.name = name;
        this.acctNo = acctNo;
    }
}
