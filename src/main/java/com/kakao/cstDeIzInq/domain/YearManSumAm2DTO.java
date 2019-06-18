package com.kakao.cstDeIzInq.domain;

import java.util.List;

public class YearManSumAm2DTO {
	private String year;
	private List<YearManSumAm1DTO> yearManSumAm1DTO;
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public void setYearManSumAm1DTO(List<YearManSumAm1DTO> yearManSumAm1DTO) {
		this.yearManSumAm1DTO = yearManSumAm1DTO;
	}
	
    public YearManSumAm2DTO(String year, List<YearManSumAm1DTO> yearManSumAm1DTO) {
        this.year = year;
        this.yearManSumAm1DTO = yearManSumAm1DTO;
    }
}
