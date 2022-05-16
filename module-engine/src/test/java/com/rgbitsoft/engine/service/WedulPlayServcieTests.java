package com.rgbitsoft.engine.service;

import com.rgbitsoft.engine.index.WedulPlay;
import com.rgbitsoft.engine.repository.WedulPlayRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.Before;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import org.hamcrest.core.IsNull;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
//SpringBootConfiguration
public class WedulPlayServcieTests {

    @Autowired
    private WedulPlayService wedulPlayService;

//    @Autowired(required = true)
//    @Qualifier(value = "wedulPlayRepository")
//    WedulPlayRepository wedulPlayRepository;

    @BeforeEach
    public void setup() {
        //wedulPlayService = new WedulPlayService(wedulPlayRepository);

        wedulPlayService.save(WedulPlay.builder().title("안녕 이건 테스트야").user("위들").startAt(1242421424).endAt(23214124).build());
        wedulPlayService.save(WedulPlay.builder().title("안녕 이건 테스트야").user("강남스타일").startAt(1242421424).endAt(23214124).build());
        wedulPlayService.save(WedulPlay.builder().title("안녕 이건 테스트야").user("강남 ").startAt(1242421424).endAt(23214124).build());
        wedulPlayService.save(WedulPlay.builder().title("안녕 이건 테스트야").user("강남 옵빠").startAt(1242421424).endAt(23214124).build());

    }
    @Test
    public void whenValidParameter_thenSuccessFind() {
        List<WedulPlay> list = wedulPlayService.findAll();

        list.forEach(System.out::println);
    }

    @Test
    public void whenValidParameter_thenSuccessFindByUser() {
        WedulPlay play = wedulPlayService.findByUser("강남");
        System.out.println(play);
        assertThat(play, is(IsNull.notNullValue()));
    }

}
