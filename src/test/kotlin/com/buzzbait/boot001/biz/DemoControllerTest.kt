package com.buzzbait.boot001.biz

import com.buzzbait.boot001.biz.sample.dto.AddArticleRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType

import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import kotlin.test.Test

@SpringBootTest
@AutoConfigureMockMvc
class DemoControllerTest @Autowired constructor(
    private var mockMvc : MockMvc,
    private val context : WebApplicationContext)
{

    @DisplayName("블로그 추가 테스트...")
    @Test
    fun addArticle(){
        val addArticleRequest = AddArticleRequest("test","20240730-002");
        val objectMapper = jacksonObjectMapper()
        val requestBody = objectMapper.writeValueAsString(addArticleRequest);

        mockMvc.perform(post("/demo/article")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                        .andExpect(status().isOk());
    }

    @DisplayName("회원조회...")
    @Test
    fun findMember(){

        var response = mockMvc.perform(get("/demo/inlineMember")
            .contentType(MediaType.APPLICATION_JSON));


    }
    @BeforeEach
    fun mockSetup()  {
       mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
}