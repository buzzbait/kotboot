package com.buzzbait.boot001.biz.member

import com.buzzbait.boot001.biz.common.dto.BuzzResponse
import com.buzzbait.boot001.biz.member.dto.AddMemberRequest
import com.buzzbait.boot001.biz.member.dto.InlineMemberDto
import com.buzzbait.boot001.biz.member.dto.MemberGradeDto
import com.buzzbait.boot001.biz.member.dto.UpdateMemberRequest
import com.buzzbait.boot001.biz.member.entity.MemberEntity
import com.buzzbait.boot001.biz.member.entity.MemberGradeEntity
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
    ): MemberEntity {
        val findMember = memberRepository.findById(myId).get();

        return findMember;
    }


    /*
        Post 요청시 RequestBody는 DTO 로 받아와서 Service 에서 Entity 로 변환 한다
    * */
    @Transactional(readOnly = false)
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

    @Transactional(readOnly = false)
    fun updateMember(
        updateMemberRequest: UpdateMemberRequest
    ):BuzzResponse{

        var member = memberRepository.findById(updateMemberRequest.id).get();
        member.companyname = updateMemberRequest.companyName;

        return BuzzResponse("succ","수정 완료");
    }

    /*******************************************************************************************************************
        Custom Repository 를 구현한 경우
        장점 : DB 쿼리에 대한 작업이 분리되어 실제 비지니스 로직에 집중
              서비스 레이어 소스가 간결해 진다
        단점 : DB 접근이 필요할 때 마다 Custom Repository  에서 구현이 필요
              전체 비지니스 로직 파악시 서비스레이어와 레포지토리를 번갈아 가면서 확인
              (myBatis 의 단점을 그대로 유지)
     *******************************************************************************************************************/
    fun getInlineMember(
        myId : Long
    ): List<InlineMemberDto> {
        val findMemberList = memberRepository.getInlineMember(myId)
        //Entity -> Dto 변환
        val findMemberDtoList = findMemberList.map { et -> InlineMemberDto.fromEntity(et) }
        return findMemberDtoList;
    }

    /*******************************************************************************************************************
        JDSL 코드를 서비스 레이어에 구현한 경우
        repository 가 KotlinJdslJpqlExecutor 를 직접 상속 받아서 처리
        장점 : 서비스 레이어에서 쿼리의 비지니스 로직을 한번에 확인 가능
              바로 JDSL 로직을 추가 할 수 있다
        단점 : 서비스 레이어 소스가 방대해 진다
     *******************************************************************************************************************/
    @Transactional(readOnly = true)
    fun getMemberGrade(
        id : Long
    ): MemberGradeDto {

        /*
            Kotlin JDSL에서 제공하는 KotlinJdslJpqlExecutor 에서는 단일 조회함수가 별도로
            존재하지 않습니다. 그래서 만약 단일 데이터를 조회하려면 아래와 같이 Kotlin에서 제공하는
            List#firstOrNull ,List#first ,List#find 등의 함수를 사용해야 합니다
         */
        val memberGradeEntity = memberGradeRepository.findAll {
            select(entity(MemberGradeEntity::class))
                .from(entity(MemberGradeEntity::class))
                .whereAnd(
                    path(MemberGradeEntity::id).equal(id),
                )
        }.firstOrNull()

        return MemberGradeDto.fromEntity(memberGradeEntity);

    }

}