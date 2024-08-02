package com.buzzbait.boot001.biz.sample.entity


import jakarta.persistence.*

/*
    Entity 반드시 public또는 protected 의 no-argument 생성자를 가져야 한다
    일반적으로 코틀린에서는 롬복을 사용하지 않고 kotlin("plugin.jpa") 플러그인을 사용한다
    kotlin("plugin.jpa") 플러그인 은 @Entity, @Embeddable, @MappedSuperclass에 대해 
    noArg를 자동으로 적용해준다
    하이버네이트는 reflection 으로 객체를 생성하기 때문에 protected 이상의 생성자 필요

    Entity 는 final 클래스를 사용하면 안되지만 코틀린의 클래스는 기본이 final 이다.
    컴파일시 public 클래스로 만들어 주기 위해 kotlin("plugin.spring") 플러그인을 사용
    kotlin("plugin.spring") 플러그인 @Controller,@Service 등의 주요 컴포넌트들의 클래스를
    final 이 아닌 public 으로 컴파일 해준다
    public 클래스를 사용하는 이유는 프록시 기반의 lazy 로딩을 사용하기 위함
    (CGLIB 프록시 방식을 사용하기 위함)

    @Entity 는 기본 kotlin("plugin.spring") 플러그인 대상이 아니기 때문에 gradle 설정 파일에
    아래와 같이 추가 해줕다
    allOpen {
	    annotation("jakarta.persistence.Entity")
	    annotation("jakarta.persistence.MappedSuperclass")
	    annotation("jakarta.persistence.Embeddable")
    } 


* */
@Entity
@Table(name = "article", schema = "kotlin")
class Article(
    @Column(name = "title", nullable = true)
    var title : String,

    @Column(name = "contents", nullable = true)
    var contents : String
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable= false)
    var  id :Long = 0;
}