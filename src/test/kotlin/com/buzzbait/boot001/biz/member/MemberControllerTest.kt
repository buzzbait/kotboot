package com.buzzbait.boot001.biz.member

import com.buzzbait.boot001.biz.member.dto.AddMemberRequest
import com.buzzbait.boot001.biz.sample.dto.AddArticleRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import mu.KotlinLogging
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import kotlin.test.Test

@SpringBootTest
@AutoConfigureMockMvc
class MemberControllerTest @Autowired constructor(
    private var mockMvc : MockMvc,
    private val context : WebApplicationContext
){

    private val logger = KotlinLogging.logger {}

    @BeforeEach
    fun mockSetup()  {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @DisplayName("멤버 추가 테스트...")
    @Test
    fun addArticle(){
        val addMemberRequest = AddMemberRequest(0,"tesla01@email.com","일론머스크","테술라",1);
        val objectMapper = jacksonObjectMapper()
        val requestBody = objectMapper.writeValueAsString(addMemberRequest);

        mockMvc.perform(
            post("/member/new")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
            .andExpect(status().isOk());
    }

    @DisplayName("회원조회...")
    @Test
    fun findMember(){

        var response = mockMvc.perform(
            get("/member/1")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

        logger.info ( "res:{}",response.toString());
    }

    @DisplayName("추천 회원조회...")
    @Test
    fun findInlineMember(){

        var mockResult = mockMvc.perform(
            get("/member/inlineMember/1")
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andReturn();
        mockResult.response.contentType  = "application/json;charset=UTF-8"
        logger.info ( "response :{}",  mockResult.response.contentAsString);
    }
}