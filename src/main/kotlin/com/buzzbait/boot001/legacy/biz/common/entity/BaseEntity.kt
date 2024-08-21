package com.buzzbait.boot001.legacy.biz.common.entity


import jakarta.persistence.*
import org.hibernate.proxy.HibernateProxy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.*

/*
    테이블의 PK 값을 UUID 로 생성하는 경우
    JPA 는  INSERT 시에 Entity 의 PK 가 NULL 인 경우 바로 신규 로 인식하여 INSERT 시작
    Entity 의 PK 가 NULL 이 아닌 경우는 중복 방지를 위해 SELECT 를 먼저 실행 후 INSERT 를 하기 때문에
    불필요한 쿼리가 발생
    UUID PK 는 JPA 영속화 되기 전에 값을 생성 해서 넘기기 때문에 신규 추가시 SELECT 가 먼저 수행됨
    이를 해결 하기 위해서는 Entity 를 Persistable 를 상속 받고 추가 작업이 필요함

    PK는 DB의 자동증가 필드를 사용해서 복잡성을 회피 하고 UUID 는 외부에 공개하는 검색키값으로 사용한다.
    프론트(화면) 에서 취급하는 데이터의 키값은 UUID 를 사용해서 자동증가 필드와 같이 쉽게 값을 추론 하는 것을 방지 한다.

    @LastModifiedDate 가 작동하기 위해서는 어플리케이션 설정에 @EnableJpaAuditing 를 추가 하고
    Entity 에 @EntityListeners(AuditingEntityListener::class) 를 추가 한다.

*/
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity{

    //공통 ID DB 자동증가 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable= false)
    var  id :Long = 0;

    //공통 수정일 필드
    @LastModifiedDate
    @Column(name = "UPDATE_DT")
    var updateDt: LocalDateTime = LocalDateTime.now()

    //공통 생성일 필드
    @CreatedDate
    @Column(name = "CREATE_DT", updatable = false)
    val createDt: LocalDateTime = LocalDateTime.now()

    override fun equals(other: Any?): Boolean {
        if (other == null) {
            return false
        }

        if (other !is HibernateProxy && this::class != other::class) {
            return false
        }

        return id == getIdentifier(other)
    }

    private fun getIdentifier(obj: Any): Any? {
        return if (obj is HibernateProxy) {
            obj.hibernateLazyInitializer.identifier
        } else {
            (obj as BaseEntity).id
        }
    }
    override fun hashCode() = Objects.hashCode(id)

}