package com.kakao.cstDeIzInq;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;

import com.kakao.cstDeIzInq.domain.ManSumAmDTO;
import com.kakao.cstDeIzInq.domain.YearManSumAm1DTO;
import com.kakao.cstDeIzInq.domain.YearManSumAm2DTO;
import com.kakao.cstDeIzInq.domain.YearNoDeDTO;
import com.kakao.cstDeIzInq.domain.YearSumAmDTO;


public class Mapping {
		@PersistenceContext
		private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dataSource");
		private static EntityManager em = emf.createEntityManager();
	    public static List<YearSumAmDTO> yearMostSumAm() {
	 	    
	 	    String sql = "SELECT YEAR, ACCT_NO, SUM_AM FROM ( " + 
		 	    		"SELECT YEAR, A.ACCT_NO, SUM_AM, RANK() OVER(PARTITION BY YEAR ORDER BY SUM_AM DESC) IDX FROM ( " + 
		 	    		"SELECT SUBSTR(DE_DT, 0, 4) YEAR, ACCT_NO, SUM(AM-FE) SUM_AM FROM DE_IZ " + 
		 	    		"WHERE CAN_YN = 'N'" + 
		 	    		"GROUP BY SUBSTR(DE_DT, 0, 4), ACCT_NO " + 
		 	    		") A, ACCT_INF B " + 
		 	    		"WHERE A.ACCT_NO = B.ACCT_NO) " + 
		 	    		"WHERE IDX = 1";
	 	    
	 	    System.out.println(sql);
			Query query = em.createNativeQuery(sql);
	 	
	 	    JpaResultMapper jpaResultMapper = new JpaResultMapper();
	 	    List<YearSumAmDTO> resultList = jpaResultMapper.list(query, YearSumAmDTO.class);
	 		System.out.println(resultList);
	 		
	 		return resultList;
	    }
	    
	    public static List<YearNoDeDTO> yearNoDe() {
	 	    
	 	    String sql = "SELECT A.YEAR, A.ACCT_NO, A.ACCT_NM  FROM " + 
		 	    		"(SELECT * FROM ACCT_INF, " + 
		 	    		"(SELECT DISTINCT SUBSTR(DE_DT, 0, 4) YEAR FROM DE_IZ ) ) A LEFT OUTER JOIN DE_IZ B " + 
		 	    		"ON A.YEAR = SUBSTR(B.DE_DT, 0, 4)  " + 
		 	    		"AND B.CAN_YN = 'N' " + 
		 	    		"AND A.ACCT_NO = B.ACCT_NO " + 
		 	    		"WHERE B.ACCT_NO IS NULL ";
	 	    
	 	    System.out.println(sql);
			Query query = em.createNativeQuery(sql);
	 	
	 	    JpaResultMapper jpaResultMapper = new JpaResultMapper();
	 	    List<YearNoDeDTO> resultList = jpaResultMapper.list(query, YearNoDeDTO.class);
	 		System.out.println(resultList);
	 		
	 		return resultList;
	    }
	    
	    public static List<YearManSumAm2DTO> yearManSumAm() {
	 	    
	 	    String sql = "SELECT MAN_NM, B.MAN_CD, SUM(AM-FE) SUM_AM FROM DE_IZ A, ACCT_INF B, MAN_INF C " + 
	 	    		"WHERE CAN_YN = 'N' " + 
	 	    		"AND A.ACCT_NO = B.ACCT_NO " + 
	 	    		"AND B.MAN_CD = C.MAN_CD " + 
	 	    		"AND SUBSTR(DE_DT, 0, 4) = '2018' " +
	 	    		"GROUP BY MAN_NM, B.MAN_CD " + 
	 	    		"ORDER BY SUM_AM DESC ";
	 	    		
	 	    System.out.println(sql);
			Query query = em.createNativeQuery(sql);
	 	
	 	    JpaResultMapper jpaResultMapper = new JpaResultMapper();
	 	    List<YearManSumAm1DTO> resultList = jpaResultMapper.list(query, YearManSumAm1DTO.class);
	 	    List<YearManSumAm2DTO> result2List = new ArrayList<YearManSumAm2DTO>();
 			YearManSumAm2DTO yearManSumAm2DTO = new YearManSumAm2DTO(null, null);
 			
 			yearManSumAm2DTO.setYear("2018");
 			
	 		yearManSumAm2DTO.setYearManSumAm1DTO(resultList);
	 		
	 		result2List.add(yearManSumAm2DTO);
	 		System.out.println(result2List.get(0).getYear());
	 	    sql = "SELECT MAN_NM, B.MAN_CD, SUM(AM-FE) SUM_AM FROM DE_IZ A, ACCT_INF B, MAN_INF C " + 
	 	    		"WHERE CAN_YN = 'N' " + 
	 	    		"AND A.ACCT_NO = B.ACCT_NO " + 
	 	    		"AND B.MAN_CD = C.MAN_CD " + 
	 	    		"AND SUBSTR(DE_DT, 0, 4) = '2019' " +
	 	    		"GROUP BY MAN_NM, B.MAN_CD " + 
	 	    		"ORDER BY SUM_AM DESC ";
	 	    		
	 	    System.out.println(sql);
			em.createNativeQuery(sql);
	 	
	 	    //resultList = jpaResultMapper.list(query, YearManSumAm1DTO.class);
	 	   
 			//yearManSumAm2DTO.setYear("2019");
	 		
	 		//yearManSumAm2DTO.setYearManSumAm1DTO(resultList);	 			
	 			
	 		//result2List.add(yearManSumAm2DTO);
	 		System.out.println(result2List.get(0).getYear());
	 		return result2List;
	    }
	    
		public static List<ManSumAmDTO> manSumAm(String brNm) {
	 	    
	 	    String sql = "SELECT MAN_NM, B.MAN_CD, SUM(AM-FE) SUM_AM FROM DE_IZ A, ACCT_INF B, MAN_INF C " + 
		 	    		"WHERE CAN_YN = 'N' " + 
		 	    		"AND A.ACCT_NO = B.ACCT_NO " + 
		 	    		"AND B.MAN_CD = C.MAN_CD " + 
		 	    		"AND MAN_NM = '" + brNm + "' "+
		 	    		"GROUP BY MAN_NM, B.MAN_CD";
	 	    
	 	    System.out.println(sql);
			Query query = em.createNativeQuery(sql);
	 	
	 	    JpaResultMapper jpaResultMapper = new JpaResultMapper();
	 	    List<ManSumAmDTO> resultList = jpaResultMapper.list(query, ManSumAmDTO.class);
	 		System.out.println(resultList);

	 		return resultList;
	    }
	}


