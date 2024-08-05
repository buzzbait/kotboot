package com.buzzbait.boot001.biz.member

import com.buzzbait.boot001.biz.common.dto.BuzzResponse
import com.buzzbait.boot001.biz.member.dto.AddMemberRequest
import com.buzzbait.boot001.biz.member.dto.UpdateMemberRequest
import com.buzzbait.boot001.biz.member.entity.ConfirmMember
import com.buzzbait.boot001.biz.member.entity.Member
import com.buzzbait.boot001.biz.member.repository.MemberGradeRepository
import com.buzzbait.boot001.biz.member.repository.MemberRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService (
    private  val memberRepository: MemberRepository,
    private val memberGradeRepository: MemberGradeRepository
){
    private val logger = KotlinLogging.logger {}

    fun getMember(
        myId : Long
    ): Member {
        val findMember = memberRepository.findById(myId).get();

        return findMember;
    }

    fun getConfirmMember(
         myId : Long
    ): List<Member> {
        val findMemberList = memberRepository.confirmMembers(myId)
        return findMemberList;
    }

    @Transactional
    fun addMember(
        addMemberRequest: AddMemberRequest
    ):BuzzResponse{

        logger.info("grade...{}",addMemberRequest.gradeid);

        val grade = memberGradeRepository.findById(addMemberRequest.gradeid).get();
        val newMember = addMemberRequest.toEntity(grade);
        memberRepository.save(newMember);

        return BuzzResponse("succ","추가 완료");
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