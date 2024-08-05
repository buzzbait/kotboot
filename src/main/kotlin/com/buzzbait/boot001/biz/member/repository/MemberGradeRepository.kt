package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.MemberGrade
import org.springframework.data.jpa.repository.JpaRepository

interface MemberGradeRepository : JpaRepository<MemberGrade, Long> {
}