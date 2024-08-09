package com.buzzbait.boot001.biz.member.repository

import com.buzzbait.boot001.biz.member.entity.MemberGradeEntity
import com.linecorp.kotlinjdsl.support.spring.data.jpa.autoconfigure.KotlinJdslAutoConfiguration
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.extensions.spring.SpringTestExtension
import io.kotest.extensions.spring.SpringTestLifecycleMode
import io.kotest.matchers.shouldBe
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Import

/*
    kotest 프레임워크를 이용한 단위테스트
    아래 의존성 추가 필요
    testImplementation("io.kotest:kotest-assertions-core-jvm:${kotestVersion}")
	testImplementation("io.kotest:kotest-runner-junit5-jvm:${kotestVersion}")
    testImplementation("io.kotest.extensions:kotest-extensions-spring:1.3.0")

    해당 테스트 실행을 위해서는 IntelliJ IDEA kotest 플러그인을 별도로 설치 해야 함

 */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@Import(
    KotlinJdslAutoConfiguration::class,
)
class MemberGradeRepositoryKoTest  @Autowired constructor(
    private val memberGradeRepository: MemberGradeRepository
): BehaviorSpec({

    //kotest 에서 트랜잭션은 Repository 에서 생성되는데 이는 Spring Test Context 에서 관리하는 트랜잭션 대상이 아님
    //Repository 는 @DataJpaTest 에 의해 생성된 빈으로 아래 설정으로 정상적으로 롤백이 되도록 설정
    extensions(SpringTestExtension(SpringTestLifecycleMode.Root))

    Given("신규멤버등급 생성") {
        val gradeEntity = MemberGradeEntity("NONE","미등급");

        When("신규멤버 등급 추가") {
            val addEntity = memberGradeRepository.save(gradeEntity);

            Then("신규멤버 등급이 신규 생성") {
                addEntity.grade shouldBe gradeEntity.grade
            }
        }
    }

})