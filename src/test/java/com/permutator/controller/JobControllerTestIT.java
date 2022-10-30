package com.permutator.controller;


import com.permutator.model.entity.Job;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.permutator.util.TestUtils.toJson;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JobControllerTestIT {

    @Autowired
    MockMvc mockMvc;

    @Test
    void whenPostRequestForJobSave_thenCorrectResponse() throws Exception {
        //given
        var job = Job.builder()
                .fileName("test")
                .minLength(2)
                .maxLength(3)
                .stringAmount(3)
                .letters("abc").build();
        //when && then
        mockMvc.perform(post("/job/post").content(toJson(job))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fileName", equalTo("test")))
                .andExpect(jsonPath("$.minLength", equalTo(2)))
                .andExpect(jsonPath("$.maxLength", equalTo(3)))
                .andExpect(jsonPath("$.stringAmount", equalTo(3)))
                .andExpect(jsonPath("$.letters", equalTo("abc")));
    }
}
