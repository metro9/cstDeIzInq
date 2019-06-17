package com.kakao.cstDeIzInq.domain;

import java.math.BigInteger;

public class YearManSumAmDTO {
    private String year;
    private String brName;
    private String brCode;
    private BigInteger sumAmt;
    public YearManSumAmDTO(String year, String brName, String brCode, BigInteger sumAmt) {
        this.year = year;
        this.brName = brName;
        this.brCode = brCode;
        this.sumAmt = sumAmt;
    }
}
