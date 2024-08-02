package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.Member

interface CustomMemberRepository {
    fun confirmMembers(id :Long):List<Member>
}