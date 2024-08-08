package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.MemberGradeEntity
import com.linecorp.kotlinjdsl.support.spring.data.jpa.autoconfigure.KotlinJdslAutoConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import kotlin.test.Test
/*
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    -> 단위테스트 기본 DB(in-memory H2) 를 사용하지 않고 어플리케이션에 설정한 DB를 사용
    위 선언을 하지 않으면 단위 테스트 기본 DB가 사용됨
 */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(
    KotlinJdslAutoConfiguration::class,
)
class MemberGradeRepositoryTest @Autowired constructor(
    private val memberGradeRepository: MemberGradeRepository
){

    @Test
    fun testSelectMemberGrade(){
        //GIVEN
        val gradeId = 11L;

        //WHEN
        val memberGradeEntity = memberGradeRepository.findAll {
            select(entity(MemberGradeEntity::class))
                .from(entity(MemberGradeEntity::class))
                .whereAnd(
                    path(MemberGradeEntity::id).equal(gradeId),
                )
        }.firstOrNull()

        //THEN
        assertThat(memberGradeEntity?.grade).isEqualTo("GOLD");
    }

}