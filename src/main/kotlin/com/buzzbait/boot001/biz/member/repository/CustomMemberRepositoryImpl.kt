package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.dto.SimpleMemberDto
import com.buzzbait.boot001.biz.member.entity.ConfirmMemberEntity
import com.buzzbait.boot001.biz.member.entity.MemberEntity
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
/*
    JDSL 구현하는 소스는 모두 XXXXRepositoryImpl 에서 구현
* */
class CustomMemberRepositoryImpl(
    private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor,
):CustomMemberRepository{

    /*나를 추천한 회원 리스트
        Lazy 페치전략을 사용하는 Member 의 grade 객체에 대해서
        N+1 쿼리 수행을 방지 하고자 fetchJoin(Member::grade) 를 사용
    */
    override fun getInlineMember(id: Long): List<MemberEntity> {

        return kotlinJdslJpqlExecutor.findAll {
            select(entity(MemberEntity::class))
                .from(
                    entity(MemberEntity::class),
                    fetchJoin(MemberEntity::grade),
                    join(ConfirmMemberEntity::class).on(path(MemberEntity::id).equal(path(ConfirmMemberEntity::confirmid)))
                ).where(path(ConfirmMemberEntity::myId).equal(id))
        }.filterNotNull();
    }

    /*
        일반 DTO 의 list 를 반환 하기 위해서는 selectNew 를 사용
     */
    override fun getSimpleInlineMember(id: Long): List<SimpleMemberDto> {

        return kotlinJdslJpqlExecutor.findAll {
            selectNew<SimpleMemberDto>(
                    path(MemberEntity::id),
                    path(MemberEntity::name)
                )
                .from(
                    entity(MemberEntity::class),
                    join(ConfirmMemberEntity::class).on(path(MemberEntity::id).equal(path(ConfirmMemberEntity::confirmid)))
                ).where(path(ConfirmMemberEntity::myId).equal(id))
        }.filterNotNull();
    }
}

