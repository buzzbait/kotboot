package com.buzzbait.boot001.biz.board.repository

import com.buzzbait.boot001.biz.board.entity.BoardEntity
import com.github.f4b6a3.ulid.UlidCreator
import com.linecorp.kotlinjdsl.support.spring.data.jpa.autoconfigure.KotlinJdslAutoConfiguration
import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import java.util.*
import kotlin.test.Test

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(
    KotlinJdslAutoConfiguration::class,
)
class BoardRepositoryTest @Autowired constructor(
    private  val boardRepository: BoardRepository
){
    private val logger = KotlinLogging.logger {}

    @DisplayName("게시판 종류 추가 ...")
    @Test
    fun addBoard(){
        //GIVEN
        val boardEntity =  BoardEntity("질문게시판");
        logger.info ( "UUID:{}", boardEntity.uuid.toString() )
        val returnEntity = boardRepository.save(boardEntity);
        //THEN
        assertThat(boardEntity.name).isEqualTo(returnEntity.name);
    }

    @DisplayName("게시판 종류 검색 ...")
    @Test
    fun findBoard(){
        //GIVEN
        val uuid  =  UUID.fromString("01913603-5a85-874d-43ec-cdcf987b8519")
        //WHEN
        val returnEntity = boardRepository.findByUuid(uuid)
        //THEN
        assertThat("질답게시판").isEqualTo(returnEntity?.name);
    }
}