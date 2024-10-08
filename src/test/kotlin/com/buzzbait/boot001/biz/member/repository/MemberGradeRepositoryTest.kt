package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.MemberGradeEntity
import com.buzzbait.boot001.config.MainDataSourceJpaConfig
import com.linecorp.kotlinjdsl.support.spring.data.jpa.autoconfigure.KotlinJdslAutoConfiguration
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import
import kotlin.test.Test
/*
    @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
    -> 단위테스트 기본 DB(in-memory H2) 를 사용하지 않고 어플리케이션에 설정한 DB를 사용
    위 선언을 하지 않으면 단위 테스트 기본 DB가 사용됨

    Kotlin JDSL 테스트를 위해 KotlinJdslAutoConfiguration Import

    @DataJpaTest 는 순수하게 JPA 에 관련된 Bean 들만 로딩함

    멀티 DataSource 설정이 포함된 경우는 해당 Configuration 클래스(MainDataSourceConfig)도 Import 해야 한다.
 */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(
    KotlinJdslAutoConfiguration::class,
    MainDataSourceJpaConfig::class
)
class MemberGradeRepositoryTest @Autowired constructor(
    private val memberGradeRepository: MemberGradeRepository
){
    @DisplayName("멤버등급 추가 테스트...")
    @Test
    fun addMemberGradeTest(){
        //GIVEN
        val gradeEntity = MemberGradeEntity("NONE","미등급");
        //WHEN
        val addEntity = memberGradeRepository.save(gradeEntity);
        //THEN
        assertThat(gradeEntity.grade).isEqualTo(addEntity.grade);
    }

    @DisplayName("멤버등급 단일조회 테스트...")
    @Test
    fun selectMemberGradeTest(){
        //GIVEN
        val gradeId = 1L;

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