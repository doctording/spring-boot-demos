package com.example.demo.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @Author mubi
 * @Date 2019/7/10 12:12 AM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApiApplication.class)
@AutoConfigureMockMvc
@WebAppConfiguration
@Slf4j
public class TestControllerTest {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testTest() throws Exception{
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/test/alive")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("str", "abc")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String rs = result.getResponse().getContentAsString();
        log.info("rs:" + rs);
    }

    @Test
    public void testUserAll() throws Exception{
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/test/user/all")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String rs = result.getResponse().getContentAsString();
        log.info("rs:" + rs);
    }

    @Test
    public void testRecordLog() throws Exception{
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/test/record")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        String rs = result.getResponse().getContentAsString();
        log.info("rs:" + rs);
    }


}
