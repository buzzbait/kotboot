package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.MemberGradeEntity
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository

interface MemberGradeRepository : JpaRepository<MemberGradeEntity, Long> , KotlinJdslJpqlExecutor {
}