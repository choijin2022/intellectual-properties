package com.intellectual.memo.contoller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@WebMvcTest
class MemoContollerTest {

    @Autowired private MockMvc mockMvc;

    @Test
    @DisplayName("/테스트 요청시 memo 출력")
    void test() throws Exception {

        // expect
        mockMvc
                .perform(
                        post("/memo")
                                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                                .param("title", "글제목")
                                .param("content", "글 내용"))
                .andExpect(status().isOk())
                .andExpect(content().string("memo"))
                .andDo(MockMvcResultHandlers.print());
    }
}
