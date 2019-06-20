package com.kakao.cstDeIzInq;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.kakao.cstDeIzInq.Mapping;
import com.kakao.cstDeIzInq.domain.ApiResponseMessage;
import com.google.gson.Gson; 
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CstDeIzInqController {

	@RequestMapping(value="/getBaseJsonData", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String jsonReturn(@RequestBody  String param) {
		System.out.println("param : " + param);
		String select = null;
		String brNm = null;
		try {
			JsonParser parser = new JsonParser();
			JsonElement element = parser.parse(param);
			select = element.getAsJsonObject().get("select").getAsString();
			brNm = element.getAsJsonObject().get("brNm").getAsString();
		} catch (Exception e) {
		}
		Gson gson = new Gson();
		String json = null;
		if("1".equals(select)) {
		json = gson.toJson(Mapping.yearMostSumAm());
		}
		else if("2".equals(select)) {
		json = gson.toJson(Mapping.yearNoDe());
		}
		else if("3".equals(select)) {
		json = gson.toJson(Mapping.yearManSumAm());
		}
		else if("4".equals(select)) {
			if ("분당점".equals(brNm) ) {
				ApiResponseMessage apiResponseMessage = new ApiResponseMessage(null, null, null); 
				apiResponseMessage.setHttpstatus("404");
				apiResponseMessage.setCode("404");
				apiResponseMessage.set메세지("br code not found error");
				json = gson.toJson(apiResponseMessage);
			}
			else {
				json = gson.toJson(Mapping.manSumAm(brNm));
			};
		}
		return json;
	}
	
}