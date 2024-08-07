package com.buzzbait.boot001.biz.member

import com.buzzbait.boot001.biz.common.dto.BuzzResponse
import com.buzzbait.boot001.biz.member.dto.AddMemberRequest
import com.buzzbait.boot001.biz.member.dto.InlineMemberDto
import com.buzzbait.boot001.biz.member.dto.InlineMemberResponse
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
    /*
        결과조회 리턴시 Entity 를 절대 넘기지 않는다.
        꼭 DTO 로 변환 하여 Response 에 넘긴다.
     */
    fun getInlineMember(
        myId : Long
    ): List<InlineMemberDto> {
        val findMemberList = memberRepository.getInlineMember(myId)
        //Entity -> Dto 변환
        val findMemberDtoList = findMemberList.map { et -> InlineMemberDto.fromEntity(et) }
        return findMemberDtoList;
    }

    /*
        Post 요청시 RequestBody는 DTO 로 받아와서 Service 에서 Entity 로 변환 한다
    * */
    @Transactional
    fun addMember(
        addMemberRequest: AddMemberRequest
    ):BuzzResponse{

        logger.info("grade...{}",addMemberRequest.gradeid);

        val grade = memberGradeRepository.findById(addMemberRequest.gradeid).get();
        //DTO -> Entity 변환
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