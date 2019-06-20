package com.kakao.cstDeIzInq.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.google.gson.annotations.SerializedName;
 
@Setter
@Getter
@ToString
public class ApiResponseMessage {
 
  @SerializedName("http status")
   private String httpstatus;

   private String code;

   private String 메세지;

   public ApiResponseMessage(String httpstatus, String code, String 메세지) {
       this.httpstatus = httpstatus;
       this.code = code;
       this.메세지 = 메세지;
   }
}
