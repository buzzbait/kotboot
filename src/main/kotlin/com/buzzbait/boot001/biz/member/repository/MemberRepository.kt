package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository: JpaRepository<MemberEntity,Long> , CustomMemberRepository {

}