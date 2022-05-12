package com.rgbitsoft.app.web.controller;


import com.rgbitsoft.app.WebApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
//@WebAppConfiguration
//@EnableSpringConfigured
@WebMvcTest(HomeController.class)
public class HomeControllerTests {

//    @Autowired
//    private WebApplicationContext context;

    @Autowired
    private MockMvc mockMvc;

//    @Before
//    public void setup(){
////        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
//        this.mockMvc = MockMvcBuilders.standaloneSetup(new HomeController()).build();
//    }

    @Test
    public void homeTest() throws Exception {
        this.mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
