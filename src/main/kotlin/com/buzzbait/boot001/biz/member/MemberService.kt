package com.buzzbait.boot001.biz.member

import com.buzzbait.boot001.biz.member.entity.ConfirmMember
import com.buzzbait.boot001.biz.member.entity.Member
import com.buzzbait.boot001.biz.member.repository.MemberRepository
import org.springframework.stereotype.Service

@Service
class MemberService (
    private  val memberRepository: MemberRepository,
){
    fun getConfirmMember(
         myId : Long
    ): List<Member>? {

        return memberRepository.confirmMembers(myId);
    }
}