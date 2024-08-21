package com.buzzbait.boot001.infrastructure.dbms.master.jpa.repository


import com.buzzbait.boot001.infrastructure.dbms.master.jpa.entity.BoardEntity
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BoardJpaRepository : JpaRepository<BoardEntity, Long>, KotlinJdslJpqlExecutor {
    fun findByUuid(uuid: UUID): BoardEntity?
}