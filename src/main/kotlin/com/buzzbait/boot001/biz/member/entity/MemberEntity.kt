package com.buzzbait.boot001.biz.member.entity

import jakarta.persistence.*


@Entity
@Table(name = "member", schema = "kotlin")
class MemberEntity (
    @Column(name = "email", nullable = true)
    var email : String,

    @Column(name = "name", nullable = true)
    var name : String,

    @Column(name = "companyname", nullable = true)
    var companyname : String,

    /*
        JoinColumn 정의시 nullable=true 로 설정 하면 MemberGrade 가 없는 member 는
        조회 가 안되기 때문에 JPA 가  left join 으로 쿼리를 생성
        실제 DB필드가 not null 이면 nullable=false 로 설정 하거나 @ManyToOne 어노테이션에 
        optional=false 를 설정 한다
        ManyToOne 사용시 페치전략 기본값은 즉시 로딩 이기 때문에 지연 로딩을 위해서 FetchType.LAZY 를 사용한다
        FetchType.LAZY 사용시 LAZY 로딩으로 인한 JSON 직렬화 오류 가 발생하는 경우가 있음
        이는 LAZY로 할 시 사용하지 않는 객체는 PROXY로 조회되어 JSON직렬화를 수행 할 수 없는 에러 이다
    */
    @ManyToOne(optional = false,fetch = FetchType.LAZY)
    @JoinColumn(name = "gradeid",nullable = false)
    var grade : MemberGradeEntity
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable= false)
    var  id :Long = 0;
}