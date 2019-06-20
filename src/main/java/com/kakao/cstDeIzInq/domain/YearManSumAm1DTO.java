package com.kakao.cstDeIzInq.domain;

import java.math.BigInteger;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class YearManSumAm1DTO {

	private String brName;
	private String brCode;
	private BigInteger sumAmt;
	
    public YearManSumAm1DTO(String brName, String brCode, BigInteger sumAmt) {
        this.brName = brName;
        this.brCode = brCode;
        this.sumAmt = sumAmt;
    }

}
