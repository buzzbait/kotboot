package com.buzzbait.boot001.biz

import com.buzzbait.boot001.biz.entity.ConfirmMember
import com.buzzbait.boot001.biz.entity.Member
import com.buzzbait.boot001.biz.repository.MemberRepository
import com.linecorp.kotlinjdsl.querymodel.jpql.join.JoinType
import org.springframework.stereotype.Service

@Service
class MemberService (
    private  val memberRepository: MemberRepository,
){
    fun getConfirmMember(
         myId : Long
    ): List<Member>? {
        return memberRepository.findAll {
            select(entity(Member::class))
                .from(
                    entity(Member::class),
                    join(ConfirmMember::class).on(path(Member::id).equal(path(ConfirmMember::confirmid)))
                ).where(path(ConfirmMember::myId).equal(myId))
        }.filterNotNull();

    }
}