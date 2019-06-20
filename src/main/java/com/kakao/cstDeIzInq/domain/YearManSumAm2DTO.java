package com.kakao.cstDeIzInq.domain;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class YearManSumAm2DTO {
	private String year;
	@SerializedName("")
	private List<YearManSumAm1DTO> yearManSumAm1DTO;
	
	public void setYearManSumAm1DTO(List<YearManSumAm1DTO> yearManSumAm1DTO) {
		this.yearManSumAm1DTO = yearManSumAm1DTO;
	}
	
    public YearManSumAm2DTO(String year, List<YearManSumAm1DTO> yearManSumAm1DTO) {
        this.year = year;
        this.yearManSumAm1DTO = yearManSumAm1DTO;
    }
}
