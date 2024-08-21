package com.buzzbait.boot001.infrastructure.dbms.master.jpa.repository

import com.buzzbait.boot001.config.MainDataSourceJpaConfig
import com.buzzbait.boot001.config.MainDataSourceMybatisConfig
import com.buzzbait.boot001.infrastructure.dbms.master.jpa.entity.CleanBoardEntity
import com.buzzbait.boot001.infrastructure.dbms.master.mybatis.mapper.CleanBoardMapper
import com.linecorp.kotlinjdsl.support.spring.data.jpa.autoconfigure.KotlinJdslAutoConfiguration
import mu.KotlinLogging
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import java.util.*
import kotlin.test.Test


@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(
    KotlinJdslAutoConfiguration::class,
    MainDataSourceJpaConfig::class,
    MainDataSourceMybatisConfig::class
)
class CleanBoardRepositoryTest@Autowired constructor(
    private  val boardRepository: CleanBoardRepository,
    private  val boardMapper: CleanBoardMapper
){
    private val logger = KotlinLogging.logger {}

    @DisplayName("게시판 종류 추가 ...")
    @Test
    fun addBoard(){
        //GIVEN
        val boardEntity =  CleanBoardEntity("질문게시판");
        logger.info ( "UUID:{}", boardEntity.uuid.toString() )
        val returnEntity = boardRepository.save(boardEntity)
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

    @DisplayName("myBatis 게시판 수 검색 ...")
    @Test
    fun findBoardCount(){
        val rowCount = boardMapper.selectBoardCnt();
        assertThat(2).isEqualTo(rowCount);
    }
}