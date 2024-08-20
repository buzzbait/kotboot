package com.buzzbait.boot001.legacy.biz.member.repository

import com.buzzbait.boot001.legacy.biz.member.dto.SimpleMemberDto
import com.buzzbait.boot001.legacy.biz.member.entity.MemberEntity

interface CustomMemberRepository {
    fun getInlineMember(id :Long):List<MemberEntity>
    fun getSimpleInlineMember(id :Long):List<SimpleMemberDto>
}