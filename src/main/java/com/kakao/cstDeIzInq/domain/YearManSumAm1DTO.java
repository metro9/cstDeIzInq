package com.kakao.cstDeIzInq.domain;

import java.math.BigInteger;

public class YearManSumAm1DTO {

	private String brName;
	private String brCode;
	private BigInteger sumAmt;
	
	public void setBrName(String brName) {
		this.brName = brName;
	}
	
	public void setBrCode(String brcode) {
		this.brCode = brcode;
	}
	
	public void setSumAmt(BigInteger sumAmt) {
		this.sumAmt = sumAmt;
	}
	
    public YearManSumAm1DTO(String brName, String brCode, BigInteger sumAmt) {
        this.brName = brName;
        this.brCode = brCode;
        this.sumAmt = sumAmt;
    }

}
