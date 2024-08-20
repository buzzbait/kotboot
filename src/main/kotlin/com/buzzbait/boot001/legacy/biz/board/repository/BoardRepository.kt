package com.buzzbait.boot001.legacy.biz.board.repository

import com.buzzbait.boot001.legacy.biz.board.entity.BoardEntity
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID
/*
    findBy... 네이밍 규칙
    1. findBy 등의 예약어 사용
    2. Entity 의 필드 명을 사용(첫문자는 대문자로 시작)

*/
interface BoardRepository : JpaRepository<BoardEntity, Long>, KotlinJdslJpqlExecutor {

    fun findByUuid(uuid: UUID): BoardEntity?
}