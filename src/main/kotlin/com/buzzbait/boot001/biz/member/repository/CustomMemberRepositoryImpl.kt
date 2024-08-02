package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.ConfirmMember
import com.buzzbait.boot001.biz.member.entity.Member
import com.linecorp.kotlinjdsl.support.spring.data.jpa.repository.KotlinJdslJpqlExecutor
/*
    JDSL 구현하는 소스는 모두 XXXXRepositoryImpl 에서 구현
* */
class CustomMemberRepositoryImpl(
    private val kotlinJdslJpqlExecutor: KotlinJdslJpqlExecutor,
):CustomMemberRepository{
    //나를 추천한 회원 리스트
    override fun confirmMembers(id: Long): List<Member> {

        return kotlinJdslJpqlExecutor.findAll {
            select(entity(Member::class))
                .from(
                    entity(Member::class),
                    join(ConfirmMember::class).on(path(Member::id).equal(path(ConfirmMember::confirmid)))
                ).where(path(ConfirmMember::myId).equal(id))
        }.filterNotNull();
    }
}

