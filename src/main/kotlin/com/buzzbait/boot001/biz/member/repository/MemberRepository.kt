package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.MemberEntity
import org.springframework.data.jpa.repository.JpaRepository
/*
    JDSL 쿼리를 서비스 단이 아닌 Repository 에 구현 하려면 커스텀 Repository 인터페이스를 만들고
    주 Repository 에서 해당 인터페이스를 상속 한다
 */
interface MemberRepository: JpaRepository<MemberEntity,Long> , CustomMemberRepository {

}