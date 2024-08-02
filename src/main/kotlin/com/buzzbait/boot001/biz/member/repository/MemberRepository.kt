package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.Member
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<Member,Long> , CustomMemberRepository {

}