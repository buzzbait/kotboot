package com.buzzbait.boot001.biz.board

import com.buzzbait.boot001.legacy.biz.board.dto.NewBoardDto
import com.buzzbait.boot001.legacy.biz.board.dto.UpdateBoardDto
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import mu.KotlinLogging
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext
import kotlin.test.Test

@SpringBootTest
@AutoConfigureMockMvc
class BoardControllerTest @Autowired constructor(
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
        val newBoardDto = NewBoardDto("공지사항");
        val objectMapper = jacksonObjectMapper()
        val requestBody = objectMapper.writeValueAsString(newBoardDto);

        mockMvc.perform(
            put("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
            .andExpect(status().isOk());
    }

    @DisplayName("게시판 수정 테스트...")
    @Test
    fun updateBoard(){
        val updateBoardDto = UpdateBoardDto("자주묻는질문","01913603-5a85-874d-43ec-cdcf987b8519");
        val objectMapper = jacksonObjectMapper()
        val requestBody = objectMapper.writeValueAsString(updateBoardDto);

        mockMvc.perform(
            post("/board")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
            .andExpect(status().isOk());
    }
}