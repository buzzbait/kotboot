package com.buzzbait.boot001.board.adapter.`in`.web

import com.buzzbait.boot001.board.adapter.`in`.dto.CreateBoardRequest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import mu.KotlinLogging
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import kotlin.test.Test

@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest@Autowired constructor(
    private var mockMvc : MockMvc,
    private val context : WebApplicationContext
){
    private val logger = KotlinLogging.logger {}

    @BeforeEach
    fun mockSetup()  {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @DisplayName("게시판 추가 테스트...")
    @Test
    fun addBoard(){
        val createBoardRequest = CreateBoardRequest("공지사항");
        val jsonBody = jacksonObjectMapper().writeValueAsString(createBoardRequest)

        mockMvc.perform(
            put("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBody))
            .andExpect(status().isOk());
    }

    @DisplayName("UUID 로 게시판 조회...")
    @Test
    fun getBoardByUuid(){

        val mockResult = mockMvc.perform(
            get("/board/01913603-5a85-874d-43ec-cdcf987b8519")
            .contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(status().isOk())
            .andReturn();

        //한글깨짐 방지
        mockResult.response.contentType  = "application/json;charset=UTF-8"

        logger.info ( "response :{}",  mockResult.response.contentAsString);
    }
}