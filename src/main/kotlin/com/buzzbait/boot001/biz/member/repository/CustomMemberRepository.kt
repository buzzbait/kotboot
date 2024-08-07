package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.dto.SimpleMemberDto
import com.buzzbait.boot001.biz.member.entity.Member

interface CustomMemberRepository {
    fun getInlineMember(id :Long):List<Member>
    fun getSimpleInlineMember(id :Long):List<SimpleMemberDto>
}