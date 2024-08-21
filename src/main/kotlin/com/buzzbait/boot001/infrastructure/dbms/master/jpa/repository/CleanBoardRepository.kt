package com.buzzbait.boot001.infrastructure.dbms.master.jpa.repository


import com.buzzbait.boot001.infrastructure.dbms.master.jpa.entity.CleanBoardEntity
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CleanBoardRepository : JpaRepository<CleanBoardEntity, Long>, KotlinJdslJpqlExecutor {
    fun findByUuid(uuid: UUID): CleanBoardEntity?
}