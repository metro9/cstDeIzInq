package com.kakao.cstDeIzInq.domain;

import java.math.BigInteger;

public class YearSumAmDTO {
    private String year;
    private String acctNo;
    private BigInteger sumAmt;
    public YearSumAmDTO(String year, String acctNo, BigInteger sumAmt) {
        this.year = year;
        this.acctNo = acctNo;
        this.sumAmt = sumAmt;
    }
}
