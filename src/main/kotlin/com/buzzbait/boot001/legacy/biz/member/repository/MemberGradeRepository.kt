package com.buzzbait.boot001.legacy.biz.member.repository

import com.buzzbait.boot001.legacy.biz.member.entity.MemberGradeEntity
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository

interface MemberGradeRepository : JpaRepository<MemberGradeEntity, Long> , KotlinJdslJpqlExecutor {
}