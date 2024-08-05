package com.buzzbait.boot001.biz.member.entity

import jakarta.persistence.*
import lombok.Setter


@Entity
@Table(name = "member", schema = "kotlin")
class Member (
    @Column(name = "email", nullable = true)
    var email : String,

    @Column(name = "name", nullable = true)
    var name : String,

    @Column(name = "companyname", nullable = true)
    var companyname : String,

    @ManyToOne
    @JoinColumn(name = "gradeid", nullable = true)
    var grade : MemberGrade
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable= false)
    var  id :Long = 0;
}