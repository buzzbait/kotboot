package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.Member

interface CustomMemberRepository {
    fun getInlineMember(id :Long):List<Member>
}