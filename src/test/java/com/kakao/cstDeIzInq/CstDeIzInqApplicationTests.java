package com.kakao.cstDeIzInq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kakao.cstDeIzInq.domain.DeIz;
import com.kakao.cstDeIzInq.domain.DeIzRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CstDeIzInqApplicationTests {


    @Test
    public void Test() {
    	//given
        String brNm = null;
        
        //when
		Mapping.yearMostSumAm();
		Mapping.yearNoDe();
		Mapping.yearManSumAm();
		Mapping.manSumAm(brNm);

        //then
		assertThat();


    }

}
