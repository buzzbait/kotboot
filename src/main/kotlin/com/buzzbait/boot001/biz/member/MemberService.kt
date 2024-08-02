package com.buzzbait.boot001.biz.member

import com.buzzbait.boot001.biz.common.dto.BuzzResponse
import com.buzzbait.boot001.biz.member.dto.UpdateMemberRequest
import com.buzzbait.boot001.biz.member.entity.ConfirmMember
import com.buzzbait.boot001.biz.member.entity.Member
import com.buzzbait.boot001.biz.member.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService (
    private  val memberRepository: MemberRepository,
){
    fun getConfirmMember(
         myId : Long
    ): List<Member>? {

        return memberRepository.confirmMembers(myId);
    }

    @Transactional
    fun updateMember(
        updateMemberRequest: UpdateMemberRequest
    ):BuzzResponse{

        var member = memberRepository.findById(updateMemberRequest.id).get();
        member.companyname = updateMemberRequest.companyName;

        return BuzzResponse("succ","수정 완료");
    }
}