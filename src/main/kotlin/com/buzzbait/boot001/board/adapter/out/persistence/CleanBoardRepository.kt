package com.buzzbait.boot001.board.adapter.out.persistence


import com.buzzbait.boot001.board.adapter.out.persistence.entity.CleanBoardEntity
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CleanBoardRepository : JpaRepository<CleanBoardEntity, Long>, KotlinJdslJpqlExecutor {
    fun findByUuid(uuid: UUID): CleanBoardEntity?
}